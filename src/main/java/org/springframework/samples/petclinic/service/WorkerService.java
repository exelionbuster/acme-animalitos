package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Worker;
import org.springframework.samples.petclinic.repository.springdatajpa.WorkerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WorkerService {
	@Autowired
	private WorkerRepository workerRepo;
	
	@Transactional
	public int workerCount() {
		return (int)	workerRepo.count();
	}
	
	@Transactional
	public Iterable<Worker> findAll() {
		return workerRepo.findAll();
	}

}
