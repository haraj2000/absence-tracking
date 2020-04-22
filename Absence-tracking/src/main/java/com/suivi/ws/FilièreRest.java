package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Cycle;
import com.suivi.bean.Filière;
import com.suivi.service.facade.FilièreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class FilièreRest {

	@Autowired
	private FilièreService filièreService;

	public Filière findByLibelle(String libelle) {
		return filièreService.findByLibelle(libelle);
	}

	public List<Filière> findByCycle(Cycle cycle) {
		return filièreService.findByCycle(cycle);
	}

	public int deleteByLibelle(String libelle) {
		return filièreService.deleteByLibelle(libelle);
	}

	public int save(Filière filière) {
		return filièreService.save(filière);
	}

	public int update(Filière filière) {
		return filièreService.update(filière);
	}

	public List<Filière> findAll() {
		return filièreService.findAll();
	}
	
}
