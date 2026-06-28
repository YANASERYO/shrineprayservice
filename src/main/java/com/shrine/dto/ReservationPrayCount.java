package com.shrine.dto;

public class ReservationPrayCount {
	private final long unprayedCount;
	private final long prayedCount;
	private final long allCount;
	
	public ReservationPrayCount(long unprayedCount,long prayedCount,long allCount) {
		this.unprayedCount = unprayedCount;
		this.prayedCount = prayedCount;
		this.allCount = allCount;
	}
	
	public long getUnprayedCOunt() {
		return unprayedCount;
	}
	
	public long getPrayedCount() {
		return prayedCount;
	}
	
	public long getAllCount() {
		return allCount;
	}

}
