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
import com.suivi.bean.Notification;
import com.suivi.dao.NotificationDao;
import com.suivi.service.facade.AbsenceService;
import com.suivi.service.facade.NotificationService;

@Service
public class NotificaionImpl implements NotificationService{

	@Autowired
	private NotificationDao notificationDao;
	@Autowired
	private AbsenceService absenceService;

	@Override
	public Notification findByAbsence(Absence absence) {
		return notificationDao.findByAbsence(absence);
	}

	@Override
	public List<Notification> findByEnseignant(Enseignant enseignant) {
		return notificationDao.findByEnseignant(enseignant);
	}

	@Override
	public List<Notification> findByState(String state) {
		System.out.println("coucou chui la");
		System.out.println(notificationDao.findByState(state));
		return notificationDao.findByState(state);
	}

	@Override
	public Notification save(Notification notification) {
		Notification notificationFounded = findByAbsence(notification.getAbsence());
		if (notificationFounded == null) {
			notification.setEnseignant(notification.getAbsence().getSession().getTypeSession().getEnseignant());
			notificationDao.save(notification);
			return notification;
		}
		return null;
	}

	@Override
	public int update(Notification notification) {
		Notification notificationFounded = findByAbsence(notification.getAbsence());
		if (notificationFounded != null) {
			notificationFounded.setContenu(notification.getContenu());
			notificationFounded.setState(notification.getState());
			notificationDao.save(notificationFounded);
			return 1;
		}
		return -1;
	}

	@Override
	@Transactional
	public int deleteByAbsence(String absence) {
		absenceService.findByRef(absence);
		Absence absenceFouned = absenceService.findByRef(absence);
		return notificationDao.deleteByAbsence(absenceFouned);
	}

	@Override
	public List<Notification> findAll() {
		return notificationDao.findAll();
	}

	@Override
	public List<Notification> findByAbsenceEtudiant(Etudiant etudiant) {
		return notificationDao.findByAbsenceEtudiant(etudiant);
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
				} catch (DataFormatException e) {}
				return outputStream.toByteArray();
			}
	@Override
	public int uplaodImage(MultipartFile file, String absence) throws IOException {
		Absence absenceFounded = absenceService.findByRef(absence);
		Notification notification= notificationDao.findByAbsence(absenceFounded);
		notification.setPhoto(compressBytes(file.getBytes()));
		notificationDao.save(notification);
		return 1;
	}

	@Override
	public Notification getImage(Absence absence) throws IOException {
		final Notification notification = notificationDao.findByAbsence(absence);
		notification.setPhoto(decompressBytes(notification.getPhoto()));
		return notification;
	}
}
