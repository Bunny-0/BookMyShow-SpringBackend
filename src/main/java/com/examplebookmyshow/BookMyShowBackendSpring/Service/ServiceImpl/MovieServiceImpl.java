package com.examplebookmyshow.BookMyShowBackendSpring.Service.ServiceImpl;

import com.examplebookmyshow.BookMyShowBackendSpring.Controller.MovieController;
import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.MovieConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.MovieEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.MovieResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.MovieEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.MovieRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {
        MovieEntity movie= MovieConvertor.convertDtoToEntity(movieEntryDto);
        MovieEntity movieEntity= movieRepository.save(movie);
        MovieResponseDto responseDto=MovieConvertor.convertEntityToDto(movieEntity);
        return responseDto;

    }

    @Override
    public MovieResponseDto getMovie(int id) {

        MovieEntity movie=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConvertor.convertEntityToDto(movie);
        return movieResponseDto;
    }
}
