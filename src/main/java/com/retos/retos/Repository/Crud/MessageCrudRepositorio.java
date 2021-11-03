package com.retos.retos.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import com.retos.retos.Model.Message;

public interface MessageCrudRepositorio extends CrudRepository <Message, Integer> {
    
}
