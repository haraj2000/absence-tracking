package com.suivi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;

@Repository
public interface TypeSéanceDao extends JpaRepository<TypeSéance, Long>{

	public TypeSéance  findByLibelle(String libelle);
	public TypeSéance findByReference(String reference);
	public List<TypeSéance> findByEnseignant(Enseignant enseignant);
	public List<TypeSéance> findByModule(Module module);
	public int deleteByReference(String reference);			
}
