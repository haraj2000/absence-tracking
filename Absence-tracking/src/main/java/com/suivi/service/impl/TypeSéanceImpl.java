package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
	@Transactional
	public int deleteByLibelle(String libelle) {
		return typeSéanceDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(TypeSéance typeSéance) {
		TypeSéance typeSéanceFounded = findByLibelle(typeSéance.getLibelle());
		if(typeSéanceFounded == null) {
			typeSéanceDao.save(typeSéance);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<TypeSéance> findAll() {
		return typeSéanceDao.findAll();
	}

}
