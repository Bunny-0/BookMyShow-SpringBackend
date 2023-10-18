package com.examplebookmyshow.BookMyShowBackendSpring.Controller;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.TheaterEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.TheaterResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;


    @PostMapping("/addTheater")
    public TheaterResponseDto addTheater(@RequestBody TheaterEntryDto theaterEntryDto){
        return theaterService.addTheater(theaterEntryDto);
    }
    @GetMapping("{id}")
    public TheaterResponseDto getTHeater(@PathVariable  int id){
        return theaterService.getTheater(id);
    }
}
