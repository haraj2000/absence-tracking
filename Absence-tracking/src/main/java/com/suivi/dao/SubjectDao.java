package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Subject;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Long>{

	public Subject findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);
}
