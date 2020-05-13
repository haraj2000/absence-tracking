package com.suivi.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Filière;
import com.suivi.bean.Semestre;

@Repository
public interface SemestreDao extends JpaRepository<Semestre, Long>{

	public Semestre findByLibelle(String libelle);
	public Semestre findByReference(String reference);
	public List<Semestre> findByAnnéeUniversitaire(Date annéeUniversitaire);
	public List<Semestre> findByFilière(Filière filière);
	public List<Semestre> findByNumber(int number);
	public int deleteByReference(String reference);
}
