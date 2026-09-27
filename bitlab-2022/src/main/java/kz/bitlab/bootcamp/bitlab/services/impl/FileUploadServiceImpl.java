package kz.bitlab.bootcamp.bitlab.services.impl;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import kz.bitlab.bootcamp.bitlab.services.FileUploadService;

import kz.bitlab.bootcamp.bitlab.services.PictureService;
import kz.bitlab.bootcamp.bitlab.services.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Autowired
    private PictureService pictureService;
    @Autowired
    private UserService userService;
    @Value("${targetUrl}")
    private String targetUrl;

    @Override
    public boolean uploadProfilePicture(MultipartFile file, Courier courier) {
        try {
            Picture picture = new Picture();
            picture.setUser(userService.getCurrentUser());
            picture.setPicture("empty");
            picture.setRolePicture("empty");
            picture.setAmountLikes(0);
            pictureService.updateProfilePicture(picture);
            String fileToken = DigestUtils.sha1Hex(picture.getId()+ "_#!?");
            String fileName = fileToken+".jpg";
            byte bytes[] = file.getBytes();
            Path path = Paths.get(targetUrl+"/", fileName);
            Files.write(path, bytes);
            Picture newPicture = pictureService.getPictureById(picture.getId());
            if (courier.getRolePicture().equals("ROLE_PROFILE")){
                picture.setRolePicture("ROLE_PROFILE");
                userService.getCurrentUser().setStatusAvatar(fileToken);
            }else if (courier.getRolePicture().equals("ROLE_PORTFOLIO")){
                picture.setRolePicture("ROLE_PORTFOLIO");
            }
            newPicture.setPicture(fileToken);
            User user = userService.getCurrentUser();
            userService.updateUser(user);
            pictureService.updateProfilePicture(picture);

        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

}
