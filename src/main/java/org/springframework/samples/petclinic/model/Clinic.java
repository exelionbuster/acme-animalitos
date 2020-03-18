package org.springframework.samples.petclinic.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
public class Clinic extends NamedEntity{
	
	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@Column(name = "address")
	@NotEmpty
	private String address;
	
	@Column(name = "phoneNumber")
	@NotEmpty
//	@Pattern(regexp = "(\\+34|0034|34)?[ -]*(6|9)[ -]*([0-9][ -]*){8}")
	@Digits(fraction = 0, integer = 10) //Asi esta puesto en la clase Owner (telephone)
	private String phoneNumber;
	
	@Column(name = "email")
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "openingHour")
	@NotEmpty
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime openingHour;
	
	@Column(name = "clossingHour")
	@NotEmpty
	@DateTimeFormat(pattern = "HH:mm:ss")
	private LocalTime clossingHour;

}
