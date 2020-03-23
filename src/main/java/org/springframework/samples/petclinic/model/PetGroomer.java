package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

@Entity
@Table(name = "groomers")
public class PetGroomer extends Person{
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "groomer_types", joinColumns = @JoinColumn(name = "groomer_id"),
			inverseJoinColumns = @JoinColumn(name = "type_id"))
	private Set<PetType> types;

	protected Set<PetType> getTypesInternal() {
		if (this.types == null) {
			this.types = new HashSet<>();
		}
		return this.types;
	}

	protected void setTypesInternal(Set<PetType> types) {
		this.types = types;
	}

	@XmlElement
	public List<PetType> getTypes() {
		List<PetType> sortedTypes = new ArrayList<>(getTypesInternal());
		PropertyComparator.sort(sortedTypes, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedTypes);
	}

	public int getNrOfTypes() {
		return getTypesInternal().size();
	}

	public void addType(PetType types) {
		getTypesInternal().add(types);
	}

}
