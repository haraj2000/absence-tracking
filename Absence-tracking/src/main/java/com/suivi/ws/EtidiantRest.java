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

import com.suivi.bean.Etudiant;
import com.suivi.bean.Groupe;
import com.suivi.service.facade.EtudiantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class EtidiantRest {
	@Autowired
	private EtudiantService etudiantService;

	@GetMapping("/firstName/{firstName}")
	public List<Etudiant> findByFirstName(@PathVariable String firstName) {
		return etudiantService.findByFirstName(firstName);
	}

	@GetMapping("/lastName/{lastName}")
	public List<Etudiant> findByLastName(@PathVariable String lastName) {
		return etudiantService.findByLastName(lastName);
	}

	@GetMapping("/")
	public List<Etudiant> findByGroupe(@RequestBody Groupe groupe) {
		return etudiantService.findByGroupe(groupe);
	}

	@GetMapping("/cin/{cin}")
	public Etudiant findByCin(@PathVariable String cin) {
		return etudiantService.findByCin(cin);
	}

	@GetMapping("/mail/{mail}")
	public Etudiant findByMail(@PathVariable String mail) {
		return etudiantService.findByMail(mail);
	}

	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(String cin) {
		return etudiantService.deleteByCin(cin);
	}

	@PostMapping("/")
	public int save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}

	@PutMapping("/")
	public int update(@RequestBody Etudiant etudiant) {
		return etudiantService.update(etudiant);
	}

	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}

	@GetMapping("/cne/{cne}")
	public Etudiant findBynCne(@PathVariable String cne) {
		return etudiantService.findBynCne(cne);
	}

	@DeleteMapping("/cne/{cne}")
	public int deleteByCne(@PathVariable String cne) {
		return etudiantService.deleteByCne(cne);
	}
	
	
	
	

}
