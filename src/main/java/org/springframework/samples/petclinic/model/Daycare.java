package org.springframework.samples.petclinic.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "daycare")
public class Daycare extends BaseEntity{

	@NotNull
	@Min(value = 0)
	@Column(name = "max_pets")
	private Integer maxPets;

	@Column(name="clinic")
	@OneToOne(optional=false)
	private Clinic clinic;

	@OneToMany
	@Column(name = "daycare_bookings")
	private Set<DaycareBooking> daycareBookings;
}