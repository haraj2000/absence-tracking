package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeFormation;

public interface TypeFormationService {

	public TypeFormation  findByLibelle(String libelle);
	public List<TypeFormation> findByEnseignant(Enseignant enseignant);
	public List<TypeFormation> findByMatière(Matière matière);
	public List<TypeFormation> findByModule(Module module);
	public int deleteByLibelle(String libelle);	
	public int save(TypeFormation typeFormation);
	public int update(TypeFormation typeFormation);
	public List<TypeFormation> findAll();
}
