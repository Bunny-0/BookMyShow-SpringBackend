package com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.ShowResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.UserResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Enum.SeatType;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.ShowEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Builder
public class TicketEntryDto  {
    Set<String> requestedSeats; //User will give
    //user Id who is booking the ticket   :- UserEntity
    int showId; //For which show I want to book ticket :- showEntity
    int id; //userId
    SeatType seatType;
}
