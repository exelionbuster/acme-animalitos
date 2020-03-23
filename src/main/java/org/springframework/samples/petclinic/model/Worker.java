package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "workers")
public class Worker extends Person {
	
//	@NotEmpty
	@OneToOne
	private Clinic currentClinic;

}
