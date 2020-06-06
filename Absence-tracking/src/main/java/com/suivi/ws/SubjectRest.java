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

import com.suivi.bean.Module;
import com.suivi.bean.Subject;
import com.suivi.service.facade.SubjectService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/subject")
public class SubjectRest {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/libelle/{libelle}")
	public Subject findByLibelle(@PathVariable String libelle) {
		return subjectService.findByLibelle(libelle);
	}
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return subjectService.deleteByLibelle(libelle);
	}
	@PostMapping("/")
	public int save(@RequestBody Subject subject) {
		return subjectService.save(subject);
	}
	@GetMapping("/")
	public List<Subject> findAll() {
		return subjectService.findAll();
	}
	@PostMapping("/module")
	public List<Subject> findByModule(@RequestBody Module module) {
		return subjectService.findByModule(module);
	}

	
	
}
