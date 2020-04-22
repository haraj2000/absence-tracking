package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Matière;
import com.suivi.service.facade.MatièreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class MatièreRest {

	@Autowired
	private MatièreService matièreService;

	public Matière findByLibelle(String libelle) {
		return matièreService.findByLibelle(libelle);
	}

	public int deleteByLibelle(String libelle) {
		return matièreService.deleteByLibelle(libelle);
	}

	public int save(Matière matière) {
		return matièreService.save(matière);
	}

	public int update(Matière matière) {
		return matièreService.update(matière);
	}

	public List<Matière> findAll() {
		return matièreService.findAll();
	}

	
	
}
