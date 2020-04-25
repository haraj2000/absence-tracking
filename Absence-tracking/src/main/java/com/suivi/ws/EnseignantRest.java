package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Département;
import com.suivi.bean.Enseignant;
import com.suivi.service.facade.EnseignantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/enseignant")
public class EnseignantRest {
	
	@Autowired
	private EnseignantService enseignantService;

	@GetMapping("firstName/{firstName}")
	public List<Enseignant> findByFirstName(@PathVariable String firstName) {
		return enseignantService.findByFirstName(firstName);
	}
	@GetMapping("/lastName/{lastName}")
	public List<Enseignant> findByLastName(@PathVariable String lastName) {
		return enseignantService.findByLastName(lastName);
	}
	@GetMapping("/matricule/{matricule}")
	public Enseignant findByMatricule(@PathVariable String matricule) {
		return enseignantService.findByMatricule(matricule);
	}
	@GetMapping("/cin/{cin}")
	public Enseignant findByCin(@PathVariable String cin) {
		return enseignantService.findByCin(cin);
	}
	@GetMapping("/département")
	public List<Enseignant> findByDépartement(@RequestBody Département département) {
		return enseignantService.findByDépartement(département);
	}
	@GetMapping("/mail/{mail}")
	public Enseignant findByCompteMail(@PathVariable String mail) {
		return enseignantService.findByCompteMail(mail);
	}
	@DeleteMapping("/matricule/{matricule}")
	public int deleteByMatricule(@PathVariable String matricule) {
		return enseignantService.deleteByMatricule(matricule);
	}
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return enseignantService.deleteByCin(cin);
	}
	@PostMapping("/")
	public int save(@RequestBody Enseignant enseignant) {
		return enseignantService.save(enseignant);
	}
	@PutMapping("/")
	public int update(@RequestBody Enseignant enseignant) {
		return enseignantService.update(enseignant);
	}
	@GetMapping("/")
	public List<Enseignant> findAll() {
		return enseignantService.findAll();
	}

}
