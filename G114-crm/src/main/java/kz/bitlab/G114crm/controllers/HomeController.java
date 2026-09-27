package kz.bitlab.G114crm.controllers;

import java.util.Set;
import kz.bitlab.G114crm.models.ApplicationRequest;
import kz.bitlab.G114crm.services.ApplicationRequestService;
import kz.bitlab.G114crm.services.RoleService;
import kz.bitlab.G114crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @Autowired
  private ApplicationRequestService applicationRequestService;
  @Autowired
  private UserService userService;
  @Autowired
  private RoleService roleService;

  @GetMapping("/")
  public String homePage(Model model) {
    model.addAttribute("zayavki", applicationRequestService.getAppReqs());
    model.addAttribute("users", userService.getUsers());
    return "home";
  }

  @GetMapping("details/{id}")
  public String detailsPage(@PathVariable Long id, Model model) {
    model.addAttribute("appReq", applicationRequestService.getAppReqById(id));
    model.addAttribute("users", userService.getUsers());
    return "details";
  }

  @PostMapping("addAppReq")
  public String addAppReq(ApplicationRequest appReq) {
    applicationRequestService.addAppReq(appReq);
    return "redirect:/";
  }

  @PostMapping("updateHandled/{id}")
  public String updateHandled(@PathVariable Long id) {
    applicationRequestService.updateHandled(id);
    return "redirect:/";
  }

  @PostMapping("editAppReq")
  public String editApplicationRequest(ApplicationRequest appReq) {
    applicationRequestService.editAppReq(appReq);
    return "redirect:/details/" + appReq.getId();
  }

  @PostMapping("deleteAppReq/{id}")
  public String deleteApplicationRequest(@PathVariable Long id) {
    applicationRequestService.deleteAppReqById(id);
    return "redirect:/";
  }

  @GetMapping("admin-panel")
  public String adminPanel(Model model) {
    model.addAttribute("users", userService.getUsers());
    model.addAttribute("allRoles", roleService.getRoles());
    return "admin-panel";
  }

  @PostMapping("addRole")
  public String addRoleToUser(@RequestParam(name = "user_id") Long userId,
      @RequestParam(name = "role_id") Long roleId) {
    userService.addRoleToUser(userId, roleId);
    return "redirect:/admin-panel";
  }

  @PostMapping("addRoles")
  public String addRolesToUser(@RequestParam(name = "role_ids", required = false) Set<Long> roleIds,
      @RequestParam(name = "user_id") Long userId) {
    int result = userService.addRolesToUser(roleIds, userId);
    return "redirect:/user-details/"+userId + "?error="+result;
  }

  @PostMapping("deleteRole")
  public String deleteRoleFromUser(@RequestParam(name = "user_id") Long userId,
      @RequestParam(name = "role_id") Long roleId) {
    userService.deleteRoleFromUser(userId, roleId);
    return "redirect:/user-details/"+userId;
  }

  @GetMapping("user-details/{id}")
  public String userDetails(@PathVariable Long id, Model model) {
    model.addAttribute("user", userService.getUserById(id));
    model.addAttribute("roles", roleService.getRoles());
    return "user-details";
  }
}
