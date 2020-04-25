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

import com.suivi.bean.Département;
import com.suivi.service.facade.DépartementService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/departement")
public class DépartementRest {

	@Autowired 
	private DépartementService départementService;

	@GetMapping("/libelle/{libelle}")
	public Département findByLibelle(@PathVariable String libelle) {
		return départementService.findByLibelle(libelle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return départementService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Département département) {
		return départementService.save(département);
	}
	@GetMapping("/")
	public List<Département> findAll() {
		return départementService.findAll();
	}
	
	
}
