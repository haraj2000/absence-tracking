package com.suivi.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.bean.JwtRequest;
import com.suivi.bean.JwtResponse;
import com.suivi.config.JwtTokenUtil;
import com.suivi.service.facade.EnseignantService;
import com.suivi.service.facade.EtudiantService;
import com.suivi.service.impl.JwtUserDetailsService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private EnseignantService enseignantService;
	
	@Autowired
	private EtudiantService etudiantService;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/registerEtu", method = RequestMethod.POST)
	public Etudiant saveEtu(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);
	}
	@RequestMapping(value = "/registerEns", method = RequestMethod.POST)
	public Enseignant saveEns(@RequestBody Enseignant enseignant) {
		return enseignantService.save(enseignant);
	}
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationTokenEtudiant(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
