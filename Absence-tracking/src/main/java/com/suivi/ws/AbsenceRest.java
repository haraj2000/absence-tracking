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
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.util.SessionEtudiant;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/absence")
public class AbsenceRest {
	
	@Autowired
	private AbsenceService absenceService;



	@PostMapping("/etudiant")
	public List<Absence> findByEtudiant(@RequestBody Etudiant etudiant) {
		return absenceService.findByEtudiant(etudiant);
	}

	@PostMapping("/")
	public Absence save(@RequestBody Absence absence) {
		return absenceService.save(absence);
	}

	@PostMapping("/update")
	public int update(@RequestBody Absence absence) {
		return absenceService.update(absence);
	}

	@GetMapping("/")
	public List<Absence> findAll() {
		return absenceService.findAll();
	}

	@GetMapping("/ref/{ref}")
	public Absence findByRef(@PathVariable String ref) {
		return absenceService.findByRef(ref);
	}


	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return absenceService.deleteByRef(ref);
	}


	@PostMapping("/session")
	public List<Absence> findBySession(@RequestBody Session session) {
		return absenceService.findBySession(session);
	}

	@PostMapping("/module")
	public List<Absence> findBySessionTypeSessionModule(@RequestBody Module module) {
		return absenceService.findBySessionTypeSessionModule(module);
	}

	@PostMapping("/typeSession")
	public List<Absence> findBySessionTypeSession(@RequestBody TypeSession typeSession) {
		return absenceService.findBySessionTypeSession(typeSession);
	}

	@PostMapping("/sessionEtudiant")
	public Absence findBySessionAndEtudiant(@RequestBody SessionEtudiant sessionEtudiant) {
		return absenceService.findBySessionAndEtudiant(sessionEtudiant.getSession(),sessionEtudiant.getEtudiant());
	}
	
	
	

}
