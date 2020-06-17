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

import com.suivi.bean.Enseignant;
import com.suivi.bean.Sector;
import com.suivi.bean.SectorManager;
import com.suivi.service.facade.SectorManagerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les responsables des filières")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/sectorManager")
public class SectorManagerRest {

	@Autowired
	private SectorManagerService sectorManagerService;

	@ApiOperation("Rechercher un responsable de filière par filière")
	@PostMapping("/sector")
	public SectorManager findBySector(@RequestBody Sector sector) {
		return sectorManagerService.findBySector(sector);
	}
	@ApiOperation("Rechercher un responsable de filière par enseignant")
	@PostMapping("/enseignant")
	public SectorManager findByEnseignant(@RequestBody Enseignant enseignant) {
		return sectorManagerService.findByEnseignant(enseignant);
	}
	@ApiOperation("Supprimer un responsable de filière par filière")
	@DeleteMapping("/")
	public int deleteBySector(@RequestBody Sector sector) {
		return sectorManagerService.deleteBySector(sector);
	}
	@ApiOperation("Enregistrer un responsable de filière")
	@PostMapping("/{libelle}")
	public int save(@RequestBody SectorManager sectorManager, @PathVariable String libelle) {
		return sectorManagerService.save(sectorManager,libelle);
	}
	@ApiOperation("Modifier un responsable de filière")
	@PostMapping("/update/{libelle}")
	public int update(@RequestBody SectorManager sectorManager,@PathVariable String libelle) {
		return sectorManagerService.update(sectorManager,libelle);
	}
	@ApiOperation("Rechercher tous les responsables des filières enregistrés")
	@GetMapping("/")
	public List<SectorManager> findAll() {
		return sectorManagerService.findAll();
	}
	
}
