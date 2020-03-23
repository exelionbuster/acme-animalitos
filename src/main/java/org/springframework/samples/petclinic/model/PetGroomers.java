package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PetGroomers {
	
	private List<PetGroomer> groomers;

	@XmlElement
	public List<PetGroomer> getPetGroomerList() {
		if (groomers == null) {
			groomers = new ArrayList<>();
		}
		return groomers;
	}

}
