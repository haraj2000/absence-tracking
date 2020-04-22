package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Cycle;
import com.suivi.service.facade.CycleService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class CycleRest {
	
	@Autowired
	private CycleService cycleService;

	public Cycle findByLibelle(String libelle) {
		return cycleService.findByLibelle(libelle);
	}

	public int deleteByLibelle(String libelle) {
		return cycleService.deleteByLibelle(libelle);
	}

	public int save(Cycle cycle) {
		return cycleService.save(cycle);
	}

	public int update(Cycle cycle) {
		return cycleService.update(cycle);
	}

	public List<Cycle> findAll() {
		return cycleService.findAll();
	}
	

}
