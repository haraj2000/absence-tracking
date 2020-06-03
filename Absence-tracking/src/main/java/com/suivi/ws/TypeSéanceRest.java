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
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;
import com.suivi.service.facade.TypeSéanceService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/typeSeance")
public class TypeSéanceRest {
	
	@Autowired
	private TypeSéanceService typeSéanceService;

	@GetMapping("/libelle/{libelle}")
	public TypeSéance findByLibelle(@PathVariable String libelle) {
		return typeSéanceService.findByLibelle(libelle);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return typeSéanceService.deleteByReference(reference);
	}
	@PostMapping("/")
	public int save(@RequestBody TypeSéance typeSéance) {
		return typeSéanceService.save(typeSéance);
	}
	@GetMapping("/")
	public List<TypeSéance> findAll() {
		return typeSéanceService.findAll();
	}

	@GetMapping("/enseignant")
	public List<TypeSéance> findByEnseignant(@RequestBody Enseignant enseignant) {
		return typeSéanceService.findByEnseignant(enseignant);
	}
	@GetMapping("/module")
	public List<TypeSéance> findByModule(@RequestBody Module module) {
		return typeSéanceService.findByModule(module);
	}
	@GetMapping("/reference/{reference}")
	public TypeSéance findByReference(@PathVariable String reference) {
		return typeSéanceService.findByReference(reference);
	}
	@PostMapping("/update")
	public int update(@RequestBody TypeSéance typeSéance) {
		return typeSéanceService.update(typeSéance);
	}
	
}
