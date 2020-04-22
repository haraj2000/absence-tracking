package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeFormation;
import com.suivi.service.facade.TypeFormationService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("pfe/absence-tracking")
public class TypeFormationRest {
	
	@Autowired
	private TypeFormationService formationService;

	public TypeFormation findByLibelle(String libelle) {
		return formationService.findByLibelle(libelle);
	}

	public List<TypeFormation> findByEnseignant(Enseignant enseignant) {
		return formationService.findByEnseignant(enseignant);
	}

	public List<TypeFormation> findByMatière(Matière matière) {
		return formationService.findByMatière(matière);
	}

	public List<TypeFormation> findByModule(Module module) {
		return formationService.findByModule(module);
	}

	public int deleteByLibelle(String libelle) {
		return formationService.deleteByLibelle(libelle);
	}

	public int save(TypeFormation typeFormation) {
		return formationService.save(typeFormation);
	}

	public int update(TypeFormation typeFormation) {
		return formationService.update(typeFormation);
	}

	public List<TypeFormation> findAll() {
		return formationService.findAll();
	}
	

}
