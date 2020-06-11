package com.suivi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suivi.bean.Absence;
import com.suivi.bean.Enseignant;
import com.suivi.bean.Notification;

@Repository
public interface NotificationDao extends JpaRepository<Notification, Long> {

	public Notification findByAbsence(Absence absence);
	public List<Notification> findByEnseignant(Enseignant enseignant);
	public List<Notification> findByState(String state);
	public int deleteByAbsence(Absence absence);
}
