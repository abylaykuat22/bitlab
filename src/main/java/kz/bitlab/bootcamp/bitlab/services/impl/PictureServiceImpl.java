package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.dto.PictureDto;
import kz.bitlab.bootcamp.bitlab.dto.UserDto;
import kz.bitlab.bootcamp.bitlab.mapper.PictureMapper;
import kz.bitlab.bootcamp.bitlab.model.Likes;
import kz.bitlab.bootcamp.bitlab.model.News;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import kz.bitlab.bootcamp.bitlab.repositories.PictureRepository;
import kz.bitlab.bootcamp.bitlab.repositories.UserRepository;
import kz.bitlab.bootcamp.bitlab.services.LikesService;
import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import liquibase.pro.packaged.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public List<Picture> getPictures() {
        return pictureRepository.findAll();
    }

    @Override
    public void deletePic(Long id) {
        pictureRepository.deleteById(id);
    }



    @Override
    public Picture getPictureById(Long id) {
        return pictureRepository.findById(id).orElseThrow();
    }

    @Override
    public void deletePicture(Long id) {
        pictureRepository.deleteById(id);
    }


    @Override
    public List<Picture> getPicturesById(List<Long> picturesId) {
        List<Picture> pictures = getPictures();
        List<Picture> pictureList = new ArrayList<>();
        for (Long id : picturesId){
            for (Picture p: pictures){
                if (id.equals(p.getId())){
                    pictureList.add(p);
                }
            }
        }
        return pictureList;
    }

    @Override
    public Picture updateProfilePicture(Picture picture) {
        return pictureRepository.save(picture);
    }
}
