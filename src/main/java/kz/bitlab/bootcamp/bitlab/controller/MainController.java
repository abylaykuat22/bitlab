package kz.bitlab.bootcamp.bitlab.controller;
import kz.bitlab.bootcamp.bitlab.Courier.Courier;
import kz.bitlab.bootcamp.bitlab.services.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private LikesService likesService;
    @Autowired
    private FriendsService friendsService;
    @Value("${loadUrl}")
    private String loadUrl;

    @GetMapping(value = "/")
    public String startPage(Model model) {
        if (userService.getCurrentUser() != null) {
            return "index";
        }
        return "signin";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/signin")
    public String signinPage() {
        return "signin";
    }

    @GetMapping(value = "/forbidden")
    public String forbiddenPage() {
        return "forbidden";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile/{id}")
    public String profilePage(@PathVariable (name = "id") Long id, Model model) {
        model.addAttribute("avatarPicture", userService.avatarPicture(id));
        model.addAttribute("pictures", pictureService.getPictures());
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("array", userService.userData(id));
        model.addAttribute("news", newsService.userNews(id));
        model.addAttribute("userFriends", friendsService.getUserFriends(id));
        return "profile";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/editProfile")
    public String editProfilePage() {
        return "editProfile";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/news")
    public String newsPage(Model model){
        model.addAttribute("news", newsService.getNews());
        model.addAttribute("pictures", pictureService.getPictures());
        model.addAttribute("user", userService.getCurrentUser());
        model.addAttribute("avatarPicture", userService.avatarPicture(userService.getCurrentUser().getId()));
        model.addAttribute("users", userService.getAllUsers());
        return "news";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/friends")
    public String friendsPage(){
        return "friends";
    }

    @GetMapping(value = "/getPictures/{token}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getAvatar(@PathVariable(name = "token", required = false) String token) throws IOException {
        String pictureUrl = loadUrl + "default.jpg";
        if (token != null) {
            pictureUrl = loadUrl + token + ".jpg";
        }
        InputStream in = null;
        try {
            ClassPathResource resource = new ClassPathResource(pictureUrl);
            in = resource.getInputStream();
        } catch (Exception e) {
            pictureUrl = loadUrl + "default.jpg";
            e.printStackTrace();
        }
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/getDefaultAvatar", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getDefaultAvatar(@PathVariable(name = "token", required = false) String token) throws IOException {
        String pictureUrl = loadUrl + "default.jpg";
        if (token != null) {
            pictureUrl = loadUrl + token + ".jpg";
        }
        InputStream in = null;
        try {
            ClassPathResource resource = new ClassPathResource(pictureUrl);
            in = resource.getInputStream();
        } catch (Exception e) {
            pictureUrl = loadUrl + "default.jpg";
            e.printStackTrace();
        }
        return IOUtils.toByteArray(in);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/uploadAvatar")
    public String uploadAvatar(@RequestParam(name = "user_ava") MultipartFile file,
                               Courier courier){
        userService.deleteUserAvatar();
        if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
            fileUploadService.uploadProfilePicture(file, courier);
        }
        return "redirect:/profile/"+courier.getId();
    };

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/newPortfolioPhoto")
    public String newPhoto(@RequestParam(name = "id") Long id,
                           @RequestParam(name = "photo") MultipartFile file,
                           Courier courier){
        if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")) {
            fileUploadService.uploadProfilePicture(file, courier);
        }
        return "redirect:/profile/"+id;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/addNews")
    public String newPhoto(@RequestParam(name = "news_picture") MultipartFile file,
                           Courier courier){
        if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png") || file.isEmpty()) {
            newsService.addNews(file, courier);
        }

        return "redirect:/profile/"+userService.getCurrentUser().getId();
    }
}
