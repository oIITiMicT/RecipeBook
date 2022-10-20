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

@Entity
@Data
@Table(name = "structures")
public class Structure {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calories")
    private int calories;

    @Column(name = "carbohydrates")
    private int carbohydrates;

    @Column(name = "proteins")
    private int proteins;

    @Column(name = "fats")
    private int fats;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name="structure_id")
    @JsonIgnore
    private List<Recipe> recipes;
}
