package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Filière;
import com.suivi.bean.ResponsableFilière;
import com.suivi.dao.ResponsableFilièreDao;
import com.suivi.service.facade.ResponsableFilièreService;

@Service
public class ResponsableImpl implements ResponsableFilièreService{

	@Autowired
	private ResponsableFilièreDao responsableFilièreDao;
	
	@Override
	public ResponsableFilière findByFilière(Filière filière) {
		return responsableFilièreDao.findByFilière(filière);
	}

	@Override
	public ResponsableFilière findByEnseignant(Enseignant enseignant) {
		return responsableFilièreDao.findByEnseignant(enseignant);
	}

	@Override
	public int deleteByFilière(Filière filière) {
		return responsableFilièreDao.deleteByFilière(filière);
	}

	@Override
	public int save(ResponsableFilière responsableFilière) {
		ResponsableFilière responsableFilièreFounded = findByFilière(responsableFilière.getFilière());
		if(responsableFilièreFounded == null) {
			responsableFilièreDao.save(responsableFilièreFounded);
			return 1;
		}
		else return -1;
	}

	@Override
	public int update(ResponsableFilière responsableFilière) {
		ResponsableFilière responsableFilièreFounded = findByFilière(responsableFilière.getFilière());
		if(responsableFilièreFounded != null) {
			responsableFilièreFounded.setEnseignant(responsableFilière.getEnseignant());
			return 1;
		}
		else return -1;
	}

	@Override
	public List<ResponsableFilière> findAll() {
		return responsableFilièreDao.findAll();
	}

}
