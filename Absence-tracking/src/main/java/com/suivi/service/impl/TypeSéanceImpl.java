package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;
import com.suivi.dao.TypeSéanceDao;
import com.suivi.service.facade.TypeSéanceService;

@Service
public class TypeSéanceImpl implements TypeSéanceService{

	@Autowired
	private TypeSéanceDao typeSéanceDao;
	
	@Override
	public TypeSéance findByLibelle(String libelle) {
		return typeSéanceDao.findByLibelle(libelle);
	}

	@Override
	public List<TypeSéance> findByEnseignant(Enseignant enseignant) {
		return typeSéanceDao.findByEnseignant(enseignant);
	}

	@Override
	public List<TypeSéance> findByMatière(Matière matière) {
		return typeSéanceDao.findByMatière(matière);
	}

	@Override
	public List<TypeSéance> findByModule(Module module) {
		return typeSéanceDao.findByModule(module);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return typeSéanceDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(TypeSéance typeSéance) {
		TypeSéance typeFormationFounded = findByLibelle(typeSéance.getLibelle());
		if(typeFormationFounded == null) {
			typeSéanceDao.save(typeSéance);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(TypeSéance typeSéance) {
		TypeSéance typeFormationFounded = findByLibelle(typeSéance.getLibelle());
		if(typeFormationFounded != null) {
			typeFormationFounded.setEnseignant(typeSéance.getEnseignant());
			typeSéanceDao.save(typeFormationFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<TypeSéance> findAll() {
		return typeSéanceDao.findAll();
	}

}
