package com.examplebookmyshow.BookMyShowBackendSpring.Service;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.ShowEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.ShowResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.ShowEntity;

public interface ShowService {

    public ShowResponseDto addShow(ShowEntryDto showEntryDto);
    public ShowResponseDto getShow(ShowEntryDto showEntryDto,int id);
}
