package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.DaycareBooking;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.service.DaycareBookingService;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DaycareBookingController {
	
	private final DaycareBookingService daycareBookingService;
	private final PetService petService;
	
	
	@Autowired
	public DaycareBookingController(final DaycareBookingService daycareBookingService, final PetService petService) {
		this.daycareBookingService = daycareBookingService;
		this.petService = petService;
	}
	
	@InitBinder
	public void setAllowedFields(final WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("pet")
	public Pet loadPet(@PathVariable("petId") final int petId) {
		Pet pet = this.petService.findPetById(petId);
		return pet;
	}

	@ModelAttribute("hotel")
	public DaycareBooking loadPetWithDaycareBooking(@PathVariable("petId") final int petId) {
		DaycareBooking daycareBooking = new DaycareBooking();
		return daycareBooking;
	}
	
	@GetMapping(value = "/owners/*/pets/{petId}/daycareBookings/new")
	public String initNewDaycareBookingForm(@PathVariable("petId") final int petId, final Map<String, Object> model) {
		model.put("new_pet", true);
		Pet pet = this.petService.findPetById(petId);
		DaycareBooking daycareBooking = (DaycareBooking) model.get("daycareBooking");
		pet.addDaycareBooking(daycareBooking);
		return "pets/createOrUpdateDaycareBookingForm";
	}
	
	@PostMapping(value = "/owners/{ownerId}/pets/{petId}/daycareBookings/new")
	public String processNewDaycareBookingForm(@PathVariable("petId") final int petId, @Valid final DaycareBooking daycareBooking, final BindingResult result) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateDaycareBookingForm";
		} else {
			if (daycareBooking.getStart().isBefore(daycareBooking.getEnd())) {
				Pet pet = this.petService.findPetById(petId);
				pet.addDaycareBooking(daycareBooking);
				this.daycareBookingService.save(daycareBooking);
				return "redirect:/owners/{ownerId}";
			} else {
				result.rejectValue("end", "posterior", "la fecha de inicio debe ser anterior a la de fin");
				return "pets/createOrUpdateDaycareBookingForm";
			}
		}
	}
	
	@GetMapping(value = "/owners/*/pets/{petId}/daycareBookings")
	public String showDaycareBookings(@PathVariable final int petId, final Map<String, Object> model) {
		model.put("daycareBookings", this.petService.findPetById(petId).getDaycareBookings());
		return "daycareBookingList";
	}

	@GetMapping(value = "/owners/{ownerId}/pets/{petId}/daycareBookings/delete/{daycareBookingId}")
	public String DeleteDaycareBooking(@PathVariable("daycareBookingId") final int daycareBookingId, @PathVariable("petId") final int petId, final ModelMap model) {
		DaycareBooking db = this.daycareBookingService.findByDaycareBookingId(daycareBookingId);
		Pet p = this.petService.findPetById(petId);
		this.daycareBookingService.delete(db);
		return "redirect:/owners/{ownerId}";

	}

}
