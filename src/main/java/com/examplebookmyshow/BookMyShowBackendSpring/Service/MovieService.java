package com.examplebookmyshow.BookMyShowBackendSpring.Service;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.MovieEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.MovieResponseDto;

public interface MovieService {

    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto);
    public MovieResponseDto getMovie(int id);
}
