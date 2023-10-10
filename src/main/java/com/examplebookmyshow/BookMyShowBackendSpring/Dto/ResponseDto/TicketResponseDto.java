package com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TicketResponseDto {
    int id;
    String alloted_seats;
    double amount;

}
