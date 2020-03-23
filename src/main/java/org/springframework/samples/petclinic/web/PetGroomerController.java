package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetGroomers;
import org.springframework.samples.petclinic.service.PetGroomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PetGroomerController {
	
	private final PetGroomerService groomerService;

	@Autowired
	public PetGroomerController(PetGroomerService clinicService) {
		this.groomerService = clinicService;
	}

	@GetMapping(value = { "/groomers" })
	public String showGroomerList(Map<String, Object> model) {
		// Here we are returning an object of type 'PetGroomers' rather than a collection of PetGroomer
		// objects
		// so it is simpler for Object-Xml mapping
		PetGroomers groomers = new PetGroomers();
		groomers.getPetGroomerList().addAll(this.groomerService.findGroomers());
		model.put("groomers", groomers);
		return "groomers/petGroomerList";
	}

	@GetMapping(value = { "/groomers.xml"})
	public @ResponseBody PetGroomers showResourcesPetGroomerList() {
		// Here we are returning an object of type 'PetGroomers' rather than a collection of PetGroomer
		// objects
		// so it is simpler for JSon/Object mapping
		PetGroomers groomers = new PetGroomers();
		groomers.getPetGroomerList().addAll(this.groomerService.findGroomers());
		return groomers;
	}

}
