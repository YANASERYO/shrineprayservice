//フォーム用のReservation.javaをReservationEntity.javaに入れ替える

package com.shrine.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
		entity.setPostalCode(reservation.getPostalCode());
		entity.setAddress(reservation.getAddress());
		entity.setEmail(reservation.getEmail());
		entity.setPreferredDate(reservation.getPreferredDate());
		entity.setPrayerType(reservation.getPrayerType());
		entity.setNote(reservation.getNote());
		entity.setPrayed(false);
		entity.setPrayedAt(null);
		entity.setAddressKana(reservation.getAddressKana());
		
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
	
	//更新したい予約IDと、新しい予約情報を受け取る
	public ReservationEntity updateReservation(Long id, Reservation updatedReservation) {
		ReservationEntity existingReservation = reservationRepository.findById(id).orElse(null);
		if (existingReservation != null) {
			existingReservation.setName(updatedReservation.getName());
			existingReservation.setKana(updatedReservation.getKana());
			existingReservation.setBirthday(updatedReservation.getBirthday());
			existingReservation.setPhone(updatedReservation.getPhone());
			existingReservation.setPostalCode(updatedReservation.getPostalCode());
			existingReservation.setAddress(updatedReservation.getAddress());
			existingReservation.setEmail(updatedReservation.getEmail());
			existingReservation.setPreferredDate(updatedReservation.getPreferredDate());
			existingReservation.setPrayerType(updatedReservation.getPrayerType());
			existingReservation.setNote(updatedReservation.getNote());
			existingReservation.setAddressKana(updatedReservation.getAddressKana());
			
			return reservationRepository.save(existingReservation);
		}
		return null;
	}
	
	//一覧表示の祈願実施状況を判別するための機能
	//findAll()してから抽出する
	public List<ReservationEntity> findReservationsByFilter(String filter) {
    List<ReservationEntity> reservations = reservationRepository.findAll();
    String today = LocalDate.now().toString();

    if ("future".equals(filter)) {
        return reservations.stream()
                .filter(r -> !r.isPrayed())
                .filter(r -> r.getPreferredDate().compareTo(today) > 0)
                .collect(Collectors.toList());
    }

    if ("prayed".equals(filter)) {
        return reservations.stream()
                .filter(r -> r.isPrayed())
                .collect(Collectors.toList());
    }

    if ("all".equals(filter)) {
        return reservations;
    }

    //今日の未祈願
    return reservations.stream()
            .filter(r -> !r.isPrayed())
            .filter(r -> today.equals(r.getPreferredDate()))
            .collect(Collectors.toList());
	}
    public void markAsPrayed(Long id) {
        ReservationEntity reservation = reservationRepository.findById(id).orElse(null);

        if (reservation != null) {
            reservation.setPrayed(true);

            String prayedAt = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            reservation.setPrayedAt(prayedAt);

            reservationRepository.save(reservation);
        }
    }
    
}
	

