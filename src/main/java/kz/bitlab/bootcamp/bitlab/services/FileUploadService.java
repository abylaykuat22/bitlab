package kz.bitlab.bootcamp.bitlab.services;

import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.model.Picture;
import kz.bitlab.bootcamp.bitlab.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    boolean uploadProfilePicture(MultipartFile file, Courier courier);
}
