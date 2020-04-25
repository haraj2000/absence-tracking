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
	public int deleteByLibelle(String libelle) {
		return séanceDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Séance séance) {
		String libelle = séance.getTypeSéance().getLibelle()+" "+ séance.getDate()+" "+ séance.getHourStart();
		Séance séanceFounded = findByLibelle(libelle);
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
		Séance séanceFounded = findByLibelle(séance.getLibelle());
		if(séanceFounded!= null) {
			String libelle = séance.getTypeSéance().getLibelle()+" "+ séance.getDate()+" "+ séance.getHourStart();
			séanceFounded.setLibelle(libelle);
			séanceFounded.setDate(séance.getDate());
			séanceFounded.setHourStart(séance.getHourStart());
			séanceFounded.setHourStop(séance.getHourStop());
			séanceDao.save(séanceFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Séance> findByDate(Date date) {
		return séanceDao.findByDate(date);
	}

	@Override
	public List<Séance> findByHourStart(Date hourStart) {
		return séanceDao.findByHourStart(hourStart);
	}

	@Override
	public List<Séance> findByHourStop(Date hourStop) {
		return séanceDao.findByHourStop(hourStop);
	}

	@Override
	public List<Séance> findByTypeSéance(TypeSéance typeSéance) {
		return séanceDao.findByTypeSéance(typeSéance);
	}

}
