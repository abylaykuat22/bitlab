package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;

import java.util.List;


public interface FriendsService {
    void addFriend(Courier courier);
    Courier getFriendsList();
    List<UserDto> getUserFriends(Long id);
    Courier getUnknownUsers();

    Courier getFriendRequests();
    void confirmAddFriend(Courier courier);
    void cancelRequest(Courier courier);
}
