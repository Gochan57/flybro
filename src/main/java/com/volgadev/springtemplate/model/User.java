package com.volgadev.springtemplate.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "public")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer userId;

	@Column(name = "telegram_username")
	private String telegramUsername;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_to_flight",
//			joinColumns = @JoinColumn(name = "user_id", referencedColumnName="user_id"),
//			inverseJoinColumns = @JoinColumn(name = "flight_id", referencedColumnName="flight_id"))
//	private Set<Flight> flights  = new HashSet<Flight>(0);

	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getTelegramUsername() {
		return telegramUsername;
	}

	public void setTelegramUsername(String telegramUsername) {
		this.telegramUsername = telegramUsername;
	}

//	public Set<Flight> getFlights() {
//		return this.flights;
//	}
//
//	public void setFlights(Set<Flight> flights) {
//		this.flights = flights;
//	}
}
