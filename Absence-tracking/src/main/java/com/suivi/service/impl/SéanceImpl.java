package com.suivi.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Séance;
import com.suivi.bean.TypeSéance;
import com.suivi.dao.SéanceDao;
import com.suivi.service.facade.SéanceService;

@Service
public class SéanceImpl implements SéanceService {
	@Autowired
	private SéanceDao séanceDao;

	@Override
	public Séance findByLibelle(String libelle) {
		return séanceDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByReference(String reference) {
		return séanceDao.deleteByReference(reference);
	}

	@Override
	public int save(Séance séance) {
		String libelle = séance.getTypeSéance().getLibelle()+" "+ séance.getTypeSéance().getModule().getLibelle();
		Séance séanceFounded = findByReference(séance.getReference());
		if(séanceFounded == null) {
			séance.setLibelle(libelle);
			séanceDao.save(séance);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Séance> findAll() {
		return séanceDao.findAll();
	}

	@Override
	public int update(Séance séance) {
		Séance séanceFounded = findByReference(séance.getReference());
		if(séanceFounded!= null) {
			String libelle = séance.getTypeSéance().getLibelle()+" "+ séance.getTypeSéance().getModule().getLibelle();
			séanceFounded.setLibelle(libelle);
			séanceFounded.setDateStart(séance.getDateStart());
			séanceFounded.setDateStop(séance.getDateStop());
			séanceFounded.setGroupes(séance.getGroupes());
			séanceDao.save(séanceFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Séance> findByDateStart(Date date) {
		return séanceDao.findByDateStart(date);
	}

	@Override
	public List<Séance> findByDateStop(Date hourStart) {
		return séanceDao.findByDateStop(hourStart);
	}
	@Override
	public List<Séance> findByTypeSéance(TypeSéance typeSéance) {
		return séanceDao.findByTypeSéance(typeSéance);
	}

	@Override
	public Séance findByReference(String reference) {
		return séanceDao.findByReference(reference);
	}
}

