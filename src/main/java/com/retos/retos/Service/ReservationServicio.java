package com.retos.retos.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.retos.Model.Reservation;
import com.retos.retos.Repository.ReservationRepositorio;

@Service
public class ReservationServicio {
    @Autowired
    private ReservationRepositorio reservationRepositorio ;

    public List<Reservation>getAll(){
        return reservationRepositorio.getAll();
    }
    
    public Optional <Reservation>getReservation(int id){
        return reservationRepositorio.getReservation(id);
    }

    public Reservation save(Reservation reservation){
    // verificamos si el departamento es nuevo y de ser asi guarda
        if (reservation.getIdReservation()== null){
            return reservationRepositorio.save(reservation);
        } else{ // si el objeto viene con numId se verifica si existe o no
            Optional <Reservation> consulta = reservationRepositorio.getReservation(reservation.getIdReservation());
            if (consulta.isEmpty()) {
                return reservationRepositorio.save(reservation);
            } 
            if (reservation.getStartDate() != null) {
                    consulta.get().setStartDate(reservation.getStartDate());
                }
            if (reservation.getStatus() !=null) {
                    consulta.get().setStatus(reservation.getStatus());
                }
            if (reservation.getDevolutionDate() !=null) {
                    consulta.get().setDevolutionDate(reservation.getDevolutionDate());
                }   
        } return reservation;
    } 

    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null){// si el objeto viene con numId se verifica si existe o no
            Optional <Reservation> consulta = reservationRepositorio.getReservation(reservation.getIdReservation());
            if (!consulta.isEmpty()) {// si el objeto es diferente a null
                if (reservation.getStartDate() != null) {
                    consulta.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getStatus() !=null) {
                    consulta.get().setStatus(reservation.getStatus());
                }
                if (reservation.getDevolutionDate() !=null) {
                    consulta.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return reservationRepositorio.save(consulta.get());
            } 
        }
        return reservation;
    }

    public boolean deleteReservation(int id){
        Optional <Reservation> consulta = reservationRepositorio.getReservation(id);
            if (!consulta.isEmpty()){
                reservationRepositorio.delete(consulta.get());
                return true;
            }
            return false;
    }
}
