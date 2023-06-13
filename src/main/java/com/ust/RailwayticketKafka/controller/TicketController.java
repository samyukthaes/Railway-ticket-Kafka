package com.ust.RailwayticketKafka.controller;

import com.ust.RailwayticketKafka.entity.Ticket;
import com.ust.RailwayticketKafka.service.TicketBookingConsumer;
import com.ust.RailwayticketKafka.service.TicketBookingProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketBookingConsumer ticketBookingConsumer;

    @Autowired
    private TicketBookingProducer ticketBookingProducer;

    @PostMapping("/book-ticket")
    public ResponseEntity<String> bookTicket(@RequestBody Ticket ticket) {
        boolean bookingResult = ticketBookingConsumer.bookTicket(ticket);
        if (bookingResult) {
            return ResponseEntity.ok("Ticket booked successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ticket booking failed.");
        }
    }


}
