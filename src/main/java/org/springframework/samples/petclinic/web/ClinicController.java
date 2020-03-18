package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Clinic;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clinics")
public class ClinicController {
	
	@Autowired
	private ClinicService clinicService;
	
	@GetMapping()
	public String listadoClinicas(ModelMap modelMap) {
		String vista="clinics/listadoClinicas";
		Iterable<Clinic> clinics=clinicService.findAll();
		modelMap.addAttribute("clinics", clinics);
		return vista;
	}

}
