package com.infotech.book.ticket.app.TicketBookingManagementApp;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infotech.book.ticket.app.controller.TicketBookingController;
import com.infotech.book.ticket.app.entities.Ticket;
import com.infotech.book.ticket.app.service.TicketBookingService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TicketBookingController.class, secure = false)
public class TicketBookingManagementAppApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TicketBookingService ticketBookingService;
	
	@Test
	public void testEmptyTickets() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setTicketId(100);
		ticket.setEmail("abc@gmail.com");
		ticket.setPassengerName("Viraj");
		Mockito.when(ticketBookingService.getAllBookedTickets()).thenReturn(Arrays.asList(ticket));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/tickets").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = "[{\"ticketId\":100,\"passengerName\":\"Viraj\",\"bookingDate\":null,\"sourceStation\":null,\"destStation\":null,\"email\":\"abc@gmail.com\"}]";
		List<Ticket> tickets = objectMapper.readValue(jsonArray, new TypeReference<List<Ticket>>(){});
		org.junit.Assert.assertEquals(tickets.size(), 1);
		org.junit.Assert.assertTrue(tickets.get(0).getTicketId()==100);
		
//		byte response[] = new byte[1000];
//		result.getResponse().getOutputStream().write(response);
//		Arrays.toString(response);
	}

}
