package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;


public interface FriendsService {
    void addFriend(Courier courier);
    Courier getFriendsList();
    Courier getFriendRequests();
    void confirmAddFriend(Courier courier);
}
