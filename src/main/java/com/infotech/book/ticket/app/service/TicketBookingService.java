package com.infotech.book.ticket.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.book.ticket.app.dao.TicketBookingDAO;
import com.infotech.book.ticket.app.entities.Ticket;

@Service
public class TicketBookingService {

	@Autowired
	private TicketBookingDAO ticketBookingDAO;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDAO.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDAO.findOne(ticketId);
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDAO.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDAO.delete(ticketId);
	}
}
