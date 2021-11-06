package com.retos.retos.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.retos.retos.Model.Client;
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

    public List<Reservation> reservationStatusRepositorio (String status){
        return reservationCrudRepositorio.findAllByStatus(status);
    }
    
    public List<Reservation> reservationTiempoRepositorio (Date a, Date b){
        return reservationCrudRepositorio.findAllByStartDateAfterAndStartDateBefore(a, b);
    
    }
    
    public List<CountClient> getClientRepositorio(){
        List<CountClient> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepositorio.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client)report.get(i)[0]));
        }
        return res;
    }

}
