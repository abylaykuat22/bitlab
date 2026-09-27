package kz.bitlab.G114springfirstapp.controllers;

import kz.bitlab.G114springfirstapp.db.DBManager;
import kz.bitlab.G114springfirstapp.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @GetMapping("/") // @WebServlet(value = "/") + doGet()
  public String homePage(Model model) {
    model.addAttribute("items", DBManager.getItems()); // req.setAttribute("zat", item)
    return "home"; // req.getRequestDispatcher("home.jsp").forward(req, resp)
  }

  @PostMapping("/add-item")
  public String addItem(Item item) {
    DBManager.addItem(item);
    return "redirect:/"; //resp.sendRedirect("/")
  }

  @GetMapping("/details/{itemId}")
  public String itemDetails(@PathVariable(name = "itemId") Long id, Model model) {
    Item item = DBManager.getItemById(id);
    model.addAttribute("zat", item);
    return "details";
  }

  @PostMapping("/edit-item/{id}")
  public String editItem(@PathVariable Long id,
      @RequestParam(name = "item_name") String name,  // req.getParameter("item_name")
      @RequestParam(name = "item_description") String description, // req.getParameter("item_description")
      @RequestParam(name = "item_price") double price, // req.getParameter("item_price")
      @RequestParam(name = "item_category") String category) {
    Item item = DBManager.getItemById(id);
    item.setName(name);
    item.setPrice(price);
    item.setDescription(description);
    item.setCategory(category);
    return "redirect:/details/"+id;
  }

  @PostMapping("/delete-item/{id}")
  public String deleteItem(@PathVariable Long id) {
    DBManager.deleteItemById(id);
    return "redirect:/";
  }
}
