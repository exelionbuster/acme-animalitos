package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.DaycareBooking;

public interface DaycareBookingRepository {
	
	void save(DaycareBooking daycareBooking) throws DataAccessException;
	
	void delete(int id);

	DaycareBooking findByDaycareBookingId(int id) throws DataAccessException;

}
