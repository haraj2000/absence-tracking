package com.suivi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Département;
import com.suivi.dao.DépartementDao;
import com.suivi.service.facade.DépartementService;

@Service
public class DépartementImpl implements DépartementService{

	@Autowired
	private DépartementDao départementDao;
	
	@Override
	public Département findByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByLibelle(String libelle) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Département département) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Département département) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Département> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
