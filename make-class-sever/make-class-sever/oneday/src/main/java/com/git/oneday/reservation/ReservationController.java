package com.git.oneday.reservation;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.git.oneday.reservation.request.ReservationRequest;

@RestController
public class ReservationController {

	private ReservationService reservationService;
	private ReservationRepository repo;
	

	@Autowired
	public ReservationController(ReservationService reservationService, ReservationRepository repo){
		this.reservationService = reservationService;
		this.repo = repo;
	}

	@PostMapping("/reservations")
	public Reservation requestReservation(@RequestBody ReservationRequest reqReservation, HttpServletResponse res) {
		Reservation reservationItem = Reservation
				.builder()
				.title(reqReservation.getTitle())
				.tel(reqReservation.getTel())
				.name(reqReservation.getName())
				.capacity(reqReservation.getCapacity())
				.reservationTime(reqReservation.getReservationTime())
				.createdTime(reqReservation.getCreatedTime())
				.oneDayClassId(reqReservation.getOneDayClassId())
				.status(reqReservation.isStatus())
				.person(reqReservation.getPerson())
				.price(reqReservation.getPrice())
				.build();
		
		Reservation reservationSaved = repo.save(reservationItem);
		
		reservationService.sendReservation(reservationSaved);
		res.setStatus(HttpServletResponse.SC_CREATED);
		
		return reservationSaved;
		
	}

	// �ֹ� ��� ��ȸ
	@GetMapping("/reservations")
	public List<Reservation> getReservations(){
//		// ���� ���̺���� ��ȸ��
		return repo.findAll();

	}
	// �ֹ� 1�Ǹ� ��ȸ
		// ���� ���̺� ������ �����Ͽ� ��ȯ
		@GetMapping("/reservations/{id}")
		public Reservation getReservation(@PathVariable long id){
			System.out.println(id);
			return repo.findById(id).orElse(null);
		}
}
