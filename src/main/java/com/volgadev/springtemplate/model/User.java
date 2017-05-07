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
@Table(name = "user")
public class User implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "telegram_user_name")
	private String telegramUserName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (!id.equals(user.id)) return false;
		return telegramUserName.equals(user.telegramUserName);
	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + telegramUserName.hashCode();
		return result;
	}

	public User() {
	}

	public String getTelegramUserName() {
		return telegramUserName;
	}

	public void setTelegramUserName(String telegramUserName) {
		this.telegramUserName = telegramUserName;
	}
}
