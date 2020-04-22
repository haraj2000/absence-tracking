package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Enseignant;
import com.suivi.service.facade.EnseignantService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class EnseignantRest {
	
	@Autowired
	private EnseignantService enseignantService;

	public List<Enseignant> findByFirstName(String firstName) {
		return enseignantService.findByFirstName(firstName);
	}

	public List<Enseignant> findByFirstLast(String firstLast) {
		return enseignantService.findByFirstLast(firstLast);
	}

	public Enseignant findByMatricule(String matricule) {
		return enseignantService.findByMatricule(matricule);
	}

	public Enseignant findByCin(String cin) {
		return enseignantService.findByCin(cin);
	}

	public Enseignant findByMail(String mail) {
		return enseignantService.findByMail(mail);
	}

	public int deleteByMatricule(String matricule) {
		return enseignantService.deleteByMatricule(matricule);
	}

	public int deleteByCin(String cin) {
		return enseignantService.deleteByCin(cin);
	}

	public int save(Enseignant enseignant) {
		return enseignantService.save(enseignant);
	}

	public int update(Enseignant enseignant) {
		return enseignantService.update(enseignant);
	}

	public List<Enseignant> findAll() {
		return enseignantService.findAll();
	}

}
