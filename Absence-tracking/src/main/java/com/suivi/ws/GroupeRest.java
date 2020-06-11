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
import com.suivi.bean.Semestre;
import com.suivi.service.facade.GroupeService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/groupe")
public class GroupeRest {
	@Autowired
	private GroupeService groupeService;

	@PostMapping("/update")
	public int update(@RequestBody Groupe groupe) {
		return groupeService.update(groupe);
	}
	
	@GetMapping("/reference/{reference}")
	public Groupe findByReference(@PathVariable String reference) {
		return groupeService.findByReference(reference);
	}

	@GetMapping("/libelle/{libelle}")
	public Groupe findByLibelle(@PathVariable String libelle) {
		return groupeService.findByLibelle(libelle);
	}

	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return groupeService.deleteByReference(reference);
	}

	@PostMapping("/")
	public Groupe save(@RequestBody Groupe groupe) {
		return groupeService.save(groupe);
	}

	@GetMapping("/")
	public List<Groupe> findAll() {
		return groupeService.findAll();
	}
	@PostMapping("/semestre")
	public List<Groupe> findBySemestre(@RequestBody Semestre semestre) {
		return groupeService.findBySemestre(semestre);
	}
	

}
