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

import com.suivi.bean.Subject;
import com.suivi.service.facade.SubjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les matières")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/subject")
public class SubjectRest {

	@Autowired
	private SubjectService subjectService;

	@ApiOperation("Rechercher une matière par libelle")
	@GetMapping("/libelle/{libelle}")
	public Subject findByLibelle(@PathVariable String libelle) {
		return subjectService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer une matière par libelle")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return subjectService.deleteByLibelle(libelle);
	}
	@ApiOperation("Enregistrer une matière")
	@PostMapping("/")
	public int save(@RequestBody Subject subject) {
		return subjectService.save(subject);
	}
	@ApiOperation("Rechercher tous les matières enregistrées")
	@GetMapping("/")
	public List<Subject> findAll() {
		return subjectService.findAll();
	}

	
	
}
