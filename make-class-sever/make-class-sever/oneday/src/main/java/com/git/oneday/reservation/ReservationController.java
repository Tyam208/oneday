package com.git.oneday.reservation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.git.oneday.reservation.request.ReservationRequest;

@RestController
public class ReservationController {

	private ReservationService service;
	private ReservationRepository repo;

	@Autowired
	public ReservationController(ReservationService service, ReservationRepository repo){
		this.service = service;
		this.repo = repo;
	}

	@PostMapping("/reservations")
	public Reservation requestReservation(@RequestBody ReservationRequest reqReservation) {
		Reservation savedReservation = service.saveReservation(reqReservation);
		service.sendReservation(savedReservation);
		return savedReservation;
	}
	
	// �ֹ� 1�Ǹ� ��ȸ
	// ���� ���̺� ������ �����Ͽ� ��ȯ
	@GetMapping("/reservations/{id}")
	public Reservation getReservation(@PathVariable long id){
		System.out.println(id);
		return repo.findById(id).orElse(null);
	}

	// �ֹ� ��� ��ȸ
	@GetMapping("/reservations")
	public List<Reservation> getReservations(){
//		// ���� ���̺���� ��ȸ��
//		return repo.findAll();
		return repo.findAll().stream()
				.map(reservation -> {
					reservation.setDetails(null);
					return reservation;
				})
				.collect(Collectors.toList());
	}
}
