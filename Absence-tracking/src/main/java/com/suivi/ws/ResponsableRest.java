package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Filière;
import com.suivi.bean.ResponsableFilière;
import com.suivi.service.facade.ResponsableFilièreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/responsable")
public class ResponsableRest {

	@Autowired
	private ResponsableFilièreService responsableFilièreService;

	@GetMapping("/filiere")
	public ResponsableFilière findByFilière(@RequestBody Filière filière) {
		return responsableFilièreService.findByFilière(filière);
	}
	@GetMapping("/enseignant")
	public ResponsableFilière findByEnseignant(@RequestBody Enseignant enseignant) {
		return responsableFilièreService.findByEnseignant(enseignant);
	}
	@DeleteMapping("/")
	public int deleteByFilière(@RequestBody Filière filière) {
		return responsableFilièreService.deleteByFilière(filière);
	}
	@PostMapping("/")
	public int save(@RequestBody ResponsableFilière responsableFilière) {
		return responsableFilièreService.save(responsableFilière);
	}
	@PostMapping("/update")
	public int update(@RequestBody ResponsableFilière responsableFilière) {
		return responsableFilièreService.update(responsableFilière);
	}
	@GetMapping("/")
	public List<ResponsableFilière> findAll() {
		return responsableFilièreService.findAll();
	}
	
}
