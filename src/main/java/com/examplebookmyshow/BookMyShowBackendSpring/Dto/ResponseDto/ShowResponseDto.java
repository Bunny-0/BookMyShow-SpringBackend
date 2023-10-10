package com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class ShowResponseDto {

    private int id;

    @NotNull
    LocalDate showDate;

    @NotNull
    LocalTime showTime;

    @NotNull
    MovieResponseDto movieResponseDto;

    @NotNull
    TheaterResponseDto theaterResponseDto;
}
