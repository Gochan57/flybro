package com.volgadev.springtemplate.model;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Julia on 07.05.2017.
 */
@Entity
@Table(name = "FLIGHT", schema = "public")
public class Flight {

    @Id
    @Column(name = "FLIGHT_ID", unique = true, nullable = false)
    private String flightId;

    @Column(name = "TELEGRAM_USERNAME")
    private String telegramUsername;

    @Column(name = "DATE")
    private Date date;

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "flights")
//    private Set<User> users = new HashSet<User>(0);

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getTelegramUsername() {
        return telegramUsername;
    }

    public void setTelegramUsername(String telegramUsername) {
        this.telegramUsername = telegramUsername;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //    public Set<User> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
