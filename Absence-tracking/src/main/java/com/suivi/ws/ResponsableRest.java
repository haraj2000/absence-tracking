package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Filière;
import com.suivi.bean.ResponsableFilière;
import com.suivi.service.facade.ResponsableFilièreService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class ResponsableRest {

	@Autowired
	private ResponsableFilièreService responsableFilièreService;

	public ResponsableFilière findByFilière(Filière filière) {
		return responsableFilièreService.findByFilière(filière);
	}

	public ResponsableFilière findByEnseignant(Enseignant enseignant) {
		return responsableFilièreService.findByEnseignant(enseignant);
	}

	public int deleteByFilière(Filière filière) {
		return responsableFilièreService.deleteByFilière(filière);
	}

	public int save(ResponsableFilière responsableFilière) {
		return responsableFilièreService.save(responsableFilière);
	}

	public int update(ResponsableFilière responsableFilière) {
		return responsableFilièreService.update(responsableFilière);
	}

	public List<ResponsableFilière> findAll() {
		return responsableFilièreService.findAll();
	}
	
}
