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

import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.service.facade.SemestreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les semestres")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/semestre")
public class SemestreRest {

	@Autowired
	private SemestreService semestreService;
	
	@ApiOperation("Rechercher un semestre par reférence")
	@GetMapping("/reference/{reference}")
	public Semestre findByReference(@PathVariable String reference) {
		return semestreService.findByReference(reference);
	}
	@ApiOperation("Rechercher des semestres par libelle")
	@GetMapping("/libelle/{libelle}")
	public List<Semestre> findByLibelle(@PathVariable String libelle) {
		return semestreService.findByLibelle(libelle);
	}
	@ApiOperation("Rechercher des semestres par année universitaire")
	@GetMapping("/anneeUniversitaire/{anneeUniversitaire}")
	public List<Semestre> findByAnneeUniversitaire(@PathVariable String anneeUniversitaire) {
		return semestreService.findByAnneeUniversitaire(anneeUniversitaire);
	}
	@ApiOperation("Rechercher des semestres par filière")
	@PostMapping("/sector")
	public List<Semestre> findBySector(@RequestBody Sector filiere) {
		return semestreService.findBySector(filiere);
	}
	@ApiOperation("Supprimer un semestre par reférence")
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return semestreService.deleteByReference(reference);
	}
	@ApiOperation("Enregistrer un semestre")
	@PostMapping("/{filiere}")
	public int save(@RequestBody Semestre semestre, @PathVariable String filiere) {
		return semestreService.save(semestre,filiere);
	}
	@ApiOperation("Rechercher tous les semestres enregistrés")
	@GetMapping("/")
	public List<Semestre> findAll() {
		return semestreService.findAll();
	}
	@ApiOperation("Rechercher des semestres par nombre")
	@GetMapping("/nombre/{nombre}")
	public List<Semestre> findByNumber(int number) {
		return semestreService.findByNumber(number);
	}
	@ApiOperation("Rechercher des semestres par filière et année universitaire")
	@PostMapping("/sectorAndAnneeUniversitaire/anneeUniversitaire/{anneeUniversitaire}")
	public List<Semestre> findBySectorAndAnneeUniversitaire(@RequestBody Sector sector,@PathVariable String anneeUniversitaire) {
		return semestreService.findBySectorAndAnneeUniversitaire(sector, anneeUniversitaire);
	}
	
	
}
