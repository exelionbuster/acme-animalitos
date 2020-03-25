/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * Simple JavaBean domain object representing a visit.
 *
 * @author Ken Krebs
 */
@Data
@Entity
@Table(name = "grooming_sessions")
public class GroomingSession extends BaseEntity {

	@Column(name = "start_hour")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private LocalDateTime startHour;

	@Column(name = "end_hour")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private LocalDateTime endHour;

	@NotEmpty
	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	@ManyToOne
	@JoinColumn(name="pet_groomer_id")
	private PetGroomer petGroomer;

	@ManyToOne
	@JoinColumn(name="clinic_id")
	private Clinic clinic;
}
