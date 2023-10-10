package com.examplebookmyshow.BookMyShowBackendSpring.Convertor;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.MovieEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.MovieResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.MovieEntity;

public class MovieConvertor {

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){

        return MovieEntity.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movie){
        return MovieResponseDto.builder().name(movie.getName()).id(movie.getId()).releaseDate(movie.getReleaseDate()).build();
    }
}
