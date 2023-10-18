package com.examplebookmyshow.BookMyShowBackendSpring.Service.ServiceImpl;

import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.TicketConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TicketEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TicketResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.UserResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.*;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.MovieRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.ShowRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.TicketRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.UserRespository;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRespository userRespository;

    @Override
    public TicketResponseDto createTicket(TicketEntryDto ticketEntryDto) {

        ShowEntity showEntity= showRepository.findById(ticketEntryDto.getShowId()).get();
        UserEntity userEntity=userRespository.findById(ticketEntryDto.getId()).get();
        Set<String> requestedSeats=ticketEntryDto.getRequestedSeats();
        List<ShowSeatsEntity> seatsEntityList= showEntity.getSeats();
        List<ShowSeatsEntity> bookedSeats= seatsEntityList.stream().filter(seat ->seat.getSeatType().equals(ticketEntryDto.getSeatType()) && !seat.isBooked() && requestedSeats.contains(seat.getSeatNumber())).collect(Collectors.toList());

        if(bookedSeats.size()!=requestedSeats.size()){
            throw new Error("All Seats not available");
        }

        TicketEntity ticket=TicketEntity.builder().show(showEntity).user(userEntity).seats(bookedSeats).build();
        double amount=0;
        for(ShowSeatsEntity reqSeats:bookedSeats){
            reqSeats.setBooked(true);
            reqSeats.setBookedAt(new Date());
            reqSeats.setTicket(ticket);
            amount+=reqSeats.getRate();

        }
        ticket.setAmount(amount);
        ticket.setBookedAt(new Date());
        ticket.setAllottedSeats(convertListOfSeatsEntityToString(bookedSeats));
        showEntity.getTickets().add(ticket);
        userEntity.getTicketEntities().add(ticket);
        ticketRepository.save(ticket);

        TicketResponseDto ticketResponseDto= TicketConvertor.convertEntityToDto(ticket);
        return ticketResponseDto;





    }
    public String convertListOfSeatsEntityToString(List<ShowSeatsEntity> bookedSeats){

        String str = "";
        for(ShowSeatsEntity showSeatsEntity : bookedSeats){

            str = str + showSeatsEntity.getSeatNumber()+" ";
        }

        return str;

    }

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticketEntity = ticketRepository.findById(id).get();

        TicketResponseDto ticketResponseDto = TicketConvertor.convertEntityToDto(ticketEntity);

        return ticketResponseDto;
    }
}
