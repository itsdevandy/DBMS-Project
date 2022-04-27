package com.team404.festmanagement.dto;

import com.team404.festmanagement.model.User;
import lombok.Data;

import javax.persistence.*;

@Data
public class FoodDTO {

    private Long id;
    private String name;
    private String stallName;
    private String stallLocation;
    private int userID;
}
