package com.volgadev.springtemplate.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User implements java.io.Serializable {

	public User() {
	}

	private Integer userId;

	private String telegramUserName;

//	private Set<Flight> flights;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID", unique = true, nullable = false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "TELEGRAM_USERNAME")
	public String getTelegramUserName() {
		return telegramUserName;
	}

	public void setTelegramUserName(String telegramUserName) {
		this.telegramUserName = telegramUserName;
	}

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_to_flight",
//			joinColumns = { @JoinColumn(name = "user_id", referencedColumnName="user_id") },
//			inverseJoinColumns = { @JoinColumn(name = "flight_id", referencedColumnName="flight_id") })
//	public Set<Flight> getFlights() {
//		return this.flights;
//	}

//	public void setFlights(Set<Flight> flights) {
//		this.flights = flights;
//	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!userId.equals(user.userId)) return false;
		return telegramUserName.equals(user.telegramUserName);
	}

	@Override
	public int hashCode() {
		int result = userId.hashCode();
		result = 31 * result + telegramUserName.hashCode();
		return result;
	}
}
