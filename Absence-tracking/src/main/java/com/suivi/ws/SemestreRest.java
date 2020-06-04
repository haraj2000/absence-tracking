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

import com.suivi.bean.Filière;
import com.suivi.bean.Semestre;
import com.suivi.service.facade.SemestreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/semestre")
public class SemestreRest {

	@Autowired
	private SemestreService semestreService;
	
	@PostMapping("/update")
	public int update(@RequestBody Semestre semestre) {
		return semestreService.update(semestre);
	}
	@GetMapping("/reference/{reference}")
	public Semestre findByReference(@PathVariable String reference) {
		return semestreService.findByReference(reference);
	}
	@GetMapping("/libelle/{libelle}")
	public Semestre findByLibelle(@PathVariable String libelle) {
		return semestreService.findByLibelle(libelle);
	}
	@GetMapping("/anneeUniversitaire/{anneeUniversitaire}")
	public List<Semestre> findByAnneeUniversitaire(@PathVariable String anneeUniversitaire) {
		return semestreService.findByAnneeUniversitaire(anneeUniversitaire);
	}
	@GetMapping("/filiere")
	public List<Semestre> findByFiliere(@RequestBody Filière filiere) {
		return semestreService.findByFiliere(filiere);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return semestreService.deleteByReference(reference);
	}
	@PostMapping("/{filiere}")
	public int save(@RequestBody Semestre semestre, @PathVariable String filiere) {
		return semestreService.save(semestre,filiere);
	}
	@GetMapping("/")
	public List<Semestre> findAll() {
		return semestreService.findAll();
	}
	@GetMapping("/nombre/{nombre}")
	public List<Semestre> findByNumber(int number) {
		return semestreService.findByNumber(number);
	}
	
}
