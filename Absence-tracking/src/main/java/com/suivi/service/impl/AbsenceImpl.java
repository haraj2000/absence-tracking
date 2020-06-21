package com.suivi.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suivi.bean.Absence;
import com.suivi.bean.Enseignant;
import com.suivi.bean.Etudiant;
import com.suivi.bean.Module;
import com.suivi.bean.Session;
import com.suivi.bean.TypeSession;
import com.suivi.dao.AbsenceDao;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.facade.EtudiantService;
import com.suivi.service.facade.SessionService;

@Service
public class AbsenceImpl implements AbsenceService{

	@Autowired
	private AbsenceDao absenceDao;
	@Autowired
	private EtudiantService etudiantService;
	@Autowired
	private SessionService sessionService;


	@Override
	public List<Absence> findBySession(Session session) {
		return absenceDao.findBySession(session);
	}

	@Override
	public Absence save(Absence absence) {
		String ref = absence.getEtudiant().getFirstName() +" "+ absence.getEtudiant().getLastName() + " pendant le "+absence.getSession().getLibelle();
		absence.setRef(ref);
		Absence absenceFounded = findByRef(absence.getRef());
		String reference =  absence.getSession().getTypeSession().getLibelle()+" "+ absence.getSession().getTypeSession().getSubject().getLibelle() + absence.getSession().getDateStart().toString();
		Session seance = sessionService.findByReference(reference);
		if(absenceFounded == null) {
			absence.setSession(seance);
			System.out.println(absence);
			absenceDao.save(absence);
			return absence;
		}
		else return null;
	}

	@Override
	public int update(Absence absence) {
		String ref = absence.getEtudiant().getFirstName() +" "+ absence.getEtudiant().getLastName() + " pendant le "+absence.getSession().getLibelle();
		absence.setRef(ref);
		Absence absenceFounded = findByRef(absence.getRef());
		Etudiant etudiant = etudiantService.findByCin(absence.getEtudiant().getCin());
		if(absenceFounded!= null) {
			if (absence.isAbsent() != absenceFounded.isAbsent()) {
				absenceFounded.setAbsent(absence.isAbsent());	
				if (absenceFounded.isAbsent() == true && absenceFounded.getJustification() == null) {
					System.out.println("hani hna");
					etudiant.setNbrAbsence(etudiant.getNbrAbsence() + 1);
					}
				else if (absenceFounded.isAbsent() == false && absenceFounded.getJustification() == null ) { etudiant.setNbrAbsence(etudiant.getNbrAbsence() - 1); System.out.println("hana lhih"); }
			}else if (absence.getJustification() != null && absenceFounded.getJustification() == null && absenceFounded.isAbsent()== true) { etudiant.setNbrAbsence(etudiant.getNbrAbsence() - 1); System.out.println("hna hsn mn lhih");}
			absenceFounded.setJustification(absence.getJustification());
			absenceFounded.setJustificatif(absence.getJustificatif());
			absenceDao.save(absenceFounded);
			etudiantService.save(etudiant);
			return 1;
		}
		else return -1;
	}

	@Override
	public List<Absence> findAll() {
		return absenceDao.findAll();
	}

	@Override
	public Absence findByRef(String ref) {
		return absenceDao.findByRef(ref);
	}

	@Override
	@Transactional
	public int deleteByRef(String ref) {
		return absenceDao.deleteByRef(ref);
	}

	@Override
	public List<Absence> findByEtudiant(Etudiant etudiant) {
		return absenceDao.findByEtudiant(etudiant);
	}

	@Override
	public List<Absence> findBySessionTypeSessionModule(Module module) {
		return absenceDao.findBySessionTypeSessionModule(module);
	}

	@Override
	public List<Absence> findBySessionTypeSession(TypeSession typeSession) {
		return absenceDao.findBySessionTypeSession(typeSession);
	}

	@Override
	public Absence findBySessionAndEtudiant(Session session, Etudiant etudiant) {
		System.out.println(absenceDao.findBySessionAndEtudiant(session, etudiant));
		return absenceDao.findBySessionAndEtudiant(session, etudiant);
	}
	// compress the image bytes before storing it in the database
			public static byte[] compressBytes(byte[] data) {
				Deflater deflater = new Deflater();
				deflater.setInput(data);
				deflater.finish();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				while (!deflater.finished()) {
					int count = deflater.deflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				try {
					outputStream.close();
				} catch (IOException e) {
				}
				System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
				return outputStream.toByteArray();
			}
			// uncompress the image bytes before returning it to the angular application
			public static byte[] decompressBytes(byte[] data) {
				Inflater inflater = new Inflater();
				inflater.setInput(data);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
				byte[] buffer = new byte[1024];
				try {
					while (!inflater.finished()) {
						int count = inflater.inflate(buffer);
						outputStream.write(buffer, 0, count);
					}
					outputStream.close();
				} catch (IOException ioe) {
				} catch (DataFormatException e) {
				}
				return outputStream.toByteArray();
			}
	@Override
	public int uplaodImage(MultipartFile file, String reference) throws IOException {
		Absence absence= absenceDao.findByRef(reference);
				absence.setJustificatif(compressBytes(file.getBytes()));
		absenceDao.save(absence);
		return 1;
	}

	@Override
	public Absence getImage(String reference) throws IOException {
		final Absence absence = absenceDao.findByRef(reference);
		absence.setJustificatif(decompressBytes(absence.getJustificatif()));
		return absence;
	}





}
