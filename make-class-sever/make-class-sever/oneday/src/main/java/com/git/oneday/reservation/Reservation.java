package com.git.oneday.reservation;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Formula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	
	private String managerOneDayClassId;
	private String name; 
	private String tel;
	private String reservationDate;
	
	private Long totalAmount;
	
//	@Formula("(SELECT COUNT(1) FROM reservation_detail d WHERE d.creservation_id = id)")
//	private int detailCnt;
//
//	@Formula("(SELECT d.oneDayClass_name FROM reservation_detail d WHERE d.reservation_id = id LIMIT 1)")
//	private String firstOneDayClassName;	
	
	// �ֹ� ��ǰ ���� ���
	// Entity Relationship ������̼��� ������ ���� ��ȸ��
	// �⺻������ FetchType.Lazy
	@OneToMany
	@JoinColumn(name="reservationId")
	private List<ReservationDetail> details;
//	
	private String status;	// ����
	private Long createdTime;	// �����ð�
}
