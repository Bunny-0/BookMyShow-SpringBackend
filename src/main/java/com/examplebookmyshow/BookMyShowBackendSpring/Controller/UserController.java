package com.examplebookmyshow.BookMyShowBackendSpring.Controller;


import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.UserEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.UserResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.ServiceImpl.UserServiceImpl;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    public UserResponseDto addUser(@RequestBody UserEntryDto userEntryDto){
        return userService.addUser(userEntryDto);
    }

    @GetMapping("{id}")
    public UserResponseDto getUser(@PathVariable int id){
        return userService.getUser(id);
    }


}
