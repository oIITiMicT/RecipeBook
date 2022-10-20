package com.example.RecipeBook.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.List;

@Data
@Entity
@Table(name = "pictures")
public class Picture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture_URL")
    private String pictureURL;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="picture_id")
    @JsonIgnore
    private List<Recipe> recipes;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="picture_id")
    @JsonIgnore
    private List<Product> products;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="picture_id")
    @JsonIgnore
    private List<Step> steps;
}
