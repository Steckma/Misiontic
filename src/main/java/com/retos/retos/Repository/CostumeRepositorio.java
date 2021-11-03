package com.retos.retos.Repository;

import java.util.List;
import java.util.Optional;

import com.retos.retos.Model.Costume;
import com.retos.retos.Repository.Crud.CostumeCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class CostumeRepositorio {
    @Autowired
    private CostumeCrudRepositorio costumeCrudRepositorio;
    
    // metodo para mostrar
    public List<Costume> getAll(){
        return (List<Costume>)costumeCrudRepositorio.findAll();
    }
    
    // metodo para buscar
    public Optional <Costume> getCostume(int id) {
        return costumeCrudRepositorio.findById(id);
    }
    
    // metodo para guardar
    public Costume save(Costume costume){
        return costumeCrudRepositorio.save(costume);
    }
    
    // metodo para borrar
    public void delete (Costume costume){
        costumeCrudRepositorio.delete(costume);
    } 



}

