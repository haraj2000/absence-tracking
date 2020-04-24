package com.suivi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Groupe;

public interface GroupeDao extends JpaRepository<Groupe, Long> {
	public Groupe findByLibelle(String libelle);
	public int deleteByLibelle(String libelle);

}
