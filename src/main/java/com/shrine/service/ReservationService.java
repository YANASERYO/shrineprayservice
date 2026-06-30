//フォーム用のReservation.javaをReservationEntity.javaに入れ替える

package com.shrine.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shrine.entity.ReservationEntity;
import com.shrine.mapper.ReservationMapper;
import com.shrine.model.Reservation;
import com.shrine.repository.ReservationPrayCountRepository;
import com.shrine.repository.ReservationRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final ReservationPrayCountRepository reservationPrayCountRepository;
	private final ReservationMapper reservationMapper;
	
	
	public ReservationService(ReservationRepository reservationRepository,ReservationPrayCountRepository reservationPrayCountRepository,ReservationMapper reservationMapper) {
		this.reservationRepository = reservationRepository;
		this.reservationPrayCountRepository = reservationPrayCountRepository;
		this.reservationMapper = reservationMapper;
	}
	
	public ReservationEntity createReservation(Reservation reservation) {
		ReservationEntity entity = reservationMapper.toEntity(reservation);
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
		if (existingReservation == null) {
			return null;
		}
		reservationMapper.updateEntity(updatedReservation,existingReservation);
		return reservationRepository.save(existingReservation);
	}
	
	//一覧表示の祈願実施状況を判別するための機能
	//findAll()してから抽出する
	public List<ReservationEntity> findReservationsByFilter(String filter) {
    List<ReservationEntity> reservations = reservationRepository.findAll();
    LocalDate today = LocalDate.now();
    
    if ("future".equals(filter)) {
    		return reservations.stream()
    	        .filter(r -> !r.isPrayed())
    	        .filter(r -> r.getPreferredDate() != null)
    	        .filter(r -> r.getPreferredDate().isAfter(today))
    	        .sorted(reservationSortOrder())
    	        .collect(Collectors.toList());
    }

    if ("prayed".equals(filter)) {
    		return reservations.stream()
            .filter(r -> r.isPrayed())
            .sorted(reservationSortOrder())
            .collect(Collectors.toList());
    }

    if ("all".equals(filter)) {
    		return reservations.stream()
            .sorted(reservationSortOrder())
            .collect(Collectors.toList());
    }

    //今日の未祈願
    return reservations.stream()
    		.filter(r -> !r.isPrayed())
            .filter(r -> today.equals(r.getPreferredDate()))
            .sorted(reservationSortOrder())
            .collect(Collectors.toList());
	}
	
	// 祈願希望日 → 祈願希望時間 → ID の順で並べる
	private Comparator<ReservationEntity> reservationSortOrder() {
	    return Comparator
	            .comparing(
	                    ReservationEntity::getPreferredDate,
	                    Comparator.nullsLast(Comparator.naturalOrder())
	            )
	            .thenComparing(
	                    ReservationEntity::getPreferredTime,
	                    Comparator.nullsLast(Comparator.naturalOrder())
	            )
	            .thenComparing(
	                    ReservationEntity::getId,
	                    Comparator.nullsLast(Comparator.naturalOrder())
	            );
	}
	
	
	
    public void markAsPrayed(Long id) {
        ReservationEntity reservation = reservationRepository.findById(id).orElse(null);

        if (reservation != null) {
        		LocalDateTime now = LocalDateTime.now();
            reservation.setPrayed(true);
            reservation.setPrayedAt(now);
            reservation.setUpdatedAt(now);

            reservationRepository.save(reservation);
        }
    }
    
    public long countTodayUnprayed() {
        LocalDate today = LocalDate.now();
        return reservationPrayCountRepository.countByPrayedFalseAndPreferredDate(today);
    }

    public long countFutureUnprayed() {
        LocalDate today = LocalDate.now();
        return reservationPrayCountRepository.countByPrayedFalseAndPreferredDateAfter(today);
    }

    public long countPrayed() {
        return reservationPrayCountRepository.countByPrayedTrue();
    }

    public long countAllReservations() {
        return reservationPrayCountRepository.count();
    }
    
    
}
	

