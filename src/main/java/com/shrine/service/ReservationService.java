//フォーム用のReservation.javaをReservationEntity.javaに入れ替える

package com.shrine.service;

import java.util.List;

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
		//	ReservationEntity entity = new ReservationEntity();	
	
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
	// 予約情報を全件取得
	public List<ReservationEntity> findAllReservations() {
		return reservationRepository.findAll();
	}
	
	//	IDで予約情報を取得（1件返す）
	public ReservationEntity findReservationById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}
	
	//	削除する
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);
	}
	
//	更新したい予約IDと、新しい予約情報を受け取る
	public ReservationEntity updateReservation(Long id, Reservation updatedReservation) {
		ReservationEntity existingReservation = reservationRepository.findById(id).orElse(null);
		if (existingReservation != null) {
			existingReservation.setName(updatedReservation.getName());
			existingReservation.setKana(updatedReservation.getKana());
			existingReservation.setBirthday(updatedReservation.getBirthday());
			existingReservation.setPhone(updatedReservation.getPhone());
			existingReservation.setAddress(updatedReservation.getAddress());
			existingReservation.setEmail(updatedReservation.getEmail());
			existingReservation.setPreferredDate(updatedReservation.getPreferredDate());
			existingReservation.setPrayerType(updatedReservation.getPrayerType());
			existingReservation.setNote(updatedReservation.getNote());
			
			return reservationRepository.save(existingReservation);
		}
		return null;
	}
	
}
