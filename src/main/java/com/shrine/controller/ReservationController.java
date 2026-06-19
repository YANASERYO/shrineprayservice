package com.shrine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shrine.entity.ReservationEntity;
import com.shrine.model.Reservation;
import com.shrine.service.ReservationService;


@Controller
public class ReservationController {

//	@GetMapping("/test")
//	@ResponseBody
//	public String test() {
//		return "Controller OK";
//	}
	
	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

    @GetMapping("/reservations/new")
    public String showForm() {
        return "reservation/form";
    }
    
//    一覧表示用
    @GetMapping("/reservations")
    public String listReservations(Model model) {
		model.addAttribute("reservations", reservationService.findAllReservations());
		return "reservation/list";
	}

    @PostMapping("/reservations")
    public String createReservation(
    		@RequestParam String name,
        @RequestParam String kana,
        @RequestParam String birthday,
        @RequestParam String phone,
        @RequestParam String address,
        @RequestParam String email,
        @RequestParam String preferredDate,
        @RequestParam String prayerType,
        @RequestParam(required = false) String note,
        Model model) {
    	
    	Reservation reservation = new Reservation();
    	
    	reservation.setName(name);
    	reservation.setKana(kana);
    	reservation.setBirthday(birthday);
    	reservation.setPhone(phone);
    	reservation.setAddress(address);
    	reservation.setEmail(email);
    	reservation.setPreferredDate(preferredDate);
    	reservation.setPrayerType(prayerType);
    	reservation.setNote(note);
    	
    	ReservationEntity savedReservation = reservationService.createReservation(reservation);
        	
    		model.addAttribute("reservationId", savedReservation.getId());
    	
        	model.addAttribute("name", name);
        model.addAttribute("kana", kana);
        model.addAttribute("birthday", birthday);
        model.addAttribute("phone", phone);
        model.addAttribute("address", address);
        model.addAttribute("email", email);
        model.addAttribute("preferredDate", preferredDate);
        model.addAttribute("prayerType", prayerType);
        model.addAttribute("note", note);
        return "reservation/complete";
    }
    
    @GetMapping("/reservations/{id}")
    public String viewReservation(@PathVariable Long id, Model model) {
    			ReservationEntity reservation = reservationService.findReservationById(id);
		if (reservation == null) {
			return "error/404"; // 予約が見つからない場合のエラーページ
		}
		model.addAttribute("reservation", reservation);
		return "reservation/detail"; // 予約詳細ページのテンプレート名
    }
    
    
    @PostMapping("/reservations/{id}/delete")
    public String deleteReservation(@PathVariable Long id) {
		reservationService.deleteReservation(id);
		return "redirect:/reservations"; // 削除後に予約一覧ページへリダイレクト
	}
    
    @GetMapping("/reservations/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
    			ReservationEntity reservation = reservationService.findReservationById(id);
    					if (reservation == null) {
    						return "error/404"; // 予約が見つからない場合のエラーページ
    					}
    					model.addAttribute("reservation", reservation);
    					return "reservation/edit"; // 予約編集ページのテンプレート名
    }
    
    @PostMapping("/reservations/{id}/update")
    public String updateReservation(
			@PathVariable Long id,
			@RequestParam String name,
			@RequestParam String kana,
			@RequestParam String birthday,
			@RequestParam String phone,
			@RequestParam String address,
			@RequestParam String email,
			@RequestParam String preferredDate,
			@RequestParam String prayerType,
			@RequestParam(required = false) String note,
			Model model) {
		
		Reservation updatedReservation = new Reservation();
		
		updatedReservation.setName(name);
		updatedReservation.setKana(kana);
		updatedReservation.setBirthday(birthday);
		updatedReservation.setPhone(phone);
		updatedReservation.setAddress(address);
		updatedReservation.setEmail(email);
		updatedReservation.setPreferredDate(preferredDate);
		updatedReservation.setPrayerType(prayerType);
		updatedReservation.setNote(note);
		
		reservationService.updateReservation(id, updatedReservation);
		
		return "redirect:/reservations/" + id; // 更新後に予約詳細ページへリダイレクト
	}				
}
    
