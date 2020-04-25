package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;
import com.suivi.dao.TypeFormationDao;
import com.suivi.service.facade.TypeFormationService;

@Service
public class TypeFormationImpl implements TypeFormationService{

	@Autowired
	private TypeFormationDao typeFormationDao;
	
	@Override
	public TypeSéance findByLibelle(String libelle) {
		return typeFormationDao.findByLibelle(libelle);
	}

	@Override
	public List<TypeSéance> findByEnseignant(Enseignant enseignant) {
		return typeFormationDao.findByEnseignant(enseignant);
	}

	@Override
	public List<TypeSéance> findByMatière(Matière matière) {
		return typeFormationDao.findByMatière(matière);
	}

	@Override
	public List<TypeSéance> findByModule(Module module) {
		return typeFormationDao.findByModule(module);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return typeFormationDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(TypeSéance typeSéance) {
		TypeSéance typeFormationFounded = findByLibelle(typeSéance.getLibelle());
		if(typeFormationFounded == null) {
			typeFormationDao.save(typeSéance);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(TypeSéance typeSéance) {
		TypeSéance typeFormationFounded = findByLibelle(typeSéance.getLibelle());
		if(typeFormationFounded != null) {
			typeFormationFounded.setEnseignant(typeSéance.getEnseignant());
			return 1;
		}
		else return -1;
	}

	@Override
	public List<TypeSéance> findAll() {
		return typeFormationDao.findAll();
	}

}
