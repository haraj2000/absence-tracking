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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les département")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/departement")
public class DepartementRest {

	@Autowired 
	private DepartementService departementService;

	@ApiOperation("Rechercher un département par libelle")
	@GetMapping("/libelle/{libelle}")
	public Departement findByLibelle(@PathVariable String libelle) {
		return departementService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer un département par libelle")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return departementService.deleteByLibelle(libelle);
	}
	@ApiOperation("Enregistrer un département")
	@PostMapping("/")
	public int save(@RequestBody Departement departement) {
		return departementService.save(departement);
	}
	@ApiOperation("Rechercher tous les départements enregistrés")
	@GetMapping("/")
	public List<Departement> findAll() {
		return departementService.findAll();
	}
	
	
}
