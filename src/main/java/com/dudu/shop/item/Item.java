package com.dudu.shop.item;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Item {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;


  //제약 설정
  @Column(nullable = false, unique = true)
  private String name;
  private Integer price;

  /*
   *
   privaite String title => set 함수 만들어서  원하는곳에  Item.set
   or @Setter
   **/


}

