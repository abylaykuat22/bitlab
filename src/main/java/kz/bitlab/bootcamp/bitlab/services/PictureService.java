package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;

import java.util.List;

public interface PictureService {
    List<Picture> getPictures();
    List<Picture> getPicturesById(List<Long> id);
    Picture updateProfilePicture(Picture picture);
    void deletePic(Long id);
    Picture getPictureById(Long id);
    void deletePicture(Long id);
}
