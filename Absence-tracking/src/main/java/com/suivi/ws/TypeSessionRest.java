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
import com.suivi.bean.Subject;
import com.suivi.bean.TypeSession;
import com.suivi.service.facade.TypeSessionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les types séance")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/typeSession")
public class TypeSessionRest {
	
	@Autowired
	private TypeSessionService typeSessionService;

	@ApiOperation("Rechercher un type séance par libelle")
	@GetMapping("/libelle/{libelle}")
	public TypeSession findByLibelle(@PathVariable String libelle) {
		return typeSessionService.findByLibelle(libelle);
	}
	@ApiOperation("Rechercher un type séance par reference")
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return typeSessionService.deleteByReference(reference);
	}
	@ApiOperation("Enregistrer un type séance")
	@PostMapping("/")
	public int save(@RequestBody TypeSession typeSession) {
		return typeSessionService.save(typeSession);
	}
	@ApiOperation("Rechercher tous les types séance enregistrés")
	@GetMapping("/")
	public List<TypeSession> findAll() {
		return typeSessionService.findAll();
	}
	@ApiOperation("Rechercher des types séance par enseignant")
	@PostMapping("/enseignant")
	public List<TypeSession> findByEnseignant(@RequestBody Enseignant enseignant) {
		return typeSessionService.findByEnseignant(enseignant);
	}
	@ApiOperation("Rechercher des types séance par matière")
	@PostMapping("/subject")
	public List<TypeSession> findBySubject(@RequestBody Subject subject) {
		return typeSessionService.findBySubject(subject);
	}
	@ApiOperation("Rechercher un type séance par reférence")
	@GetMapping("/reference/{reference}")
	public TypeSession findByReference(@PathVariable String reference) {
		return typeSessionService.findByReference(reference);
	}
	@ApiOperation("Modifier un type séance")
	@PostMapping("/update")
	public int update(@RequestBody TypeSession typeSession) {
		return typeSessionService.update(typeSession);
	}
	@ApiOperation("Rechercher des types séance par module")
	@PostMapping("/module")
	public List<TypeSession> findByModule(@RequestBody Module module) {
		return typeSessionService.findByModule(module);
	}
	
}
