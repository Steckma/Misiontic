package com.retos.retos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.retos.Model.Message;
import com.retos.retos.Repository.MessageRepositorio;

@Service
public class MessageServicio {
    @Autowired
    private MessageRepositorio messageRepositorio ;

    public List<Message>getAll(){
        return messageRepositorio.getAll();
    }
    
    public Optional <Message>getMessage(int id){
        return messageRepositorio.getMessage(id);
    }

    public Message save(Message message){
    // verificamos si el departamento es nuevo y de ser asi guarda
        if (message.getIdMessage()== null){
            return messageRepositorio.save(message);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Message> consulta = messageRepositorio.getMessage(message.getIdMessage());
            if (consulta.isEmpty()) {
                return messageRepositorio.save(message);
            } 
            if (message.getMessageText() != null) {
                consulta.get().setMessageText(message.getMessageText());
                }  
             return message;
        }
    } 

    public Message update(Message message){
        if (message.getIdMessage() != null){// si el objeto viene con numId se verifica si existe o no
            Optional <Message> consulta = messageRepositorio.getMessage(message.getIdMessage());
            if (!consulta.isEmpty()) {// si el objeto es diferente a null
                if (message.getMessageText() != null) {
                    consulta.get().setMessageText(message.getMessageText());
                }
                if (message.getIdMessage() !=null) {
                    consulta.get().setIdMessage(message.getIdMessage());
                }
                return messageRepositorio.save(consulta.get());
            } 
        }
        return message;
    }

    public boolean deleteMessage(int id){
        Optional <Message> consulta = messageRepositorio.getMessage(id);
            if (!consulta.isEmpty()){
                messageRepositorio.delete(consulta.get());
                return true;
            }
            return false;
    }
}
