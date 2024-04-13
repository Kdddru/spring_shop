package com.dudu.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;


@Service
//itemRepository 사용 하기위해서
@RequiredArgsConstructor
public class ItemService {
  private final ItemRepository itemRepository;

  public List<Item> getItem(){

    return itemRepository.findAll();
  }

  public void saveItem(@ModelAttribute Item item){
    //ModelAttribute 는 setter가 없다면 null
    itemRepository.save(item);
  }

  public Optional<Item> findId(long id){
    return itemRepository.findById(id);
  }


}
