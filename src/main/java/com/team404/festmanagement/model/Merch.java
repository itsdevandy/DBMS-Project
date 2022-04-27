package com.team404.festmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity //annotation makes the table
@Data //Annotation gives getters and setters
public class Merch    {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //Taking join of two tables

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
    private double price;
    private String size;
    private String description;
}
