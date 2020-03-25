package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinic;
import org.springframework.samples.petclinic.repository.springdatajpa.SpringDataClinicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClinicService {
	
	@Autowired
	private SpringDataClinicRepository clinicRepo;
	
	@Transactional
	public int clinicCount() {
		return (int)	clinicRepo.count();
	}
	
	@Transactional
	public Iterable<Clinic> findAll() {
		return clinicRepo.findAll();
	}

}
