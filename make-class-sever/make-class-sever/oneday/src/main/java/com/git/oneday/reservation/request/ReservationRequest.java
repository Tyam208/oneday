package com.git.oneday.reservation.request;

import java.util.List;

import com.git.oneday.reservation.ReservationDetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequest {
	private long id;
    private long oneDayClassId;
    private String name;
    private String tel;
    private String reservationDate;
    private long totalAmount;
    private long capacity;
    private String className;
    private boolean status;   // ����
    private long createdTime;   // �����ð�
//	private List<ReservationDetail> details;
	
//	@Data
//	@NoArgsConstructor
//	public static class ReservationDetail {
//			
//		private int oneDayClassId;
//		private String onedayClassName;
//		private int price;
//		private int capacity;
//	}
	
}
