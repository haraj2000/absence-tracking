package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Groupe;
import com.suivi.bean.Semestre;

public interface GroupeDao extends JpaRepository<Groupe, Long> {
	public Groupe findByLibelle(String libelle);
	public Groupe findByReference(String reference);
	public List<Groupe> findBySemestre(Semestre semestre);
	public int deleteByReference(String reference);
}
