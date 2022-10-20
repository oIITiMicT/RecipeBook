package com.example.RecipeBook.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import java.util.List;

@Entity
@Data
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    private int time;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "structure_id")
    @ToString.Exclude
    private Structure structure;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private User author;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "picture_id")
    @ToString.Exclude
    private Picture picture;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="recipe_id")
    @JsonIgnore
    private List<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="recipe_id")
    @JsonIgnore
    private List<Step> steps;
}
