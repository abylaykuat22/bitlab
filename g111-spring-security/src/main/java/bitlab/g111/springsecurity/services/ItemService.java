package bitlab.g111.springsecurity.services;

import bitlab.g111.springsecurity.dtos.ItemCreate;
import bitlab.g111.springsecurity.dtos.ItemUpdate;
import bitlab.g111.springsecurity.dtos.ItemView;
import bitlab.g111.springsecurity.models.Item;
import java.util.List;

public interface ItemService {

  List<ItemView> getItems();

  ItemView getItem(Long id);

  ItemView addItem(ItemCreate itemCreate);

  ItemView updateItem(ItemUpdate itemUpdate);
}
