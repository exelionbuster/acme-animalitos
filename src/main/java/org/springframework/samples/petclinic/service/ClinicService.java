package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinic;
import org.springframework.samples.petclinic.repository.springdatajpa.ClinicRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClinicService {
	@Autowired
	private ClinicRepository clinicRepo;
	
	@Transactional
	public int clinicCount() {
		return (int)	clinicRepo.count();
	}
	
	@Transactional
	public Iterable<Clinic> findAll() {
		return clinicRepo.findAll();
	}

}
