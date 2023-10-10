package com.examplebookmyshow.BookMyShowBackendSpring.Convertor;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TicketEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TicketResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.TicketEntity;

public class TicketConvertor {


    public static TicketResponseDto convertEntityToDto(TicketEntity ticket){
        return TicketResponseDto.builder().amount(ticket.getAmount()).alloted_seats(ticket.getAllottedSeats()).id(ticket.getId()).build();

    }
}
