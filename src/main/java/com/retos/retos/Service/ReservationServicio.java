package com.retos.retos.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retos.retos.Model.Reservation;
import com.retos.retos.Repository.CountClient;
import com.retos.retos.Repository.ReservationRepositorio;
import com.retos.retos.Repository.StatusReservas;

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
            reservation.setStatus("created");
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
    public StatusReservas reporteStatusServicio (){
        List<Reservation>completed= reservationRepositorio.reservationStatusRepositorio("completed");
        List<Reservation>cancelled= reservationRepositorio.reservationStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }

    public List<Reservation> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservationRepositorio.reservationTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
    public List<CountClient> reporteClientesServicio(){
        return reservationRepositorio.getClientRepositorio(); 
    }
}
