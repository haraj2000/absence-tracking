package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Module;
import com.suivi.bean.Subject;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Long>{

	public Subject findByLibelle(String libelle);
	public List<Subject> findByModule(Module module);
	public int deleteByLibelle(String libelle);
}
