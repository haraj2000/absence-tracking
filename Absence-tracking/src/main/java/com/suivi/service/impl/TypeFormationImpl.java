package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeFormation;
import com.suivi.dao.TypeFormationDao;
import com.suivi.service.facade.TypeFormationService;

@Service
public class TypeFormationImpl implements TypeFormationService{

	@Autowired
	private TypeFormationDao typeFormationDao;
	
	@Override
	public TypeFormation findByLibelle(String libelle) {
		return typeFormationDao.findByLibelle(libelle);
	}

	@Override
	public List<TypeFormation> findByEnseignant(Enseignant enseignant) {
		return typeFormationDao.findByEnseignant(enseignant);
	}

	@Override
	public List<TypeFormation> findByMatière(Matière matière) {
		return typeFormationDao.findByMatière(matière);
	}

	@Override
	public List<TypeFormation> findByModule(Module module) {
		return typeFormationDao.findByModule(module);
	}

	@Override
	public int deleteByLibelle(String libelle) {
		return typeFormationDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(TypeFormation typeFormation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TypeFormation typeFormation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TypeFormation> findAll() {
		return typeFormationDao.findAll();
	}

}
