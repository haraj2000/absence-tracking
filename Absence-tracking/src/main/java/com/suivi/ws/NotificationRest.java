package com.suivi.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Absence;
import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Notification;
import com.suivi.service.facade.NotificationService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/notification")
public class NotificationRest {
	
	@Autowired
	private NotificationService notificationService;

	@PostMapping("/absence")
	public Notification findByAbsence(@RequestBody Absence absence) {
		return notificationService.findByAbsence(absence);
	}

	@PostMapping("/enseignant")
	public List<Notification> findByEnseignant(@RequestBody Enseignant enseignant) {
		return notificationService.findByEnseignant(enseignant);
	}

	@GetMapping("/state/{state}")
	public List<Notification> findByState(@PathVariable String state) {
		return notificationService.findByState(state);
	}

	@PostMapping("/")
	public Notification save(@RequestBody Notification notification) {
		return notificationService.save(notification);
	}

	@PostMapping("/update")
	public int update(@RequestBody Notification notification) {
		return notificationService.update(notification);
	}

	@DeleteMapping("/absence/{absence}")
	public int deleteByAbsence(@PathVariable  String absence) {
		return notificationService.deleteByAbsence(absence);
	}

	@GetMapping("/")
	public List<Notification> findAll() {
		return notificationService.findAll();
	}

	@PostMapping("/etudiant")
	public List<Notification> findByAbsenceEtudiant(@RequestBody Etudiant etudiant) {
		return notificationService.findByAbsenceEtudiant(etudiant);
	}
	
	

}
