package com.retos.retos.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import com.retos.retos.Model.Category;

public interface CategoryCrudRepositorio extends CrudRepository <Category, Integer> {
    
}
