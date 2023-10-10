package com.examplebookmyshow.BookMyShowBackendSpring.Service;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TheaterEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TheaterResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.TheaterEntity;

public interface TheaterService {

    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto);
    public TheaterResponseDto getTheater(int id);

}
