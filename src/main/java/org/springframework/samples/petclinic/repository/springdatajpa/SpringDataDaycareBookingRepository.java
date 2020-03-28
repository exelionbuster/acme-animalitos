package org.springframework.samples.petclinic.repository.springdatajpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.DaycareBooking;
import org.springframework.samples.petclinic.repository.DaycareBookingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface SpringDataDaycareBookingRepository extends DaycareBookingRepository, Repository<DaycareBooking, Integer> {
	
	@Override
	@Transactional
	@Modifying
	@Query("DELETE FROM DaycareBooking db where db.id=:daycareBookingId")
	void delete(@Param(value = "daycareBookingId") int daycareBookingId);
	
	@Override
	@Query("SELECT db FROM DaycareBooking db WHERE db.id =:id")
	DaycareBooking findByDaycareBookingId(@Param("id") int id);
}
