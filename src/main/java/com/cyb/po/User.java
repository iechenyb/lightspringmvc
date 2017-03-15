package com.cyb.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
/**
 * @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  
private LocalDateTime dateTime;  
  
@DateTimeFormat(pattern = "yyyy-MM-dd")  
private LocalDate date;  
  
@DateTimeFormat(pattern = "HH:mm:ss")  
private LocalTime time; 
 * @author DHUser
 *
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name = "t_user")
public class User {
	@Id
	@GenericGenerator(strategy = "uuid2", name = "user_uuid")
	@GeneratedValue(generator = "user_uuid")
	@Column(name = "id", unique = true, nullable = false, length = 50)
	private String id;
	@Column(name="username",nullable=false,length=200)
	private String name;
	@Column(name="password",nullable=false,length=20)
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
