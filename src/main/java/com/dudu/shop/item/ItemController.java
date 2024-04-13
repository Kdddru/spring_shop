package com.dudu.shop.item;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//Rombook
//itemRepository 사용 하기위해서
@RequiredArgsConstructor
public class ItemController {

  private final ItemRepository itemRepository;
  private  final ItemService itemService;


  @GetMapping("/list")
  String list(Model model){

    List<Item> result = itemService.getItem();
    model.addAttribute("items",result);


    return "list.html";
  }

  @GetMapping("/write")
  String write(){


    return "write.html";
  }


  //아이템 추가 페이지
  @PostMapping("/add")
  String addPost(@ModelAttribute Item item){
    //ModelAttribute 는 setter가 없다면 null

    itemService.saveItem(item);

    return "redirect:/list";
  }
  
  
  //상세페이지
  @GetMapping("/detail/{id}")
  String detail(@PathVariable long id, Model model){

      //optional => define || null
      Optional<Item> result = itemService.findId(id);

      if( result.isPresent() ){
        model.addAttribute("data",result.get());

        return "detail.html";

      }
      else{
        return "redirect:/list";
      }

  }

  @GetMapping("/edit/{id}")
  String edit(Model model, @PathVariable long id){

    Optional<Item> result = itemRepository.findById(id);

    if(result.isPresent()){
      model.addAttribute("data",result.get());

      return "edit.html";
    }
    else {

      return "redirect:/list";
    }
  }

  @PostMapping("/edit")
  String updata(@ModelAttribute Item item){


    itemRepository.save(item);

    return "redirect:/list";
  }

  @DeleteMapping("/delete/{id}")
  ResponseEntity<String> test1(@PathVariable Long id ){
    Optional<Item> item = itemRepository.findById(id);
    if( item.isPresent() ){
      System.out.printf("%d에서 삭제 요청%n", id);
      itemRepository.delete(item.get());
  }


    return ResponseEntity.status(200).body("삭제");
  }



}
