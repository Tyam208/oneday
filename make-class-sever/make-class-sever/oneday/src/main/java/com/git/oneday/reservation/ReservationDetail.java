package com.git.oneday.reservation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
//@IdClass(ReservationDetailId.class)
public class ReservationDetail {

	@Id
	private long reservationId; // �ֹ� �⺻������ id

	
	//	 �ֹ���ÿ� ������ ���
	private long oneDayClassId;
    private int price;
	private int capacity;
}