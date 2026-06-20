package com.shrine.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shrine.entity.ReservationEntity;
import com.shrine.form.ReservationForm;
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
    public String showForm(Model model) {
    		model.addAttribute("reservationForm", new ReservationForm());
        return "reservation/form";
    }
    
//    一覧表示用
    @GetMapping("/admin/reservations")
    public String listReservations(
    		//一覧表示にフィルタリングを適応するためのRP
    		@RequestParam(defaultValue = "today") String filter,
    		Model model) {
    	
		model.addAttribute("reservations", reservationService.findReservationsByFilter(filter));
		model.addAttribute("filter", filter);
		return "reservation/list";
	}

    @PostMapping("/reservations")
    public String createReservation(
    		@Valid @ModelAttribute("reservationForm") ReservationForm reservationForm,
    		BindingResult bindingResult,
    		Model model) {
    	
    	if(bindingResult.hasErrors()) {
    		return "reservation/form";
    	}
    	
    	Reservation reservation = new Reservation();
    	
    	reservation.setName(reservationForm.getName());
    	reservation.setKana(reservationForm.getKana());
    	reservation.setBirthday(reservationForm.getBirthday());
    	reservation.setPhone(reservationForm.getPhone());
    	//郵便番号のハイフンを削除
    	reservation.setPostalCode(reservationForm.getPostalCode().replace("-", ""));
    	reservation.setAddress(reservationForm.getAddress());
    	reservation.setEmail(reservationForm.getEmail());
    	reservation.setPreferredDate(reservationForm.getPreferredDate());
    	reservation.setPrayerType(reservationForm.getPrayerType());
    	reservation.setNote(reservationForm.getNote());
    	
    	ReservationEntity savedReservation = reservationService.createReservation(reservation);
    	
    	model.addAttribute("reservationId", savedReservation.getId());
    	model.addAttribute("name", savedReservation.getName());
    	model.addAttribute("kana", savedReservation.getKana());
    	model.addAttribute("birthday", savedReservation.getBirthday());
    	model.addAttribute("phone", savedReservation.getPhone());
    	model.addAttribute("postalCode", savedReservation.getPostalCode());
    	model.addAttribute("address", savedReservation.getAddress());
    	model.addAttribute("email", savedReservation.getEmail());
    	model.addAttribute("preferredDate", savedReservation.getPreferredDate());
    	model.addAttribute("prayerType", savedReservation.getPrayerType());
    	model.addAttribute("note", savedReservation.getNote());
    	
    	return "reservation/complete";
    }
    
    @GetMapping("/admin/reservations/{id}")
    public String viewReservation(@PathVariable Long id, Model model) {
    			ReservationEntity reservation = reservationService.findReservationById(id);
		if (reservation == null) {
			return "error/404"; // 予約が見つからない場合のエラーページ
		}
		model.addAttribute("reservation", reservation);
		return "reservation/detail"; // 予約詳細ページのテンプレート名
    }
    
    
    @PostMapping("/admin/reservations/{id}/delete")
    public String deleteReservation(@PathVariable Long id) {
		reservationService.deleteReservation(id);
		return "redirect:/reservations"; // 削除後に予約一覧ページへリダイレクト
	}
    
    @GetMapping("/admin/admin/reservations/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
    			ReservationEntity reservation = reservationService.findReservationById(id);
    		if (reservation == null) {
    			return "error/404"; // 予約が見つからない場合のエラーページ
    		}
    		model.addAttribute("reservation", reservation);
    		return "reservation/edit"; // 予約編集ページのテンプレート名
    }
    
    @PostMapping("/admin/reservations/{id}/update")
    public String updateReservation(
			@PathVariable Long id,
			@RequestParam String name,
			@RequestParam String kana,
			@RequestParam String birthday,
			@RequestParam String phone,
			@RequestParam String postalCode,
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
		updatedReservation.setPostalCode(postalCode.replace("-", "")); // 郵便番号のハイフンを削除
		updatedReservation.setAddress(address);
		updatedReservation.setEmail(email);
		updatedReservation.setPreferredDate(preferredDate);
		updatedReservation.setPrayerType(prayerType);
		updatedReservation.setNote(note);
		
		reservationService.updateReservation(id, updatedReservation);
		
		return "redirect:/admin/reservations/" + id; // 更新後に予約詳細ページへリダイレクト
	}
    
    //祈願済にする
    @PostMapping("/admin/reservations/{id}/pray")
	public String markAsPrayed(@PathVariable Long id) {
    		reservationService.markAsPrayed(id);
    				return "redirect:/admin/reservations";
    }
		
}
    
