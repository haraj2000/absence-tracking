package com.suivi.ws;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Absence;
import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Notification;
import com.suivi.service.facade.NotificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les notifications")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/notification")
public class NotificationRest {
	
	@Autowired
	private NotificationService notificationService;

	@ApiOperation("Rechercher une notification par une absence")
	@PostMapping("/absence")
	public Notification findByAbsence(@RequestBody Absence absence) {
		return notificationService.findByAbsence(absence);
	}
	@ApiOperation("Rechercher des notifications par un enseignant")
	@PostMapping("/enseignant")
	public List<Notification> findByEnseignant(@RequestBody Enseignant enseignant) {
		return notificationService.findByEnseignant(enseignant);
	}
	@ApiOperation("Rechercher des notifications par état")
	@GetMapping("/state/{state}")
	public List<Notification> findByState(@PathVariable String state) {
		return notificationService.findByState(state);
	}
	@ApiOperation("Enregistrer une notification")
	@PostMapping("/")
	public Notification save(@RequestBody Notification notification) {
		return notificationService.save(notification);
	}
	@ApiOperation("Modifier une notification")
	@PostMapping("/update")
	public int update(@RequestBody Notification notification) {
		return notificationService.update(notification);
	}
	@ApiOperation("Supprimer une notification par une absence")
	@DeleteMapping("/absence/{absence}")
	public int deleteByAbsence(@PathVariable  String absence) {
		return notificationService.deleteByAbsence(absence);
	}
	@ApiOperation("Rechercher tous les notifications enregistrées")
	@GetMapping("/")
	public List<Notification> findAll() {
		return notificationService.findAll();
	}
	@ApiOperation("Rechercher des notifications par un étudiant")
	@PostMapping("/etudiant")
	public List<Notification> findByAbsenceEtudiant(@RequestBody Etudiant etudiant) {
		return notificationService.findByAbsenceEtudiant(etudiant);
	}
	@ApiOperation("Enregister la photo d'une notification")
	@PostMapping("/upload/{absence}")
	public int uplaodImage(@RequestParam("imageFile") MultipartFile file,@PathVariable String absence) throws IOException {
		return notificationService.uplaodImage(file, absence);
	}
	@ApiOperation("Rechercher la photo d'une notification")
	@PostMapping("/get/absence")
	public Notification getImage(@RequestBody Absence absence) throws IOException {
		return notificationService.getImage(absence);
	}
	
	

}
