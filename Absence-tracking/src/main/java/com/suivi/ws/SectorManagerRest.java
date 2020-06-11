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

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/sectorManager")
public class SectorManagerRest {

	@Autowired
	private SectorManagerService sectorManagerService;

	@PostMapping("/sector")
	public SectorManager findBySector(@RequestBody Sector sector) {
		return sectorManagerService.findBySector(sector);
	}
	@PostMapping("/enseignant")
	public SectorManager findByEnseignant(@RequestBody Enseignant enseignant) {
		return sectorManagerService.findByEnseignant(enseignant);
	}
	@DeleteMapping("/")
	public int deleteBySector(@RequestBody Sector sector) {
		return sectorManagerService.deleteBySector(sector);
	}
	@PostMapping("/{libelle}")
	public int save(@RequestBody SectorManager sectorManager, @PathVariable String libelle) {
		return sectorManagerService.save(sectorManager,libelle);
	}
	@PostMapping("/update/{libelle}")
	public int update(@RequestBody SectorManager sectorManager,@PathVariable String libelle) {
		return sectorManagerService.update(sectorManager,libelle);
	}
	@GetMapping("/")
	public List<SectorManager> findAll() {
		return sectorManagerService.findAll();
	}
	
}
