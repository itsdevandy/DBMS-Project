package com.team404.festmanagement.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String stallName;
    private String stallLocation;

    //Taking join of two tables

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
}
