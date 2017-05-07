package com.volgadev.springtemplate.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Julia on 07.05.2017.
 */
public class Flight {

    @Id
    @Column(name = "flight_id", unique = true, nullable = false)
    private String flightId;

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }
}
