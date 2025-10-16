package org.example.repository;

import org.example.models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Long, Ticket> tickets = new TreeMap<>();
    private Long ticketIdCounter = 1L;

    public Optional<Ticket> getTicketById(Long id) {
        return Optional.ofNullable(tickets.get(id));
    }
    public void addTicket(Ticket ticket) {
        ticket.setTicketNumber(ticketIdCounter++);
        tickets.put(ticket.getTicketNumber(), ticket);
    }
}
