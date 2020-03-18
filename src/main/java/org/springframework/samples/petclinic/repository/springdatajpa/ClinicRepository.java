package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.Clinic;

public interface ClinicRepository extends CrudRepository<Clinic, Integer>{

}
