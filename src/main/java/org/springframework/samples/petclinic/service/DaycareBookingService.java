package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.DaycareBooking;
import org.springframework.samples.petclinic.repository.DaycareBookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DaycareBookingService {
	
	private DaycareBookingRepository daycareBookingRepository;
	
	@Autowired
	public DaycareBookingService(final DaycareBookingRepository daycareBookingRepository) {
		this.daycareBookingRepository = daycareBookingRepository;
	}
	
	@Transactional(readOnly = true)
	public DaycareBooking findByDaycareBookingId(final int id) throws DataAccessException {
		return this.daycareBookingRepository.findByDaycareBookingId(id);
	}
	
	@Transactional(readOnly = true)
	public void save(final DaycareBooking daycareBooking) throws DataAccessException {
		this.daycareBookingRepository.save(daycareBooking);
	}
	
	@Transactional
	public void delete(final DaycareBooking daycareBooking) throws DataAccessException {
		this.daycareBookingRepository.delete(daycareBooking.getId());
	}

}
