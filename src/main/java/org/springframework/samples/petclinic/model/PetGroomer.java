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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

/**
 * Simple JavaBean domain object representing a pet groomer.
 *
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Arjen Poutsma
 */
@Entity
@Table(name = "pet_groomers")
public class PetGroomer extends Worker {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "pet_types", joinColumns = @JoinColumn(name = "pet_groomer_id"),
			inverseJoinColumns = @JoinColumn(name = "pet_type_id"))
	private Set<PetType> petTypes;

	@ManyToOne
	@Column(name = "current_clinic")
	private Clinic currentClinic;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
	
	protected Set<PetType> getPetTypesInternal() {
		if (this.petTypes == null) {
			this.petTypes = new HashSet<>();
		}
		return this.petTypes;
	}

	protected void setPetTypesInternal(Set<PetType> petTypes) {
		this.petTypes = petTypes;
	}

	@XmlElement
	public List<PetType> getPetTypes() {
		List<PetType> sortedPetTypes = new ArrayList<PetType>(getPetTypesInternal());
		PropertyComparator.sort(sortedPetTypes, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedPetTypes);
	}

	public int getNrOfPetTypes() {
		return getPetTypesInternal().size();
	}

	public void addPetType(PetType petType) {
		getPetTypesInternal().add(petType);
	}
	
	public Clinic getCurrentClinic() {
		return this.currentClinic;
	}

	public void setCurrentClinic(Clinic currentClinic) {
		this.currentClinic = currentClinic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
