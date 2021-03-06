package com.suivi.service.facade;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Absence;
import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Notification;

public interface NotificationService {

	public Notification findByAbsence(Absence absence);
	public List<Notification> findByEnseignant(Enseignant enseignant);
	public List<Notification> findByState(String state);
	public Notification save(Notification notification);
	public int update(Notification notification);
	public int deleteByAbsence(String absence);
	public List<Notification> findAll();
	public List<Notification> findByAbsenceEtudiant(Etudiant etudiant);
	public int uplaodImage(MultipartFile file, String absence) throws IOException;
	public Notification getImage(Absence absence) throws IOException;
}
