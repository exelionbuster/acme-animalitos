package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "worker")
public class Worker extends Person {
	
	@Column(name = "currentClinic")
	@NotEmpty
	private Integer currentClinic; //Esta puesto integer (por poner algo) porque da error al lanzar la aplicacion, dice que no puede determinar el tipo de clinic

}
