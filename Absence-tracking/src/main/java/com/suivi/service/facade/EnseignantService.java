package com.suivi.service.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.suivi.bean.Departement;
import com.suivi.bean.Enseignant;

public interface EnseignantService {

	public List<Enseignant> findByFirstName(String firstName);
	public List<Enseignant> findByLastName(String lastName);
	public Enseignant findByNumeroSOM(int numeroSOM);
	public Enseignant findByCin(String cin);
	public List<Enseignant> findByDepartement(Departement departement);
	public Enseignant findByMail(String mail);
	public int deleteByNumeroSOM(int numeroSOM);
	public int deleteByCin(String cin);
	public List<Enseignant> findByRole(int role);
	public Enseignant save(Enseignant enseignant);
	public Enseignant update(Enseignant enseignant);
	public List<Enseignant> findAll();
	public int uplaodImage(MultipartFile file, int numeroSOM) throws IOException;
	public Enseignant getImage(String cin) throws IOException;
	public Enseignant password(	Enseignant enseignant);
}
