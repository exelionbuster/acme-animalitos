package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name="daycare")
    private Daycare daycare;

    @OneToOne(optional = false)
    @Column(name = "pet")
    private Pet pet;
}
