//フォーム用のReservation.javaをReservationEntity.javaに入れ替える

package com.shrine.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shrine.entity.ReservationEntity;
import com.shrine.filter.ReservationFilter;
import com.shrine.mapper.ReservationMapper;
import com.shrine.model.Reservation;
import com.shrine.repository.ReservationPrayCountRepository;
import com.shrine.repository.ReservationRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final ReservationPrayCountRepository reservationPrayCountRepository;
	private final ReservationMapper reservationMapper;
	private final ReservationFilter reservationFilter;
	
	
	public ReservationService(ReservationRepository reservationRepository,ReservationPrayCountRepository reservationPrayCountRepository,ReservationMapper reservationMapper,ReservationFilter reservationFilter) {
		this.reservationRepository = reservationRepository;
		this.reservationPrayCountRepository = reservationPrayCountRepository;
		this.reservationMapper = reservationMapper;
		this.reservationFilter = reservationFilter;
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
	
//	一覧表示の際の並べ替え
	public List<ReservationEntity> findReservationsByFilter(String filter) {
	    List<ReservationEntity> reservations = reservationRepository.findAll();
	    return reservationFilter.filter(reservations, filter);
	}
	
//	祈願済の処理、entityが処理できるように変更した
    public void markAsPrayed(Long id) {
        ReservationEntity reservation = reservationRepository.findById(id).orElse(null);
        if (reservation == null) {
        		return;
        }
        reservation.markAsPrayed();
        reservationRepository.save(reservation);
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
	

