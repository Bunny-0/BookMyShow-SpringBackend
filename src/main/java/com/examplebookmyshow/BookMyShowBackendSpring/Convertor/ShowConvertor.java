package com.examplebookmyshow.BookMyShowBackendSpring.Convertor;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.ShowEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.ShowResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.ShowEntity;

public class ShowConvertor {

    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){
        return ShowEntity.builder().showDate(showEntryDto.getShowDate()).showTime(showEntryDto.getShowTime()).build();

    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity, ShowEntryDto showEntryDto){
        return ShowResponseDto.builder().id(showEntity.getId()).showDate(showEntity.getShowDate()).showTime(showEntity.getShowTime()).movieResponseDto(showEntryDto.getMovieResponseDto()).theaterResponseDto(showEntryDto.getTheaterResponseDto()).build();
    }
}
