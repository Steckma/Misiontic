package com.retos.retos.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retos.retos.Model.Reservation;
import com.retos.retos.Repository.Crud.ReservationCrudRepositorio;

@Repository
public class ReservationRepositorio {
    @Autowired
    private ReservationCrudRepositorio reservationCrudRepositorio;
    
    // metodo para mostrar
    public List<Reservation> getAll(){
        return (List<Reservation>)reservationCrudRepositorio.findAll();
    }
    
    // metodo para buscar
    public Optional <Reservation> getReservation(int id) {
        return reservationCrudRepositorio.findById(id);
    }
    
    // metodo para guardar
    public Reservation save(Reservation reservation){
        return reservationCrudRepositorio.save(reservation);
    }
    
    // metodo para borrar
    public void delete (Reservation reservation){
        reservationCrudRepositorio.delete(reservation);
    } 

}
