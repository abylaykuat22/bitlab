package kz.bitlab.beans.controllers;

import kz.bitlab.beans.models.Item;
import kz.bitlab.beans.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  @Autowired
  @Qualifier("itemService")
  private ItemService itemService;

  @Autowired
  @Qualifier("itemServiceEmail")
  private ItemService itemServiceEmail;

  @GetMapping("/")
  public String homePage() {
    itemService.addItem(new Item(10L, "Tesla model y", 12, 23.4));
    itemServiceEmail.addItem(new Item(10L, "Tesla model y", 12, 23.4));

    return null;
  }
}
