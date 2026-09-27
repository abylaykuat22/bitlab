package kz.bitlab.G115rest.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureService {
  @Autowired
  private ItemService itemService;
  @Value("${targetPictureUrl}")
  private String targetPictureUrl;

  public void addPicture(MultipartFile picture, Long itemId) throws IOException {
    itemService.addPicture(picture, itemId);
    byte[] bytes = picture.getBytes();
    Path path = Paths.get(targetPictureUrl, picture.getOriginalFilename());
    Files.write(path, bytes);
  }
}
