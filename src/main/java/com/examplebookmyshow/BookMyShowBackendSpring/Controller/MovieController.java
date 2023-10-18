package com.examplebookmyshow.BookMyShowBackendSpring.Controller;


import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.MovieEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.MovieResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;


            @PostMapping("/addMovie")
            public MovieResponseDto addMovie(@RequestBody MovieEntryDto movieEntryDto){
             return movieService.addMovie(movieEntryDto);
            }

            @GetMapping("{id}")
            public MovieResponseDto getMovie(@PathVariable int id){
                return movieService.getMovie(id);
            }

}
