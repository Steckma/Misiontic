package com.retos.retos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.retos.Model.Client;
import com.retos.retos.Repository.ClientRepositorio;

@Service
public class ClientServicio {
    @Autowired
    private ClientRepositorio clientRepositorio ;

    public List<Client>getAll(){
        return clientRepositorio.getAll();
    }
    
    public Optional <Client>getClient(int id){
        return clientRepositorio.getClient(id);
    }

    public Client save(Client client){
    // verificamos si el departamento es nuevo y de ser asi guarda
        if (client.getIdClient()== null){
            return clientRepositorio.save(client);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Client> consulta = clientRepositorio.getClient(client.getIdClient());
            if (consulta.isEmpty()) {
                return clientRepositorio.save(client);
            } 
            if (client.getName() != null) {
                consulta.get().setName(client.getName());
            }
            if (client.getEmail() !=null) {
                consulta.get().setEmail(client.getEmail());
            }
            if (client.getAge() !=null) {
                consulta.get().setAge(client.getAge());
            }
            if (client.getPassword() !=null) {
                consulta.get().setPassword(client.getPassword());
            } 
            return client;

        }
     
    } 

    public Client update(Client client){
        if (client.getIdClient() != null){// si el objeto viene con numId se verifica si existe o no
            Optional <Client> consulta = clientRepositorio.getClient(client.getIdClient());
            if (!consulta.isEmpty()) {// si el objeto es diferente a null
                if (client.getName() != null) {
                    consulta.get().setName(client.getName());
                }
                if (client.getEmail() !=null) {
                    consulta.get().setEmail(client.getEmail());
                }
                if (client.getAge() !=null) {
                    consulta.get().setAge(client.getAge());
                }
                if (client.getPassword() !=null) {
                    consulta.get().setPassword(client.getPassword());
                }
                return clientRepositorio.save(consulta.get());
            } 
        }
        return client;
    }

    public boolean deleteClient(int id){
        Optional <Client> consulta = clientRepositorio.getClient(id);
            if (!consulta.isEmpty()){
                clientRepositorio.delete(consulta.get());
                return true;
            }
            return false;
    }

}

