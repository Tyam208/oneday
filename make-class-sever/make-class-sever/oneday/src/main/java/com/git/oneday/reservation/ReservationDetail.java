package com.git.oneday.reservation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import com.git.oneday.onedayclass.OneDayClass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@IdClass(ReservationDetailId.class)
public class ReservationDetail {

	@Id
	private long reservationId;		// �ֹ� �⺻������ id
	@Id
	private int classNumber;	// �ֹ� ��ǰ ������ ��ȣ

	@ManyToOne
	private OneDayClass oneDayClass;
	
	//	 �ֹ���ÿ� ������ ���
	private String oneDayClassName;
	private int price;
	private int capacity;
}
