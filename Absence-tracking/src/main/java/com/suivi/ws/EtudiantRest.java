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

import com.suivi.bean.Etudiant;
import com.suivi.bean.Sector;
import com.suivi.bean.Semestre;
import com.suivi.bean.Groupe;
import com.suivi.service.facade.EtudiantService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Cette end point permet de gerer les étudiants")
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("absence-tracking/etudiant")
public class EtudiantRest {
	@Autowired
	private EtudiantService etudiantService;

	@ApiOperation("Rechercher des étudiants par role")
	@GetMapping("/role/{role}")
	public List<Etudiant> findByRole(@PathVariable int role) {
		return etudiantService.findByRole(role);
	}

	@ApiOperation("Rechercher des étudiants par prénom")
	@GetMapping("/firstName/{firstName}")
	public List<Etudiant> findByFirstName(@PathVariable String firstName) {
		return etudiantService.findByFirstName(firstName);
	}
	@ApiOperation("Rechercher des étudiants par nom")
	@GetMapping("/lastName/{lastName}")
	public List<Etudiant> findByLastName(@PathVariable String lastName) {
		return etudiantService.findByLastName(lastName);
	}
	@ApiOperation("Rechercher des étudiants par groupe")
	@PostMapping("/groupe")
	public List<Etudiant> findByGroupe(@RequestBody Groupe groupe) {
		return etudiantService.findByGroupe(groupe);
	}
	@ApiOperation("Rechercher un étudiant par cin")
	@GetMapping("/cin/{cin}")
	public Etudiant findByCin(@PathVariable String cin) {
		return etudiantService.findByCin(cin);
	}
	@ApiOperation("Rechercher des étudiants par nombre des absences")
	@GetMapping("/nbrAbsence/{nbrAbsence}")
	public List<Etudiant> findByNbrAbsence(@PathVariable int nbrAbsence) {
		return etudiantService.findByNbrAbsence(nbrAbsence);
	}
	@ApiOperation("Rechercher un étudiant par email")
	@GetMapping("/mail/{mail}")
	public Etudiant findByMail(@PathVariable String mail) {
		return etudiantService.findByMail(mail);
	}
	@ApiOperation("Supprimer un étudiant par code apogée")
	@DeleteMapping("/codeApogee/{codeApogee}")
	public int deleteByCodeApogee(@PathVariable int codeApogee) {
		return etudiantService.deleteByCodeApogee(codeApogee);
	}
	@ApiOperation("Supprimer un étudiant par cin")
	@DeleteMapping("/cin/{cin}")
	public int deleteByCin(@PathVariable String cin) {
		return etudiantService.deleteByCin(cin);
	}
	@ApiOperation("Enregistrer un étudiant")
	@PostMapping("/")
	public Etudiant save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}
	@ApiOperation("Modifier un étudiant")
	@PostMapping("/update")
	public Etudiant update(@RequestBody Etudiant etudiant) {
		return etudiantService.update(etudiant);
	}
	@ApiOperation("Rechercher tous les étudiants enregistrés")
	@GetMapping("/")
	public List<Etudiant> findAll() {
		return etudiantService.findAll();
	}
	@ApiOperation("Rechercher un étudiant par cne")
	@GetMapping("/cne/{cne}")
	public Etudiant findByCne(@PathVariable String cne) {
		return etudiantService.findByCne(cne);
	}
	@ApiOperation("Supprimer un étudiant par cne")
	@DeleteMapping("/cne/{cne}")
	public int deleteByCne(@PathVariable String cne) {
		return etudiantService.deleteByCne(cne);
	}
	@ApiOperation("Rechercher des étudiants par filière")
	@PostMapping("/sector")
	public List<Etudiant> findBySector(@RequestBody Sector sector) {
		return etudiantService.findBySector(sector);
	}
	@ApiOperation("Rechercher un étudiant par code apogée")
	@GetMapping("/codeApogee/{codeApogee}")
	public Etudiant findByCodeApogee(@PathVariable int codeApogee) {
		return etudiantService.findByCodeApogee(codeApogee);
	}
	@ApiOperation("Enregistrer l'image d'un étudiant par cne")
	@PostMapping("/upload/{cne}")
	public int uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable String cne) throws IOException {
		return etudiantService.uplaodImage(file, cne);
	}
	@ApiOperation("Rechercher l'image d'un étudiant par cin")
	@GetMapping("/get/{cin}")
	public Etudiant getImage(@PathVariable String cin) throws IOException {
		return etudiantService.getImage(cin);
	}
	@ApiOperation("Rechercher des étudiants par semestre")
	@PostMapping("/semestre")
	public List<Etudiant> findByGroupeSemestre(@RequestBody Semestre semestre) {
		return etudiantService.findByGroupeSemestre(semestre);
	}
	@ApiOperation("Modifier le mot de passe d'un étudiant")
	@PostMapping("/password")
	public Etudiant password(@RequestBody Etudiant etudiant) {
		return etudiantService.password(etudiant);
	}

}
