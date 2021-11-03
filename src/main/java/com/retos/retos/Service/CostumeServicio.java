package com.retos.retos.Service;

import java.util.List;
import java.util.Optional;

import com.retos.retos.Model.Costume;
import com.retos.retos.Repository.CostumeRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CostumeServicio {
    @Autowired
    private CostumeRepositorio costumeRepositorio ;

    public List<Costume>getAll(){
        return costumeRepositorio.getAll();
    }
    
    public Optional <Costume>getCostume(int id){
        return costumeRepositorio.getCostume(id);
    }

    public Costume save(Costume costume){
    // verificamos si el departamento es nuevo y de ser asi guarda
        if (costume.getId()== null){
            return costumeRepositorio.save(costume);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Costume> consulta = costumeRepositorio.getCostume(costume.getId());
            if (consulta.isEmpty()) {// si el objeto es diferente a null   
                if (costume.getName() != null) {
                        consulta.get().setName(costume.getName());
                    }
                if (costume.getDescription() !=null) {
                        consulta.get().setDescription(costume.getDescription());
                    }
                if (costume.getBrand() !=null) {
                        consulta.get().setBrand(costume.getBrand());
                    } 
                if (costume.getYear() !=null) {
                        consulta.get().setYear(costume.getYear());
                    }
                    return costumeRepositorio.save(consulta.get());
                } 
            }
            return costume;
        }

    public Costume update(Costume costume){
        if (costume.getId() != null){// si el objeto viene con numId se verifica si existe o no
            Optional <Costume> consulta = costumeRepositorio.getCostume(costume.getId());
            if (!consulta.isEmpty()) {// si el objeto es diferente a null
                if (costume.getName() != null) {
                    consulta.get().setName(costume.getName());
                }
                if (costume.getDescription() !=null) {
                    consulta.get().setDescription(costume.getDescription());
                }
                if (costume.getBrand() !=null) {
                    consulta.get().setBrand(costume.getBrand());
                } 
                if (costume.getYear() !=null) {
                    consulta.get().setYear(costume.getYear());
                }
                return costumeRepositorio.save(consulta.get());
            } 
        }
        return costume;
    }

    public boolean deleteCostume(int id){
        Optional <Costume> consulta = costumeRepositorio.getCostume(id);
            if (!consulta.isEmpty()){
                costumeRepositorio.delete(consulta.get());
                return true;
            }
            return false;
    }

}
