//DBに保存するために必要なクラス（主キー：Long）

package com.shrine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shrine.entity.ReservationEntity;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}
