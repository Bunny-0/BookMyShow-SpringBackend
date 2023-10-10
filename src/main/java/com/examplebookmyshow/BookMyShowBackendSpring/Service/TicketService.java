package com.examplebookmyshow.BookMyShowBackendSpring.Service;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TicketEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TicketResponseDto;

public interface TicketService  {
    public TicketResponseDto createTicket(TicketEntryDto ticketEntryDto);
    public TicketResponseDto getTicket(int id);

}
