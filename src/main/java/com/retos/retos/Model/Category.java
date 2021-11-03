package com.retos.retos.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name="category")
public class Category implements Serializable { 

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; 
    private String description;

    // relaciones
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")    
    @JsonIgnoreProperties ("category")
    private List<Costume> costumes;
    // fin de relaciones
    // getter and setter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    } 

    // getter and setter relaciones
    public List<Costume> getCostumes() {
        return costumes;
    }
    public void setComputers(List<Costume> costumes) {
        this.costumes = costumes;
    }
    
    // fin getter and setter

}
