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

import com.retos.retos.Model.Reservation;
import com.retos.retos.Repository.CountClient;
import com.retos.retos.Repository.StatusReservas;
import com.retos.retos.Service.ReservationServicio;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationControlador {
    @Autowired
    private ReservationServicio reservationServicio;
    
    @GetMapping("/all")
    public List<Reservation>getReservation(){
        return reservationServicio.getAll();
        }
    
    @GetMapping("/{id}")
    public Optional <Reservation> getReservation(@PathVariable("Id") int id){
        return reservationServicio.getReservation(id);
        }
    
    @PostMapping ("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){
        return reservationServicio.save(reservation);
        }
    
    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationServicio.update(reservation);
        }
                
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable ("id") int id){
        return reservationServicio.deleteReservation(id);
        } 
    
    @GetMapping("/report-status")
    public StatusReservas getReservas(){
                return reservationServicio.reporteStatusServicio();
            }
            
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
                 return reservationServicio.reporteTiempoServicio(dateOne, dateTwo);
             }
             
    @GetMapping("/report-clients")
    public List<CountClient> getClient(){
                 return reservationServicio.reporteClientesServicio();
             }
}
