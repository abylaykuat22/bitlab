package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.model.Likes;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import kz.bitlab.bootcamp.bitlab.repositories.LikesRepository;
import kz.bitlab.bootcamp.bitlab.services.LikesService;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.RoleService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import liquibase.pro.packaged.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<UserDto> getLikedUsers(Long id) {
        Picture picture = pictureService.getPictureById(id);
        List<Likes> likes = allLikes();
        List<Likes> likesList = new ArrayList<>();
        for (Likes l : likes){
            if (l.getPicture()!=null){
                likesList.add(l);
            }
        }
        List<UserDto> likedUsers = new ArrayList<>();
        for (Likes l : likesList) {
            if (l.getPicture().getId().equals(picture.getId())) {
                likedUsers.add(userMapper.toDto(l.getUser()));
            }
        }
        return likedUsers;
    }

    @Override
    public List<Likes> allLikes() {
        return likesRepository.findAll();
    }

    @Override
    public List<Integer> amountLikesOnPicture(List<Picture> pictures) {
        List<Likes> likes = likesRepository.findAll();
        List<Likes> pictureLikes = new ArrayList<>();
        for (Likes l : likes){
            if (l.getPicture()!=null){
                pictureLikes.add(l);
            }
        }
        List<Integer> likesList = new ArrayList<>();
        int amount = 0;
        for (Picture p : pictures) {
            for (Likes l : pictureLikes) {
                if (l.getPicture().getId().equals(p.getId())) {
                    amount++;
                }
            }
            likesList.add(amount);
            amount=0;
        }
        return likesList;
    }

    @Override
    public void deletePicture(Long id) {
        List<Likes> likes = allLikes();
        Picture picture = pictureService.getPictureById(id);
        for (Likes l: likes){
            if (l.getPicture()!=null){
                if (l.getPicture().getId().equals(picture.getId())){
                    likesRepository.delete(l);
                }
            }
        }
        pictureService.deletePicture(id);
    }

    @Override
    public void saveLike(Likes like) {
        likesRepository.save(like);
    }

    @Override
    public void deleteLike(Likes like) {
        likesRepository.delete(like);
    }
}
