package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;

import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.PictureMapper;
import kz.bitlab.bootcamp.bitlab.mapper.UserMapper;
import kz.bitlab.bootcamp.bitlab.model.Friends;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import kz.bitlab.bootcamp.bitlab.repositories.FriendsRepository;
import kz.bitlab.bootcamp.bitlab.services.FriendsService;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsServiceImpl implements FriendsService {
    @Autowired
    private FriendsRepository friendsRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private PictureMapper pictureMapper;
    @Override
    public void addFriend(Courier courier) {
        Friends friends = new Friends();
        friends.setUserSenderId(courier.getUserSenderId());
        friends.setUserRecipientId(courier.getUserRecipientId());
        friends.setStatus("requests");

        List<User> newFriends = new ArrayList<>();
        newFriends.add(userService.getUserById(courier.getUserSenderId()));
        newFriends.add(userService.getUserById(courier.getUserRecipientId()));
        friends.setUsers(newFriends);
        friendsRepository.save(friends);
    }

    @Override
    public Courier getFriendsList() {
        Courier courier = new Courier();
        List<Friends> friends = friendsRepository.findAll();
        List<Friends> friendsList = new ArrayList<>();
        List<User> users = new ArrayList<>();

        for (Friends f : friends){
            for (User u : f.getUsers()){
                if (f.getStatus().equals("friends")){
                    if (u.getId().equals(userService.getCurrentUser().getId())){
                        friendsList.add(f);
                    }
                }
            }
        }

        for (Friends f : friendsList){
            for (User user : f.getUsers()){
                if (!(user.getId().equals(userService.getCurrentUser().getId()))){
                    users.add(user);
                }
            }
        }
        courier.setUsers(userMapper.toDtoList(users));


        List<Picture> pictures = pictureService.getPictures();
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
        courier.setGetUsersAvatars(pictureMapper.toDtoList(usersAvatarsList));
        courier.setCurrentUser(userService.getCurrentUser());
        return courier;
    }

    @Override
    public List<UserDto> getUserFriends(Long id) {
        List<Friends> friends = friendsRepository.findAll();
        User user = userService.getUserById(id);
        List<Friends> friendsList = new ArrayList<>();
        for (Friends f : friends){
            if (f.getUsers().contains(user) && f.getStatus().equals("friends")){
                friendsList.add(f);
            }
        }
        List<User> userList = new ArrayList<>();
        for (Friends f : friendsList){
            for (User u : f.getUsers()){
                if (!u.getId().equals(user.getId())){
                    userList.add(u);
                }
            }
        }
        return userMapper.toDtoList(userList);
    }

    @Override
    public Courier getUnknownUsers() {
        Courier courier = new Courier();
        List<User> users = userMapper.toEntityList(userService.getAllUsers());
        List<Friends> friends = friendsRepository.findAll();

        List<Friends> friendsList = new ArrayList<>();
        for (Friends f : friends){
            for (User u : f.getUsers()){
                if (u.getId().equals(userService.getCurrentUser().getId())){
                    friendsList.add(f);
                }
            }
        }

        List<Long> userId = new ArrayList<>();
        for (Friends f : friendsList){
            for (User u : f.getUsers()){
                if (!u.getId().equals(userService.getCurrentUser().getId())){
                    userId.add(u.getId());
                }
            }
        }

        List<User> userList = new ArrayList<>();
        for (User u : users){
            if (!userId.contains(u.getId())){
                userList.add(u);
            }
        }

        courier.setUsers(userMapper.toDtoList(userList));

        List<Picture> pictures = pictureService.getPictures();
        List<Picture> usersAvatarsList = new ArrayList<>();
        for (Picture p : pictures){
            for (User u : userList){
                if (p.getUser()!=null){
                    if (p.getUser().getId().equals(u.getId()) && p.getRolePicture().equals("ROLE_PROFILE")){
                        usersAvatarsList.add(p);
                    }
                }
            }
        }
        courier.setGetUsersAvatars(pictureMapper.toDtoList(usersAvatarsList));

        courier.setCurrentUser(userService.getCurrentUser());

        return courier;
    }

    @Override
    public Courier getFriendRequests() {
        Courier courier = new Courier();
        List<Friends> friends = friendsRepository.findAll();
        List<Friends> friendsList = new ArrayList<>();
        List<User> users = new ArrayList<>();
        for (Friends f : friends){
            for (User u : f.getUsers()){
                if (f.getStatus().equals("requests")){
                    if (u.getId().equals(userService.getCurrentUser().getId())){
                        friendsList.add(f);
                    }
                }
            }
        }
        List<Long> userSenderIdList = new ArrayList<>();
        for (Friends f : friendsList){
            if (f.getUserSenderId()!=null){
                userSenderIdList.add(f.getUserSenderId());
            }
        }
        courier.setUserSenderIdList(userSenderIdList);

        for (Friends f : friendsList){
            for (User user : f.getUsers()){
                if (!(user.getId().equals(userService.getCurrentUser().getId()))){
                    users.add(user);
                }
            }
        }
        courier.setUsers(userMapper.toDtoList(users));

        List<Picture> pictures = pictureService.getPictures();
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
        courier.setGetUsersAvatars(pictureMapper.toDtoList(usersAvatarsList));
        courier.setCurrentUser(userService.getCurrentUser());
        return courier;
    }

    @Override
    public void confirmAddFriend(Courier courier) {
        List<Friends> friends = friendsRepository.findAll();
        for (Friends f : friends){
            if (f.getUsers().contains(userService.getUserById(courier.getUserRecipientId())) && f.getUsers().contains(userService.getUserById(courier.getUserSenderId()))){
                f.setStatus("friends");
                friendsRepository.save(f);
            }
        }
        User user = userService.getUserById(courier.getUserSenderId());
        User user2 = userService.getUserById(courier.getUserRecipientId());
        user.setStatusFriends("notNull");
        user2.setStatusFriends("notNull");
        userService.updateUser(user);
        userService.updateUser(user2);
    }

    @Override
    public void cancelRequest(Courier courier) {
        List<Friends> friends = friendsRepository.findAll();
        List<User> userList = new ArrayList<>();
        userList.add(userService.getUserById(courier.getUserSenderId()));
        userList.add(userService.getUserById(courier.getUserRecipientId()));
        for (Friends f : friends){
            if ((courier.getUserRecipientId().equals(f.getUserSenderId()) && courier.getUserSenderId().equals(f.getUserRecipientId())) || (courier.getUserRecipientId().equals(f.getUserRecipientId()) && courier.getUserSenderId().equals(f.getUserSenderId()))){
                friendsRepository.delete(f);
            }
        }
    }
}
