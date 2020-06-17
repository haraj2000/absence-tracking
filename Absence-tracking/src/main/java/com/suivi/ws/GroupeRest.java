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

import com.suivi.bean.Groupe;
import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.service.facade.GroupeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les groupes")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/groupe")
public class GroupeRest {
	@Autowired
	private GroupeService groupeService;

	@ApiOperation("Modifier un groupe")
	@PostMapping("/update")
	public int update(@RequestBody Groupe groupe) {
		return groupeService.update(groupe);
	}
	@ApiOperation("Rechercher un groupe par reférence")
	@GetMapping("/reference/{reference}")
	public Groupe findByReference(@PathVariable String reference) {
		return groupeService.findByReference(reference);
	}
	@ApiOperation("Rechercher des groupes par libelle")
	@GetMapping("/libelle/{libelle}")
	public List<Groupe> findByLibelle(@PathVariable String libelle) {
		return groupeService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer un groupe par reférence")
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return groupeService.deleteByReference(reference);
	}
	@ApiOperation("Enregistrer un groupe")
	@PostMapping("/")
	public Groupe save(@RequestBody Groupe groupe) {
		return groupeService.save(groupe);
	}
	@ApiOperation("Rechercher tous lezs groupes enregistrés")
	@GetMapping("/")
	public List<Groupe> findAll() {
		return groupeService.findAll();
	}
	@ApiOperation("Rechercher des groupes par semestre")
	@PostMapping("/semestre")
	public List<Groupe> findBySemestre(@RequestBody Semestre semestre) {
		return groupeService.findBySemestre(semestre);
	}
	@ApiOperation("Rechercher des groupes par filière")
	@PostMapping("/sector")
	public List<Groupe> findBySemestreSector(@RequestBody Sector sector) {
		return groupeService.findBySemestreSector(sector);
	}
	

}
