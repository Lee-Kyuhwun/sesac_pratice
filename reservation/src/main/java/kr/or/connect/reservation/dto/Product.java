package kr.or.connect.reservation.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {

    int id;
    List<Category> items;
    String name;
    int count;

}
