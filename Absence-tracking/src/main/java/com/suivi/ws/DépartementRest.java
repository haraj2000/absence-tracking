package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Département;
import com.suivi.service.facade.DépartementService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class DépartementRest {

	@Autowired 
	private DépartementService départementService;

	public Département findByLibelle(String libelle) {
		return départementService.findByLibelle(libelle);
	}

	public int deleteByLibelle(String libelle) {
		return départementService.deleteByLibelle(libelle);
	}

	public int save(Département département) {
		return départementService.save(département);
	}

	public int update(Département département) {
		return départementService.update(département);
	}

	public List<Département> findAll() {
		return départementService.findAll();
	}
	
	
}
