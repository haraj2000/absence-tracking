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

import com.suivi.bean.Compte;
import com.suivi.service.facade.CompteService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/compte")
public class CompteRest {
	@Autowired
	private CompteService compteService;

	@GetMapping("/mail/{mail}")
	public Compte findByMail(@PathVariable String mail) {
		return compteService.findByMail(mail);
	}

	@DeleteMapping("/mail/{mail}")
	public int deleteByMail(@PathVariable String mail) {
		return compteService.deleteByMail(mail);
	}

	@PostMapping("/")
	public int save(@RequestBody Compte compte) {
		return compteService.save(compte);
	}

	@GetMapping("/")
	public List<Compte> findAll() {
		return compteService.findAll();
	}

	@GetMapping("/role/{role}")
	public Compte findByRole(@PathVariable String role) {
		return compteService.findByRole(role);
	}

	@PutMapping("/")
	public int update(@RequestBody Compte compte) {
		return compteService.update(compte);
	}
	
	
	

}
