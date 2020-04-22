package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeFormation;

@Repository
public interface TypeFormationDao extends JpaRepository<TypeFormation, Long>{

	public TypeFormation  findByLibelle(String libelle);
	public List<TypeFormation> findByEnseignant(Enseignant enseignant);
	public List<TypeFormation> findByMatière(Matière matière);
	public List<TypeFormation> findByModule(Module module);
	public int deleteByLibelle(String libelle);			
}
