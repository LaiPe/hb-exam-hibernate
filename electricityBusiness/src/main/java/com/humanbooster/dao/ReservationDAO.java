package com.humanbooster.dao;

import com.humanbooster.model.Reservation;

public class ReservationDAO extends GenericDAOImpl<Reservation, Long> implements GenericDAO<Reservation, Long> {
    public ReservationDAO(boolean verbose) {
        super(Reservation.class, verbose);
    }
}
