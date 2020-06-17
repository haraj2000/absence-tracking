package com.suivi.ws;

import java.util.Date;
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

import com.suivi.bean.Enseignant;
import com.suivi.bean.Semestre;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.service.facade.SessionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les séances")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/session")
public class SessionRest {
	@Autowired
	private SessionService sessionService;

	@ApiOperation("Rechercher des séances par date de début")
	@GetMapping("/dateStart/{dateStart}")
	public List<Session> findByDateStart(@PathVariable Date date) {
		return sessionService.findByDateStart(date);
	}
	@ApiOperation("Rechercher des séances par date de fin")
	@GetMapping("dateStop/{dateStop}")
	public List<Session> findByDateStop(@PathVariable Date hourStop) {
		return sessionService.findByDateStop(hourStop);
	}
	@ApiOperation("Rechercher des séances par type de séance")
	@PostMapping("/typeSession")
	public List<Session> findByTypeSession(@RequestBody TypeSession typeSession) {
		return sessionService.findByTypeSession(typeSession);
	}
	@ApiOperation("Rechercher une séance par libelle")
	@GetMapping("/libelle/{libelle}")
	public Session findByLibelle(@PathVariable String libelle) {
		return sessionService.findByLibelle(libelle);
	}
	@ApiOperation("Supprimer une séance par reférence")
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return sessionService.deleteByReference(reference);
	}
	@ApiOperation("Enregistrer une séance")
	@PostMapping("/")
	public Session save(@RequestBody Session session) {
		System.out.println(session);
		return sessionService.save(session);
	}
	@ApiOperation("Rechercher tous les séances enregistrées")
	@GetMapping("/")
	public List<Session> findAll() {
		return sessionService.findAll();
	}
	@ApiOperation("Modifier une séance")
	@PostMapping("/update")
	public Session update(@RequestBody Session session) {
		return sessionService.update(session);
	}
	@ApiOperation("Rechercher une séance par reférence")
	@GetMapping("/reference/{reference}")
	public Session findByReference(@PathVariable String reference) {
		return sessionService.findByReference(reference);
	}
	@ApiOperation("Rechercher des séances par date de début et enseignant")
	@PostMapping("/dateAndEnseignant/dateStart/{dateStart}")
	public Session findByDateStartAndTypeSessionEnseignant(@PathVariable Date dateStart,@RequestBody Enseignant enseignant) {
		return sessionService.findByDateStartAndTypeSessionEnseignant(dateStart, enseignant);
	}
	@ApiOperation("Rechercher des séances par date de début et semestre")
	@PostMapping("/dateAndSemestre/dateStart/{dateStart}")
	public Session findByDateStartAndTypeSessionModuleSemestre(@PathVariable Date dateStart,@RequestBody Semestre semestre) {
		return sessionService.findByDateStartAndTypeSessionModuleSemestre(dateStart, semestre);
	}
	@ApiOperation("Rechercher des séances par semestre")
	@PostMapping("/semestre")
	public List<Session> findByTypeSessionModuleSemestre(@RequestBody Semestre semestre) {
		return sessionService.findByTypeSessionModuleSemestre(semestre);
	}
	@ApiOperation("Rechercher des séances par enseignant")
	@PostMapping("/enseignant")
	public List<Session> findByTypeSessionEnseignant(@RequestBody Enseignant enseignant) {
		return sessionService.findByTypeSessionEnseignant(enseignant);
	}
	
}
