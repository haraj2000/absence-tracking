package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Subject;

public interface SubjectService {
	
	public Subject findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
	public int save(Subject subject);
	public List<Subject> findAll();
}
