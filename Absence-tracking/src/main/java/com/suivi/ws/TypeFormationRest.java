package com.suivi.ws;

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

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;
import com.suivi.service.facade.TypeFormationService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/typeFormation")
public class TypeFormationRest {
	
	@Autowired
	private TypeFormationService formationService;

	@GetMapping("/libelle/{libelle}")
	public TypeSéance findByLibelle(@PathVariable String libelle) {
		return formationService.findByLibelle(libelle);
	}
	@GetMapping("/enseignant")
	public List<TypeSéance> findByEnseignant(@RequestBody Enseignant enseignant) {
		return formationService.findByEnseignant(enseignant);
	}
	@GetMapping("/matière")
	public List<TypeSéance> findByMatière(@RequestBody Matière matière) {
		return formationService.findByMatière(matière);
	}
	@GetMapping("/module")
	public List<TypeSéance> findByModule(@RequestBody Module module) {
		return formationService.findByModule(module);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return formationService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody TypeSéance typeSéance) {
		return formationService.save(typeSéance);
	}
	@PutMapping("/")
	public int update(@RequestBody TypeSéance typeSéance) {
		return formationService.update(typeSéance);
	}
	@GetMapping("/")
	public List<TypeSéance> findAll() {
		return formationService.findAll();
	}
	

}
