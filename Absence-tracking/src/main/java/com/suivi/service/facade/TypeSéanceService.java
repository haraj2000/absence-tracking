package com.suivi.service.facade;

import java.util.List;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Matière;
import com.suivi.bean.Module;
import com.suivi.bean.TypeSéance;

public interface TypeSéanceService {

	public TypeSéance  findByLibelle(String libelle);
	public List<TypeSéance> findByEnseignant(Enseignant enseignant);
	public List<TypeSéance> findByMatière(Matière matière);
	public List<TypeSéance> findByModule(Module module);
	public int deleteByLibelle(String libelle);		
	public int save(TypeSéance typeSéance);
	public int update(TypeSéance typeSéance);
	public List<TypeSéance> findAll();
}
