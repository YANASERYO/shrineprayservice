//フォーム用のReservation.javaをReservationEntity.javaに入れ替える

package com.shrine.service;

import org.springframework.stereotype.Service;

import com.shrine.entity.ReservationEntity;
import com.shrine.model.Reservation;
import com.shrine.repository.ReservationRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	
	public ReservationService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}
	
	public ReservationEntity createReservation(Reservation reservation) {
		ReservationEntity entity = new ReservationEntity();
		
//  Idで管理したい場合もあるため保存からEntityを返す形に変更した
//	public void save(Reservation reservation) {
//	    ReservationEntity entity = new ReservationEntity();	
	
		entity.setName(reservation.getName());
		entity.setKana(reservation.getKana());
		entity.setBirthday(reservation.getBirthday());
		entity.setPhone(reservation.getPhone());
		entity.setAddress(reservation.getAddress());
		entity.setEmail(reservation.getEmail());
		entity.setPreferredDate(reservation.getPreferredDate());
		entity.setPrayerType(reservation.getPrayerType());
		entity.setNote(reservation.getNote());
		
		return reservationRepository.save(entity);
		
	}
}
