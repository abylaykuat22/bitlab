package bitlab.g111.springsecurity.controllers;

import bitlab.g111.springsecurity.models.User;
import bitlab.g111.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  private UserService userService;

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/")
  public String homePage() {
    return "home";
  }

  @PreAuthorize("isAnonymous()")
  @GetMapping("/signin")
  public String signinPage() {
    return "signin";
  }

  @PreAuthorize("isAnonymous()")
  @GetMapping("/signup")
  public String signupPage() {
    return "signup";
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/profile")
  public String profilePage(Model model) {
    User user = userService.getCurrentUser();
    model.addAttribute("currentUser", user);
    return "profile";
  }

  @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
  @GetMapping("/adminpanel")
  public String adminPanelPage() {
    return "adminpanel";
  }

  @PreAuthorize("isAnonymous()")
  @PostMapping("/signup")
  public String signup(
      @RequestParam(name = "email") String email,
      @RequestParam(name = "password") String password,
      @RequestParam(name = "re_password") String rePassword,
      @RequestParam(name = "full_name") String fullName
  ) {
    String value = userService.addUser(email, password, rePassword, fullName);
    return "redirect:/" + value;
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/updatepassword")
  public String updatepasswordPage() {
    return "updatepassword";
  }

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/updatepassword")
  public String updatepassword(
      @RequestParam(name = "current_password") String currentPassword,
      @RequestParam(name = "new_password") String newPassword,
      @RequestParam(name = "re_new_password") String reNewPassword
  ) {
    String value = userService.updatePassword(currentPassword, newPassword, reNewPassword);
    return "redirect:/" + value;
  }

  @GetMapping("/forbidden")
  public String forbidden() {
    return "403";
  }
}
