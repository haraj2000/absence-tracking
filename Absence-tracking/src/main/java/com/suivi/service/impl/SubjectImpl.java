package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Subject;
import com.suivi.dao.SubjectDao;
import com.suivi.service.facade.SubjectService;

@Service
public class SubjectImpl implements SubjectService{

	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public Subject findByLibelle(String libelle) {
		return subjectDao.findByLibelle(libelle);
	}

	@Override
	@Transactional
	public int deleteByLibelle(String libelle) {
		return subjectDao.deleteByLibelle(libelle);
	}

	@Override
	public int save(Subject subject) {
		Subject matièreFounded = findByLibelle(subject.getLibelle());
		if(matièreFounded == null) {
			subjectDao.save(subject);
			return 1;
		}
		else return -1;
	}


	@Override
	public List<Subject> findAll() {
		return subjectDao.findAll();
	}

	
}
