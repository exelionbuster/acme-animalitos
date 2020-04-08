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
package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinic;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Visit;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.samples.petclinic.service.VetService;
import org.springframework.samples.petclinic.service.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 * @author Michael Isvy
 */
@Controller
public class VisitController {

	private final PetService petService;
	private final VetService vetService;
	private final ClinicService clinicService;
	private final VisitService visitService;

	@Autowired
	public VisitController(PetService petService, VetService vetService, ClinicService clinicService, VisitService visitService) {
		this.petService = petService;
		this.vetService = vetService;
		this.clinicService = clinicService;
		this.visitService = visitService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/**
	 * Called before each and every @GetMapping or @PostMapping annotated method. 2 goals:
	 * - Make sure we always have fresh data - Since we do not use the session scope, make
	 * sure that Pet object always has an id (Even though id is not part of the form
	 * fields)
	 * @param petId
	 * @return Pet
	 */
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") int petId) {
		Pet pet = this.petService.findPetById(petId);
		Visit visit = new Visit();
		pet.addVisit(visit);
		return visit;
	}

	//TOOD: discutir creación de visit (clinicId y lista de vets)
	// Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
	@GetMapping(value = "/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable("petId") int petId, Map<String, Object> model) {
		Visit visit = new Visit();
		Pet pet = this.petService.findPetById(petId);
		visit.setPet(pet);
		model.put("visit", visit);
		model.put("edit", false);
		
		Collection<Clinic> clinics = this.clinicService.findClinics();
		model.put("clinics", clinics);
				
		return "pets/createOrUpdateVisitForm";
	}

	// Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
	@PostMapping(value = "/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid Visit visit, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			Collection<Clinic> clinics = this.clinicService.findClinics();
			model.put("clinics", clinics);
			model.put("edit", false);

			return "pets/createOrUpdateVisitForm";
		}
		else {
			this.petService.saveVisit(visit);
			return "redirect:/owners/{ownerId}";
		}
	}

	@GetMapping(value = "/owners/*/pets/{petId}/visits")
	public String showVisits(@PathVariable int petId, Map<String, Object> model) {
		model.put("visits", this.petService.findPetById(petId).getVisits());
		return "visitList";
	}
	
	//TODO: REVISAR
	
	@GetMapping(value = "/owners/*/pets/{petId}/visits/{visitId}/edit")
	public String initEditVisitForm(@PathVariable("visitId") int visitId, ModelMap model) {
		Visit visit = this.visitService.findByVisitId(visitId);
		model.put("visit", visit);
		Collection<Vet> vets = this.vetService.findVetsByClinic(visit.getClinic().getId());
		model.put("vets", vets);
		model.put("edit", true);
		
		return "pets/createOrUpdateVisitForm";
	}
	
	@PostMapping(value = "/owners/{ownerId}/pets/{petId}/visits/{visitId}/edit")
	public String editVisits(@Valid Visit visit, @PathVariable("visitId") int visitId, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			model.put("visit", visit);
			Collection<Vet> vets = this.vetService.findVetsByClinic(visitId);
			model.put("vets", vets);
			model.put("edit", true);

			return "pets/createOrUpdateVisitForm";
		}else {
            Visit visitToUpdate=this.visitService.findByVisitId(visitId);
			BeanUtils.copyProperties(visit, visitToUpdate, "id","date","description", "clinic");
			this.petService.saveVisit(visitToUpdate);
			return "redirect:/owners/{ownerId}";
		}
	}
	
	@GetMapping( value = "/owners/{ownerId}/pets/{petId}/visits/{visitId}/delete")
	public String deleteVisit(@PathVariable("visitId") int visitId, @PathVariable("petId") int petId, ModelMap model) {	
		Visit visit = this.visitService.findByVisitId(visitId);
		this.visitService.deleteVisit(visit);
		
		return "redirect:/owners/{ownerId}";
		
	}
	
}
