package com.team404.festmanagement.dto;

import com.team404.festmanagement.model.Category;
import lombok.Data;

import javax.persistence.*;

/* Data transfer object for Merch since product cannot handle Category object directly
*
* So we access categoryID and the rest is handled by the data transfer object
*
*
*  */
@Data
public class MerchDTO {

    private Long id;
    private String name;

    private int categoryID; //Dealing with category through id
    private double price;
    private String size;
    private String description;
    private String imageName; //costly to store images on the backend, so storing only name h
}
