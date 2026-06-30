package com.shrine.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.shrine.entity.ReservationEntity;
import com.shrine.form.ReservationForm;
import com.shrine.model.Reservation;

@Component
public class ReservationMapper {

    public ReservationEntity toEntity(Reservation reservation) {
        ReservationEntity entity = new ReservationEntity();

        copyReservationFields(reservation, entity);

        LocalDateTime now = LocalDateTime.now();
        entity.setPrayed(false);
        entity.setPrayedAt(null);
        entity.setCreatedAt(now);
        entity.setUpdatedAt(now);

        return entity;
    }

    public void updateEntity(Reservation updatedReservation, ReservationEntity existingReservation) {
        copyReservationFields(updatedReservation, existingReservation);
        existingReservation.setUpdatedAt(LocalDateTime.now());
    }

    private void copyReservationFields(Reservation reservation, ReservationEntity entity) {
        entity.setName(reservation.getName());
        entity.setKana(reservation.getKana());
        entity.setBirthday(reservation.getBirthday());
        entity.setGender(reservation.getGender());
        entity.setPhone(reservation.getPhone());
        entity.setPostalCode(reservation.getPostalCode());
        entity.setAddress(reservation.getAddress());
        entity.setEmail(reservation.getEmail());
        entity.setPreferredDate(reservation.getPreferredDate());
        entity.setPreferredTime(reservation.getPreferredTime());
        entity.setPrayerType(reservation.getPrayerType());
        entity.setNote(reservation.getNote());
        entity.setAddressKana(reservation.getAddressKana());
    }
    
    public Reservation toModel(ReservationForm reservationForm, LocalDate preferredDate) {
        Reservation reservation = new Reservation();

        reservation.setName(reservationForm.getName());
        reservation.setKana(reservationForm.getKana());
        reservation.setBirthday(reservationForm.getBirthday());
        reservation.setGender(reservationForm.getGender());
        reservation.setPhone(reservationForm.getPhone());

        if (reservationForm.getPostalCode() != null) {
            reservation.setPostalCode(reservationForm.getPostalCode().replace("-", ""));
        }

        reservation.setAddress(reservationForm.getAddress());
        reservation.setEmail(reservationForm.getEmail());
        reservation.setPreferredDate(preferredDate);
        reservation.setPreferredTime(reservationForm.getPreferredTime());
        reservation.setPrayerType(reservationForm.getPrayerType());
        reservation.setNote(reservationForm.getNote());
        reservation.setAddressKana(reservationForm.getAddressKana());

        return reservation;
    }
}