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

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/filiere")
public class SectorRest {

	@Autowired
	private SectorService sectorService;

	@GetMapping("/libelle/{libelle}")
	public Sector findByLibelle(@PathVariable String libelle) {
		return sectorService.findByLibelle(libelle);
	}
	@GetMapping("/cycle")
	public List<Sector> findByCycle(@RequestBody Cycle cycle) {
		return sectorService.findByCycle(cycle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return sectorService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Sector sector) {
		return sectorService.save(sector);
	}
	@PostMapping("/update")
	public int update(@RequestBody Sector filiere) {
		return sectorService.update(filiere);
	}
	@GetMapping("/")
	public List<Sector> findAll() {
		return sectorService.findAll();
	}
}
