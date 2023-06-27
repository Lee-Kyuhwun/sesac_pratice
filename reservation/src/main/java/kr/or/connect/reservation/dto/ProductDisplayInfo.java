package kr.or.connect.reservation.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class ProductDisplayInfo {
    private int id;
    private int categoryId;
    private int displayInfoId;
    private String name;
    private String description;
    private String content;
    private String event;
    private String openingHours;
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;
    private Date createDate;
    private Date modifyDate;
    private int fileId;
}
