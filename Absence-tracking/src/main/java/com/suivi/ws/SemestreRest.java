package com.suivi.ws;

import java.util.Date;
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

import com.suivi.bean.Filière;
import com.suivi.bean.Semestre;
import com.suivi.service.facade.SemestreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/semestre")
public class SemestreRest {

	@Autowired
	private SemestreService semestreService;
	
	@PutMapping("/")
	public int update(@RequestBody Semestre semestre) {
		return semestreService.update(semestre);
	}
	@GetMapping("/libelle/{libelle}")
	public Semestre findByLibelle(@PathVariable String libelle) {
		return semestreService.findByLibelle(libelle);
	}
	@GetMapping("/annéeUniversitaire/{annéeUniversitaire}")
	public List<Semestre> findByAnnéeUniversitaire(@PathVariable Date annéeUniversitaire) {
		return semestreService.findByAnnéeUniversitaire(annéeUniversitaire);
	}
	@GetMapping("/filière")
	public List<Semestre> findByFilière(@RequestBody Filière filière) {
		return semestreService.findByFilière(filière);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return semestreService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Semestre semestre) {
		return semestreService.save(semestre);
	}
	@GetMapping("/")
	public List<Semestre> findAll() {
		return semestreService.findAll();
	}
	
	
}