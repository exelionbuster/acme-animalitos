package org.springframework.samples.petclinic.model;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "clinics")
public class Clinic extends BaseEntity{
	
	@Column(name = "name")
	@NotBlank
	private String name;
	
	@Column(name = "address")
	@NotBlank
	private String address;
	
	@Column(name = "phoneNumber")
	@NotBlank
	@Digits(fraction = 0, integer = 10)
	private String phoneNumber;
	
	@Column(name = "email")
	@NotBlank
	@Email
	private String email;
	
	@Column(name = "openingHour")
	@NotEmpty
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime openingHour;
	
	@Column(name = "closingHour")
	@NotEmpty
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime closingHour;
    
//	@OneToOne
//	private Worker manager;
	
}