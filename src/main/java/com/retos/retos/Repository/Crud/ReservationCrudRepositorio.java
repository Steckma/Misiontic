package com.retos.retos.Repository.Crud;

import org.springframework.data.repository.CrudRepository;
import com.retos.retos.Model.Reservation;

public interface ReservationCrudRepositorio extends CrudRepository <Reservation, Integer> {
    
}
