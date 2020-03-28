package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "daycare_booking")
public class DaycareBooking extends NamedEntity {

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "start_date")
    private LocalDate startDate;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @Column(name = "end_date")
    private LocalDate endDate;

    //

    @ManyToOne(optional = false)
    @JoinColumn(name="daycare")
    private Daycare daycare;

    @OneToOne(optional = false)
    @JoinColumn(name = "pet")
    private Pet pet;
    
    public Pet getPet() {
		return this.pet;
	}
    
    public void setPet(Pet pet) {
		this.pet = pet;
	}
    
    public LocalDate getStart() {
		return this.startDate;
	}

	public void setStart(final LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEnd() {
		return this.endDate;
	}

	public void setEnd(final LocalDate endDate) {
		this.endDate = endDate;
	}
}
