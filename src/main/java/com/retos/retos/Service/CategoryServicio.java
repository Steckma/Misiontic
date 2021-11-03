package com.retos.retos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.retos.Model.Category;
import com.retos.retos.Repository.CategoryRepositorio;

@Service
public class CategoryServicio {
    @Autowired
    private CategoryRepositorio categoryRepositorio ;

    public List<Category>getAll(){
        return categoryRepositorio.getAll();
    }
    
    public Optional <Category>getCategory(int id){
        return categoryRepositorio.getCategory(id);
    }

    public Category save(Category category){
    // verificamos si el departamento es nuevo y de ser asi guarda
        if (category.getId()== null){
            return categoryRepositorio.save(category);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Category> consulta = categoryRepositorio.getCategory(category.getId());
            if (consulta.isEmpty()) {
                if (category.getName() != null) {
                    consulta.get().setName(category.getName());
                }
                if (category.getDescription() !=null) {
                    consulta.get().setDescription(category.getDescription());
                }
            } return category;
    } 
}

    public Category update(Category category){
        if (category.getId() != null){// si el objeto viene con numId se verifica si existe o no
            Optional <Category> consulta = categoryRepositorio.getCategory(category.getId());
            if (!consulta.isEmpty()) {// si el objeto es diferente a null
                if (category.getName() != null) {
                    consulta.get().setName(category.getName());
                }
                if (category.getDescription() !=null) {
                    consulta.get().setDescription(category.getDescription());
                }
                return categoryRepositorio.save(consulta.get());
            } 
        }
        return category;
    }

    
    public boolean deleteCategory(int id){
        Optional <Category> consulta = categoryRepositorio.getCategory(id);
            if (!consulta.isEmpty()){
                categoryRepositorio.delete(consulta.get());
                return true;
            }
            return false;
    }


}
