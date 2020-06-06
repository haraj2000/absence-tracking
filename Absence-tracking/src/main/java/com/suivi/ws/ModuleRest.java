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
import com.suivi.bean.Semestre;
import com.suivi.service.facade.ModuleService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/module")
public class ModuleRest {
	@Autowired
	private ModuleService moduleService;

	@GetMapping("/libelle/{libelle}")
	public Module findByLibelle(@PathVariable String libelle) {
		return moduleService.findByLibelle(libelle);
	}

	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return moduleService.deleteByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody Module module) {
		return moduleService.save(module);
	}

	@GetMapping("/")
	public List<Module> findAll() {
		return moduleService.findAll();
	}
	@GetMapping("/abreveation/{abreveation}")
	public List<Module> findByAbreveation(@PathVariable String abreveation) {
		return moduleService.findByAbreveation(abreveation);
	}
	@PostMapping("/semestre")
	public List<Module> findBySemestre(@RequestBody Semestre semestre) {
		return moduleService.findBySemestre(semestre);
	}
	

}
