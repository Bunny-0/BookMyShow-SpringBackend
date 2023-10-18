package com.examplebookmyshow.BookMyShowBackendSpring.Controller;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TicketEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TicketResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/createTicket")
    public TicketResponseDto createTicket(@RequestBody TicketEntryDto ticketEntryDto){
        return ticketService.createTicket(ticketEntryDto);

    }
}
