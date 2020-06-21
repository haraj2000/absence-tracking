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
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.util.SessionEtudiant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les absences")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/absence")
public class AbsenceRest {
	
	@Autowired
	private AbsenceService absenceService;


	@ApiOperation("Rechercher des absences d'un étudiant")
	@PostMapping("/etudiant")
	public List<Absence> findByEtudiant(@RequestBody Etudiant etudiant) {
		return absenceService.findByEtudiant(etudiant);
	}
	@ApiOperation("Enregister une absence")
	@PostMapping("/")
	public Absence save(@RequestBody Absence absence) {
		return absenceService.save(absence);
	}
	@ApiOperation("Modifier une absence")
	@PostMapping("/update")
	public int update(@RequestBody Absence absence) {
		return absenceService.update(absence);
	}
	@ApiOperation("Rechercher tous les absences enregistrées")
	@GetMapping("/")
	public List<Absence> findAll() {
		return absenceService.findAll();
	}
	@ApiOperation("Rechercher une absence par reférence")
	@GetMapping("/ref/{ref}")
	public Absence findByRef(@PathVariable String ref) {
		return absenceService.findByRef(ref);
	}

	@ApiOperation("Supprimer une absence par reférence")
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return absenceService.deleteByRef(ref);
	}

	@ApiOperation("Rechercher des absences d'une séance")
	@PostMapping("/session")
	public List<Absence> findBySession(@RequestBody Session session) {
		return absenceService.findBySession(session);
	}
	@ApiOperation("Rechercher des absences d'un module")
	@PostMapping("/module")
	public List<Absence> findBySessionTypeSessionModule(@RequestBody Module module) {
		return absenceService.findBySessionTypeSessionModule(module);
	}
	@ApiOperation("Rechercher des absences d'un type séance")
	@PostMapping("/typeSession")
	public List<Absence> findBySessionTypeSession(@RequestBody TypeSession typeSession) {
		return absenceService.findBySessionTypeSession(typeSession);
	}

	@ApiOperation("Rechercher des absences d'un étudiant pendant une séance")
	@PostMapping("/sessionEtudiant")
	public Absence findBySessionAndEtudiant(@RequestBody SessionEtudiant sessionEtudiant) {
		return absenceService.findBySessionAndEtudiant(sessionEtudiant.getSession(),sessionEtudiant.getEtudiant());
	}
	@ApiOperation("Enregister le justificatif d'une absence")
	@PostMapping("/upload/{reference}")
	public int uplaodImage(@RequestParam("imageFile") MultipartFile file,@PathVariable String reference) throws IOException {
		return absenceService.uplaodImage(file, reference);
	}
	@ApiOperation("Rechercher le justificatif d'une absence")
	@GetMapping("/get/{reference}")
	public Absence getImage(@PathVariable String reference) throws IOException {
		return absenceService.getImage(reference);
	}
	
	
	

}
