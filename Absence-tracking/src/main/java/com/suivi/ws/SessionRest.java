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

import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.service.facade.SessionService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/session")
public class SessionRest {
	@Autowired
	private SessionService sessionService;

	@GetMapping("/dateStart/{dateStart}")
	public List<Session> findByDateStart(@PathVariable Date date) {
		return sessionService.findByDateStart(date);
	}
	@GetMapping("dateStop/{dateStop}")
	public List<Session> findByDateStop(@PathVariable Date hourStop) {
		return sessionService.findByDateStop(hourStop);
	}
	@PostMapping("/typeSession")
	public List<Session> findByTypeSession(@RequestBody TypeSession typeSession) {
		return sessionService.findByTypeSession(typeSession);
	}
	@GetMapping("/libelle/{libelle}")
	public Session findByLibelle(@PathVariable String libelle) {
		return sessionService.findByLibelle(libelle);
	}
	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return sessionService.deleteByReference(reference);
	}
	@PostMapping("/")
	public Session save(@RequestBody Session session) {
		System.out.println(session);
		return sessionService.save(session);
	}
	@GetMapping("/")
	public List<Session> findAll() {
		return sessionService.findAll();
	}
	@PostMapping("/update")
	public Session update(@RequestBody Session session) {
		return sessionService.update(session);
	}
	@GetMapping("/reference/{reference}")
	public Session findByReference(@PathVariable String reference) {
		return sessionService.findByReference(reference);
	}
	
}
