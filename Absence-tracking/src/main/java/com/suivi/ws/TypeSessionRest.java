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

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/typeSession")
public class TypeSessionRest {
	
	@Autowired
	private TypeSessionService typeSessionService;

	@GetMapping("/libelle/{libelle}")
	public TypeSession findByLibelle(@PathVariable String libelle) {
		return typeSessionService.findByLibelle(libelle);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return typeSessionService.deleteByReference(reference);
	}
	@PostMapping("/")
	public int save(@RequestBody TypeSession typeSession) {
		return typeSessionService.save(typeSession);
	}
	@GetMapping("/")
	public List<TypeSession> findAll() {
		return typeSessionService.findAll();
	}

	@PostMapping("/enseignant")
	public List<TypeSession> findByEnseignant(@RequestBody Enseignant enseignant) {
		return typeSessionService.findByEnseignant(enseignant);
	}
	@PostMapping("/subject")
	public List<TypeSession> findBySubject(@RequestBody Subject subject) {
		return typeSessionService.findBySubject(subject);
	}
	@GetMapping("/reference/{reference}")
	public TypeSession findByReference(@PathVariable String reference) {
		return typeSessionService.findByReference(reference);
	}
	@PostMapping("/update")
	public int update(@RequestBody TypeSession typeSession) {
		return typeSessionService.update(typeSession);
	}
	@PostMapping("/module")
	public List<TypeSession> findByModule(@RequestBody Module module) {
		return typeSessionService.findByModule(module);
	}
	
}
