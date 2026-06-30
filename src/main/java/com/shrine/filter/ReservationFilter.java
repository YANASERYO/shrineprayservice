package com.shrine.filter;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.shrine.entity.ReservationEntity;

@Component
public class ReservationFilter {
	public List<ReservationEntity> filter(List<ReservationEntity> reservations, String filter) {
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

}
