package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Years;
import com.suivi.dao.YearsDao;
import com.suivi.service.facade.YearsService;

@Service
public class YearsImpl implements YearsService{

	@Autowired
	private YearsDao yearsDao;
	
	@Override
	public Years findByLibelle(String libelle) {
		return yearsDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return yearsDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Years years) {
		Years yearsFounded = findByLibelle(years.getLibelle());
		if (yearsFounded == null) {
			yearsDao.save(years);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Years> findAll() {
		return yearsDao.findAll();
	}

}
