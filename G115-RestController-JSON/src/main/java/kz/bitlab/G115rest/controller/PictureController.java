package kz.bitlab.G115rest.controller;

import java.io.IOException;
import java.io.InputStream;
import kz.bitlab.G115rest.service.PictureService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PictureController {

  @Autowired
  private PictureService pictureService;

  @Value("${loadPictureUrl}")
  private String loadPictureUrl;

  @PostMapping("/addPicture")
  public String addPicture(MultipartFile picture, @RequestParam(name = "id") Long itemId)
      throws IOException {
    pictureService.addPicture(picture, itemId);
    return "redirect:/";
  }

  @GetMapping(value = "/getPicture/{picture}", produces = MediaType.IMAGE_JPEG_VALUE)
  public @ResponseBody byte[] getPicture(@PathVariable String picture) throws IOException {
    InputStream in = new ClassPathResource(loadPictureUrl + picture).getInputStream();
    return IOUtils.toByteArray(in);
  }
}
