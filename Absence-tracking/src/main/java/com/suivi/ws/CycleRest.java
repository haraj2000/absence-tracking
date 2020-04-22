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
import com.suivi.service.facade.CycleService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class CycleRest {
	
	@Autowired
	private CycleService cycleService;

	@GetMapping("/libelle/{libelle}")
	public Cycle findByLibelle(@PathVariable String libelle) {
		return cycleService.findByLibelle(libelle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return cycleService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Cycle cycle) {
		return cycleService.save(cycle);
	}
	@PutMapping("/")
	public int update(@RequestBody Cycle cycle) {
		return cycleService.update(cycle);
	}
	@GetMapping("/")
	public List<Cycle> findAll() {
		return cycleService.findAll();
	}
	

}
