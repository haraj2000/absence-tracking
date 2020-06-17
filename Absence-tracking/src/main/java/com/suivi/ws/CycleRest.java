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

import com.suivi.bean.Cycle;
import com.suivi.service.facade.CycleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les cycles")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/cycle")
public class CycleRest {
	
	@Autowired
	private CycleService cycleService;

	@ApiOperation("Rechercher un cycle par libelle")
	@GetMapping("/libelle/{libelle}")
	public Cycle findByLibelle(@PathVariable String libelle) {
		return cycleService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer un cycle par libelle")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return cycleService.deleteByLibelle(libelle);
	}
	@ApiOperation("Enregistrer un cycle")
	@PostMapping("/")
	public int save(@RequestBody Cycle cycle) {
		return cycleService.save(cycle);
	}
	@ApiOperation("Rechercher tous les cycles enregistrés")
	@GetMapping("/")
	public List<Cycle> findAll() {
		return cycleService.findAll();
	}
	

}
