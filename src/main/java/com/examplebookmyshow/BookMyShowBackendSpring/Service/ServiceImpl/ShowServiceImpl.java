package com.examplebookmyshow.BookMyShowBackendSpring.Service.ServiceImpl;

import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.MovieConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.ShowConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.ShowEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.ShowResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.*;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.MovieRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.ShowRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.ShowSeatRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.TheaterRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ShowServiceImpl implements ShowService {
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheaterRepository theaterRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity= ShowConvertor.convertDtoToEntity(showEntryDto);
        MovieEntity movie= movieRepository.findById(showEntity.getMovie().getId()).get();
        TheaterEntity theater=theaterRepository.findById(showEntity.getTheater().getId()).get();
        showEntity.setTheater(theater);
        showEntity.setMovie(movie);
        List<ShowSeatsEntity> seats=generateShowSeats(theater.getSeats(),showEntity);
        showEntity.setSeats(seats);
        showRepository.save(showEntity);
        ShowResponseDto showResponseDto= ShowConvertor.convertEntityToDto(showEntity,showEntryDto);
        return showResponseDto;
    }

    public List<ShowSeatsEntity> generateShowSeats(List<TheaterSeatsEntity> seatsEntities, ShowEntity showEntity){
        List<ShowSeatsEntity> showSeatsEntityList=new ArrayList<>();
         for(TheaterSeatsEntity th : seatsEntities){
             ShowSeatsEntity sh=ShowSeatsEntity.builder().seatNumber(th.getSeatNumber()).seatType(th.getSeatType()).rate(th.getRate()).show(showEntity).build();
             showSeatsEntityList.add(sh);
         }
         showSeatRepository.saveAll(showSeatsEntityList);

         return showSeatsEntityList;
    }

    @Override
    public ShowResponseDto getShow(ShowEntryDto showEntryDto, int id) {
        ShowEntity showEntity=showRepository.findById(id).get();
        ShowResponseDto showResponseDto= ShowConvertor.convertEntityToDto(showEntity,showEntryDto);
        return showResponseDto;
    }
}
