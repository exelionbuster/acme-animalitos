package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.petclinic.model.PetGroomer;

public interface PetGroomerRepository extends CrudRepository<PetGroomer, Integer>{

}
