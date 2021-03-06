package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;

@Repository
public interface SemestreDao extends JpaRepository<Semestre, Long>{

	public List<Semestre> findByLibelle(String libelle);
	public Semestre findByReference(String reference);
	public List<Semestre> findByAnneeUniversitaire(String anneeUniversitaire);
	public List<Semestre> findBySector(Sector sector);
	public List<Semestre> findByNumber(int number);
	public int deleteByReference(String reference);
	public List<Semestre> findBySectorAndAnneeUniversitaire(Sector sector, String anneeUniversitaire);
}
