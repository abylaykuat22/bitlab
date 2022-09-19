package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.model.Likes;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;

import java.util.List;

public interface LikesService {
    List<UserDto> getLikedUsers(Long id);
    List<Likes> allLikes();
    List<Integer> amountLikesOnPicture(List<Picture> pictures);
    void deletePicture(Long id);
    void saveLike(Likes like);
    void deleteLike(Likes like);
}
