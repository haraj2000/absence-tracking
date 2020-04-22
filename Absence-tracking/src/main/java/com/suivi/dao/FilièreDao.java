package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Cycle;
import com.suivi.bean.Filière;

@Repository
public interface FilièreDao extends JpaRepository<Filière, Long>{

	public Filière findByLibelle(String libelle);
	public List<Filière> findByCycle(Cycle cycle);
	public int deleteByLibelle(String libelle);
}
