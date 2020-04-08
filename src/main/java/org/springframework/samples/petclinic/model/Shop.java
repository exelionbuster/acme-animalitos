package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "shops")
public class Shop extends BaseEntity{

	@OneToOne(optional=false)
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

}