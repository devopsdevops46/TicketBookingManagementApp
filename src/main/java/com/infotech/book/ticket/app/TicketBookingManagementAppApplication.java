package com.infotech.book.ticket.app;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infotech.book.ticket.app.entities.Ticket;
import com.infotech.book.ticket.app.service.TicketBookingService;

@SpringBootApplication
public class TicketBookingManagementAppApplication implements CommandLineRunner{

	@Autowired
	TicketBookingService ticketBookingService;
	
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementAppApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Viraj");
		ticket.setSourceStation("Mumbai");
		ticket.setDestStation("New York");
		ticket.setBookingDate(new Date());
		ticket.setEmail("viraj@gmail.com");
		ticketBookingService.createTicket(ticket);
	}
}
