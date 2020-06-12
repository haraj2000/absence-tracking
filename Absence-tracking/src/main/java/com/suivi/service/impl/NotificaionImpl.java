package com.suivi.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suivi.bean.Absence;
import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Notification;
import com.suivi.dao.NotificationDao;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.facade.NotificationService;

@Service
public class NotificaionImpl implements NotificationService{

	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private AbsenceService absenceService;

	@Override
	public Notification findByAbsence(Absence absence) {
		return notificationDao.findByAbsence(absence);
	}

	@Override
	public List<Notification> findByEnseignant(Enseignant enseignant) {
		return notificationDao.findByEnseignant(enseignant);
	}

	@Override
	public List<Notification> findByState(String state) {
		System.out.println("coucou chui la");
		System.out.println(notificationDao.findByState(state));
		return notificationDao.findByState(state);
	}

	@Override
	public Notification save(Notification notification) {
		Notification notificationFounded = findByAbsence(notification.getAbsence());
		if (notificationFounded == null) {
			notification.setEnseignant(notification.getAbsence().getSession().getTypeSession().getEnseignant());
			notificationDao.save(notification);
			return notification;
		}
		return null;
	}

	@Override
	public int update(Notification notification) {
		Notification notificationFounded = findByAbsence(notification.getAbsence());
		if (notificationFounded != null) {
			notificationFounded.setContenu(notification.getContenu());
			notificationFounded.setState(notification.getState());
			notificationDao.save(notificationFounded);
			return 1;
		}
		return -1;
	}

	@Override
	@Transactional
	public int deleteByAbsence(String absence) {
		absenceService.findByRef(absence);
		Absence absenceFouned = absenceService.findByRef(absence);
		return notificationDao.deleteByAbsence(absenceFouned);
	}

	@Override
	public List<Notification> findAll() {
		return notificationDao.findAll();
	}

	@Override
	public List<Notification> findByAbsenceEtudiant(Etudiant etudiant) {
		return notificationDao.findByAbsenceEtudiant(etudiant);
	}
}
