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
import com.suivi.service.facade.GroupeService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class GroupeRest {
	@Autowired
	private GroupeService groupeService;

	@GetMapping("/libelle/{libelle}")
	public Groupe findByLibelle(@PathVariable String libelle) {
		return groupeService.findByLibelle(libelle);
	}

	@DeleteMapping("/libbelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return groupeService.deleteByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody Groupe groupe) {
		return groupeService.save(groupe);
	}

	@GetMapping("/")
	public List<Groupe> findAll() {
		return groupeService.findAll();
	}
	

}
