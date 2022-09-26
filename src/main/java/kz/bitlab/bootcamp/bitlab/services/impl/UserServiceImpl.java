package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.PictureMapper;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.model.*;
import kz.bitlab.bootcamp.bitlab.repositories.PictureRepository;
import kz.bitlab.bootcamp.bitlab.repositories.UserRepository;
import kz.bitlab.bootcamp.bitlab.services.LikesService;
import kz.bitlab.bootcamp.bitlab.services.NewsService;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LikesService likesService;

    @Autowired
    private PictureService pictureService;
    @Autowired
    private PictureMapper pictureMapper;

    @Value("${targetUrl}")
    private String targetUrl;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }


    @Override
    public Courier userData(Long id) {
        List<Picture> pictures = pictureService.getPictures();
        List<Picture> pictureList = new ArrayList<>();
        for (Picture p : pictures){
            if (p.getUser().getId().equals(id)) {
                pictureList.add(p);
            }
        }

        List<Integer> likesList = likesService.amountLikesOnPicture(pictureList);
        List<Likes> likes = likesService.allLikes();
        List<Likes> pictureLikes = new ArrayList<>();
        for (Likes l : likes){
            if (l.getPicture()!=null){
                pictureLikes.add(l);
            }
        }

        List<User> userList = new ArrayList<>();
        for (Picture p : pictures){
            for (Likes l : pictureLikes){
                if (l.getPicture().getId().equals(p.getId())){
                    userList.add(l.getUser());
                }
            }
        }

        Courier courier = new Courier();
        courier.setPictureList(pictureList);
        courier.setAmountLikesOnPicture(likesList);
        courier.setUsers(userMapper.toDtoList(userList));
        courier.setUser(userRepository.findById(id).orElseThrow());
        return courier;
    }


    @Override
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            return (User) authentication.getPrincipal();
        }
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    public void deleteUserAvatar() {
        User user = getCurrentUser();
        List<Picture> pictures = pictureService.getPictures();
        for (Picture p : pictures){
            if (p.getUser()!=null){
                if (p.getUser().getId().equals(user.getId()) && p.getRolePicture().equals("ROLE_PROFILE")){
                    pictureService.deletePicture(p.getId());
                }
            }
        }
    }

    @Override
    public List<PictureDto> getUsersAvatars() {
        List<Picture> pictures = pictureService.getPictures();
        List<User> users = userMapper.toEntityList(getAllUsers());
        List<Picture> usersAvatarsList = new ArrayList<>();
        for (Picture p : pictures){
            for (User u : users){
                if (p.getUser()!=null){
                    if (p.getUser().getId().equals(u.getId()) && p.getRolePicture().equals("ROLE_PROFILE")){
                        usersAvatarsList.add(p);
                    }
                }
            }
        }
        return pictureMapper.toDtoList(usersAvatarsList);
    }

    @Override
    public UserDto getUserDto(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Picture addUser(Courier courier) {
        if (userRepository.findByEmail(courier.getEmail())==null){
            User newUser = new User();
            newUser.setEmail(courier.getEmail());
            newUser.setPassword(passwordEncoder.encode(courier.getPassword()));
            newUser.setFullName(courier.getFullName());
            newUser.setBirthdate(courier.getBirthdate());
            newUser.setGender(courier.getGender());
            newUser.setCodeWord(courier.getCodeWord());
            newUser.setStatusAvatar("null");
            newUser.setStatusFriends("null");
            List<Role> roles = new ArrayList<>();
            Role role = new Role();
            role.setId(2L);
            roles.add(role);
            newUser.setRoles(roles);
            userRepository.save(newUser);
        }
        return null;
    }

    @Override
    public User changePassword(Courier courier) {
        User currentUser = getCurrentUser();
        if (currentUser!=null && passwordEncoder.matches(courier.getCurrentPassword(), currentUser.getPassword()) && !courier.getCurrentPassword().equals(courier.getNewPassword())){
            currentUser.setPassword(passwordEncoder.encode(courier.getNewPassword()));
            return userRepository.save(currentUser);
        }
        return null;

    }

    @Override
    public UserDto checkCodeWord(Courier courier) {
        if (userRepository.findByEmail(courier.getEmail())!=null){
            if (userRepository.findByEmail(courier.getEmail()).getCodeWord().equals(courier.getCodeWord())){
                return userMapper.toDto(userRepository.findByEmail(courier.getEmail()));
            }
        }
        return null;
    }

    @Override
    public UserDto resetAddNewPassword(Courier courier) {
        User user = userRepository.findByEmail(courier.getEmail());
        user.setPassword(passwordEncoder.encode(courier.getNewPassword()));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByEmail(username);
        if (user!=null){
            return user;
        }
        throw new UsernameNotFoundException("User not found!");
    }

    @Override
    public Picture getCurrentUserPicture() {
        List<Picture> pictures = pictureService.getPictures();
        User user = getCurrentUser();
        Picture picture = new Picture();
        for (Picture p : pictures){
            if (p.getUser().getId().equals(user.getId()) && p.getRolePicture().equals("ROLE_PROFILE")){
                picture = p;
            }
        }
        return picture;
    }

    @Override
    public Picture avatarPicture(Long id) {
        List<Picture> pictures = pictureService.getPictures();
        for (Picture p: pictures){
            if (p.getUser().getId().equals(id) && p.getRolePicture().equals("ROLE_PROFILE")){
                return p;
            }
        }
        return null;
    }

    @Override
    public String addDeleteLike(Long pictureId) {
        List<Likes> likes = likesService.allLikes();
        List<Likes> pictureLikes = new ArrayList<>();
        for (Likes l : likes){
            if (l.getPicture()!=null){
                pictureLikes.add(l);
            }
        }

        Picture picture = pictureService.getPictureById(pictureId);
        int amount = picture.getAmountLikes();
        for (Likes l : pictureLikes){
            if (l.getPicture().getId().equals(picture.getId()) && l.getUser().getId().equals(getCurrentUser().getId())){
                amount = amount -1;
                picture.setAmountLikes(amount);
                likesService.deleteLike(l);
                return "delete";
            }
        }
        amount = amount +1;
        picture.setAmountLikes(amount);
        Likes like = new Likes();
        like.setPicture(picture);
        like.setUser(getCurrentUser());
        likesService.saveLike(like);
        return "add";
    }

    @Override
    public Courier pictureLikes() {
        Courier courier = new Courier();
        courier.setPictures(pictureService.getPictures());
        List<Likes> likes = likesService.findAllByUser(getCurrentUser());
        List<Picture> pictures = pictureService.getPictures();
//        for (Likes l : likes){
//            if (pictures.contains(l.getPicture())){
//                courier.setCheck(true);
//            }else{
//                courier.setCheck(false);
//            }
//        }
        return courier;
    }

}
