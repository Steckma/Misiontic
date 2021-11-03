package com.retos.retos.Web;

import java.util.List;
import java.util.Optional;

import com.retos.retos.Model.Costume;
import com.retos.retos.Service.CostumeServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/Costume")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CostumeControlador {
    @Autowired
    private CostumeServicio costumeServicio;
    
    @GetMapping("/all")
    public List<Costume>getCostume(){
        return costumeServicio.getAll();
        }
    
    @GetMapping("/{id}")
    public Optional <Costume> getCostume(@PathVariable("Id") int id){
        return costumeServicio.getCostume(id);
        }
    
    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save (@RequestBody Costume costume){
        return costumeServicio.save(costume);
        }
     
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume update(@RequestBody Costume costume){
        return costumeServicio.update(costume);
        }
        
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCostume(@PathVariable ("id") int id){
        return costumeServicio.deleteCostume(id);
        }     
}
