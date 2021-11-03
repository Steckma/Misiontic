package com.retos.retos.Web;

import java.util.List;
import java.util.Optional;

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

import com.retos.retos.Model.Category;
import com.retos.retos.Service.CategoryServicio;

@RestController
@RequestMapping("api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoryControlador {
    @Autowired
    private CategoryServicio categoryServicio;
    
    @GetMapping("/all")
    public List<Category>getCategory(){
        return categoryServicio.getAll();
        }
    
    @GetMapping("/{id}")
    public Optional <Category> getCategory(@PathVariable("id") int id){
        return categoryServicio.getCategory(id);
        }
    
    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save (@RequestBody Category category){
        return categoryServicio.save(category);
        }
    
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category){
            return categoryServicio.update(category);
        }
    
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory(@PathVariable ("id") int id){
            return categoryServicio.deleteCategory(id);
        }
}
