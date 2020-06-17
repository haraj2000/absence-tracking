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

import com.suivi.bean.Years;
import com.suivi.service.facade.YearsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les années universitaires")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/years")
public class YearsRest {
	@Autowired
	private YearsService yearsService;

	@ApiOperation("Rechercher une année universitaire par libelle")
	@GetMapping("/libelle/{libelle}")
	public Years findByLibelle(@PathVariable String libelle) {
		return yearsService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer une année universitaire par libelle")
	@DeleteMapping("/libelle/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return yearsService.deleteByLibelle(libelle);
	}
	@ApiOperation("Enregistrer une année universitaire")
	@PostMapping("/")
	public int save(@RequestBody Years years) {
		return yearsService.save(years);
	}
	@ApiOperation("Rechercher tous les années universitaires enregistrées")
	@GetMapping("/")
	public List<Years> findAll() {
		return yearsService.findAll();
	}
	
	

}
