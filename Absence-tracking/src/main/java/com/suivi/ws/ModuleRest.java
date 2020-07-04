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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les modules")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/module")
public class ModuleRest {
	
	@Autowired
	private ModuleService moduleService;

	@ApiOperation("Rechercher un module par libelle")
	@GetMapping("/libelle/{libelle}")
	public Module findByLibelle(@PathVariable String libelle) {
		return moduleService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer un module par libelle")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return moduleService.deleteByLibelle(libelle);
	}
	@ApiOperation("Enregister un module")
	@PostMapping("/")
	public Module save(@RequestBody Module module) {
		return moduleService.save(module);
	}
	@ApiOperation("Rechercher tous les modules enregistrés")
	@GetMapping("/")
	public List<Module> findAll() {
		return moduleService.findAll();
	}
	@ApiOperation("Rechercher des modules par abrévéation")
	@GetMapping("/abreveation/{abreveation}")
	public List<Module> findByAbreveation(@PathVariable String abreveation) {
		return moduleService.findByAbreveation(abreveation);
	}
	@ApiOperation("Rechercher des modules par semestre")
	@PostMapping("/semestre")
	public List<Module> findBySemestre(@RequestBody Semestre semestre) {
		return moduleService.findBySemestre(semestre);
	}
	

}
