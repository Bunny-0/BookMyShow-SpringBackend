package com.examplebookmyshow.BookMyShowBackendSpring.Convertor;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TheaterEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TheaterResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.TheaterEntity;

public class TheaterConvertor {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){
        return TheaterEntity.builder().name(theaterEntryDto.getName()).city(theaterEntryDto.getCity()).address(theaterEntryDto.getAddress()).build();
    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){
        return TheaterResponseDto.builder().id(theaterEntity.getId()).address(theaterEntity.getAddress()).city(theaterEntity.getCity()).name(theaterEntity.getName()).build();
    }
}
