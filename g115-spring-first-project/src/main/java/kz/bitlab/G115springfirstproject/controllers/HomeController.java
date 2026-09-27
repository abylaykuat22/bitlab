package kz.bitlab.G115springfirstproject.controllers;

import java.util.List;
import kz.bitlab.G115springfirstproject.db.DBManager;
import kz.bitlab.G115springfirstproject.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @GetMapping("/") //@WebServlet(value="/")
  public String homePage(Model model) {
    List<Item> items = DBManager.getItems();
    model.addAttribute("veshy", items); // req.setAttribute("veshy", items);
    return "home"; //req.getRequestDispatcher(home.jsp).forward(req, resp)
  }

  @PostMapping("add-item") //@WebServlet(value="/add-item")
  public String addItem(Item item) {
    System.out.println(item);
    DBManager.addItem(item);
    return "redirect:/"; //resp.sendRedirect("/")
  }
}
