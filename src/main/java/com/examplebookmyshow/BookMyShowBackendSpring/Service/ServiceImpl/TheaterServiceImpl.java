package com.examplebookmyshow.BookMyShowBackendSpring.Service.ServiceImpl;

import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.MovieConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.TheaterConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TheaterEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TheaterResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Enum.SeatType;
import com.examplebookmyshow.BookMyShowBackendSpring.Enum.TheaterType;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.MovieEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.TheaterEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.TheaterSeatsEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.TheaterRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.TheaterSeatsRepository;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    TheaterRepository theaterRepository;
    @Autowired
    TheaterSeatsRepository  theaterSeatsRepository;
    @Override
    public TheaterResponseDto addTheater(TheaterEntryDto theaterEntryDto) {
        TheaterEntity theaterEntity= TheaterConvertor.convertDtoToEntity(theaterEntryDto);
        List<TheaterSeatsEntity> seats=createSeats();
        theaterEntity.setSeats(seats);
        theaterEntity.setShows(null);
        for(TheaterSeatsEntity seat :seats){
            seat.setTheater(theaterEntity);
        }
        theaterEntity.setType(TheaterType.SINGLE);
        theaterRepository.save(theaterEntity);
        TheaterResponseDto theaterResponseDto=TheaterConvertor.convertEntityToDto(theaterEntity);
        return theaterResponseDto;

    }

    public List<TheaterSeatsEntity> createSeats(){
        List<TheaterSeatsEntity> seats= new ArrayList<>();
        seats.add(getTheaterSeats("1A",100,SeatType.CLASSIC));
        seats.add(getTheaterSeats("1B",100,SeatType.CLASSIC));
        seats.add(getTheaterSeats("1C",100,SeatType.CLASSIC));
        seats.add(getTheaterSeats("1D",100,SeatType.CLASSIC));
        seats.add(getTheaterSeats("1E",100,SeatType.CLASSIC));

        seats.add(getTheaterSeats("2A",200,SeatType.PREMIUM));
        seats.add(getTheaterSeats("2B",200,SeatType.PREMIUM));
        seats.add(getTheaterSeats("2C",200,SeatType.PREMIUM));
        seats.add(getTheaterSeats("2D",200,SeatType.PREMIUM));
        seats.add(getTheaterSeats("2E",200,SeatType.PREMIUM));
        theaterSeatsRepository.saveAll(seats);
        return  seats;
    }

    TheaterSeatsEntity getTheaterSeats(String seatName, int rate, SeatType seatType){
        return TheaterSeatsEntity.builder().seatNumber(seatName).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheaterResponseDto getTheater(int id) {
        TheaterEntity theater=theaterRepository.findById(id).get();
        return TheaterConvertor.convertEntityToDto(theater);

    }
}
