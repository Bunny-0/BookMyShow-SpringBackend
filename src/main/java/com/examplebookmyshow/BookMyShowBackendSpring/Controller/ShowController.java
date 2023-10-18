package com.examplebookmyshow.BookMyShowBackendSpring.Controller;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.ShowEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.ShowResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.ShowEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    ShowService showService;
    @PostMapping("/addShow")
    public ShowResponseDto addShow(@RequestBody ShowEntryDto showEntryDto){
        System.out.println("movie data is"+showEntryDto.getShowDate());
        return showService.addShow(showEntryDto);
    }

}
