package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Departement;
import com.suivi.service.facade.DepartementService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/departement")
public class DepartementRest {

	@Autowired 
	private DepartementService departementService;

	@GetMapping("/libelle/{libelle}")
	public Departement findByLibelle(@PathVariable String libelle) {
		return departementService.findByLibelle(libelle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return departementService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Departement departement) {
		return departementService.save(departement);
	}
	@GetMapping("/")
	public List<Departement> findAll() {
		return departementService.findAll();
	}
	
	
}
