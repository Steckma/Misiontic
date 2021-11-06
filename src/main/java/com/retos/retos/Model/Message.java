package com.retos.retos.Model;


import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idMessage; 
    private String messageText;

    // relaciones
    @ManyToOne
    @JoinColumn (name = "id")
    @JsonIgnoreProperties ({"messages","reservations"})
    private Costume costume;

    @ManyToOne
    @JoinColumn (name = "idClient")
    @JsonIgnoreProperties ({"messages","reservations"})
    private Client client;

    
    // fin de relaciones
    // getter and setter
    public Integer getIdMessage() {
        return idMessage;
    }
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    } 
    // getter and setter relaciones
    public Costume getCostume() {
        return costume;
    }
    public void setComputer(Costume costume) {
        this.costume = costume;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
     
    // fin getter and setter


}
