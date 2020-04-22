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

import com.suivi.bean.Cycle;
import com.suivi.bean.Filière;
import com.suivi.service.facade.FilièreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class FilièreRest {

	@Autowired
	private FilièreService filièreService;

	@GetMapping("/libelle/{libelle}")
	public Filière findByLibelle(@PathVariable String libelle) {
		return filièreService.findByLibelle(libelle);
	}
	@GetMapping("/cycle")
	public List<Filière> findByCycle(@RequestBody Cycle cycle) {
		return filièreService.findByCycle(cycle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return filièreService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Filière filière) {
		return filièreService.save(filière);
	}
	@PutMapping("/")
	public int update(@RequestBody Filière filière) {
		return filièreService.update(filière);
	}
	@GetMapping("/")
	public List<Filière> findAll() {
		return filièreService.findAll();
	}
	
}
