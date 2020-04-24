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

import com.suivi.bean.Matière;
import com.suivi.service.facade.MatièreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/matière")
public class MatièreRest {

	@Autowired
	private MatièreService matièreService;

	@GetMapping("/libelle/{libelle}")
	public Matière findByLibelle(@PathVariable String libelle) {
		return matièreService.findByLibelle(libelle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return matièreService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Matière matière) {
		return matièreService.save(matière);
	}
	@GetMapping("/")
	public List<Matière> findAll() {
		return matièreService.findAll();
	}

	
	
}
