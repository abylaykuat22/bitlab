package bitlab.g111.springsecurity.services.impl;

import bitlab.g111.springsecurity.dtos.ItemCreate;
import bitlab.g111.springsecurity.dtos.ItemUpdate;
import bitlab.g111.springsecurity.dtos.ItemView;
import bitlab.g111.springsecurity.mappers.ItemMapper;
import bitlab.g111.springsecurity.models.Item;
import bitlab.g111.springsecurity.repositories.ItemRepository;
import bitlab.g111.springsecurity.services.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private ItemMapper itemMapper;

  @Override
  public List<ItemView> getItems() {
    List<Item> items = itemRepository.findAll();
    return itemMapper.toViewList(items);
  }

  @Override
  public ItemView getItem(Long id) {
    Item item = itemRepository.findById(id).orElseThrow();
    return itemMapper.toView(item);
  }

  @Override
  public ItemView addItem(ItemCreate itemCreate) {
    String key = itemCreate.getName() + " " + itemCreate.getDescription();
    Item item = itemMapper.toEntity(itemCreate);
    item.setKey(key);
    itemRepository.save(item);
    return itemMapper.toView(item);
  }

  @Override
  public ItemView updateItem(ItemUpdate itemUpdate) {
    String name = itemUpdate.getName();
    String description = itemUpdate.getDescription();
    Long id = itemUpdate.getId();
    Item item = itemRepository.findById(id).orElseThrow();
    if (name != null) {
      item.setName(name);
    }
    if (description != null) {
      item.setDescription(description);
    }
    itemRepository.save(item);
    return itemMapper.toView(item);
  }
}
