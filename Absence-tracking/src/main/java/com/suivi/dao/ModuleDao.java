package com.suivi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suivi.bean.Module;
import com.suivi.bean.Semestre;

public interface ModuleDao extends JpaRepository<Module, Long> {
	public Module findByLibelle(String libelle);
	public List<Module> findByAbreveation(String abreveation);
	public List<Module> findBySemestre(Semestre semestre);
	public int deleteByLibelle(String libelle);
}
