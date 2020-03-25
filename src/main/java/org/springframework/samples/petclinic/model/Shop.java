package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{

//	@Column(name="clinic")
	@OneToOne(optional=false)
	private Clinic clinic;

}