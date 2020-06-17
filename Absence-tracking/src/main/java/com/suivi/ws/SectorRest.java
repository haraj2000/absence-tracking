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
import com.suivi.bean.Sector;
import com.suivi.service.facade.SectorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les filières")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/sector")
public class SectorRest {

	@Autowired
	private SectorService sectorService;

	@ApiOperation("Rechercher une filière par libelle")
	@GetMapping("/libelle/{libelle}")
	public Sector findByLibelle(@PathVariable String libelle) {
		return sectorService.findByLibelle(libelle);
	}
	@ApiOperation("Rechercher des filières par cycle")
	@GetMapping("/cycle")
	public List<Sector> findByCycle(@RequestBody Cycle cycle) {
		return sectorService.findByCycle(cycle);
	}
	@ApiOperation("Supprimer une filière par libelle")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return sectorService.deleteByLibelle(libelle);
	}
	@ApiOperation("Enregister une filière")
	@PostMapping("/")
	public int save(@RequestBody Sector sector) {
		return sectorService.save(sector);
	}
	@ApiOperation("Modifier une filière")
	@PostMapping("/update")
	public int update(@RequestBody Sector filiere) {
		return sectorService.update(filiere);
	}
	@ApiOperation("Rechercher tous les filières enregistrées")
	@GetMapping("/")
	public List<Sector> findAll() {
		return sectorService.findAll();
	}
}
