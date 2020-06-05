package com.suivi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSession;

@Repository
public interface TypeSessionDao extends JpaRepository<TypeSession, Long>{

	public TypeSession  findByLibelle(String libelle);
	public TypeSession findByReference(String reference);
	public List<TypeSession> findByEnseignant(Enseignant enseignant);
	public List<TypeSession> findByModule(Module module);
	public int deleteByReference(String reference);			
}
