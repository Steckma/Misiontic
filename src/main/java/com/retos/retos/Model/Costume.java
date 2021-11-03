package com.retos.retos.Model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="costume") //se crea la tabla
public class Costume implements Serializable {
    @Id //genera un id como llave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //variables de funcionamiento para los datos de la tabla
    private String name; 
    private String brand; 
    private Integer year; 
    private String description;

    // relaciones
    @ManyToOne // relacion muchos a uno de computador con categoria
    @JoinColumn (name = "idCategory") // se ignora computador de categoria
    @JsonIgnoreProperties ("costume") // para que no cree error y ciclo infinito
    private Category category;

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "costume")
    @JsonIgnoreProperties({"costume","client"})
    private List<Message> messages;  // relacion uno a muchos de computador con mensaje

    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "costume")
    @JsonIgnoreProperties({"costume","client"})
    private List<Reservation> reservations; // relacion uno a muchos de computador con reservaciones

    // fin de relaciones
    // getter and setter
    public Integer getId() {
        return id; // metodo get para variable id de computer
    }
    public void setId(Integer id) {
        this.id = id; // metodo set para variable id de computer
    }
    public String getName() {
        return name; // metodo get para variable name de computer
    }
    public void setName(String name) {
        this.name = name; // metodo set para variable name de computer
    }
    public String getBrand() {
        return brand; // metodo get para variable brand de computer
    }
    public void setBrand(String brand) {
        this.brand = brand; // metodo set para variable brand de computer
    }
    public Integer getYear() {
        return year; // metodo get para variable year de computer
    }
    public void setYear(Integer year) {
        this.year = year; // metodo set para variable year de computer
    }
    public String getDescription() {
        return description; // metodo get para variable description de computer
    }
    public void setDescription(String description) {
        this.description = description; // metodo set para variable description de computer
    }

    // getter and setter relaciones
    public Category getCategory() {
        return category; // metodo get para relacion categoria con computer
    }
    public void setCategory(Category category) {
        this.category = category; // metodo set para relacion categoria con computer
    }
    

    public List<Message> getMessages() {
        return messages; // metodo get para relacion message con computer
    }
    public void setMessages(List<Message> messages) {
        this.messages = messages; // metodo set para relacion message con computer
    }
    public List<Reservation> getReservations() {
        return reservations; // metodo get para relacion reservation con computer
    }
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations; // metodo set para relacion reservation con computer
    }

    // fin getter and setter

}
