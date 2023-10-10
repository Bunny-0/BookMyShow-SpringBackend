package com.examplebookmyshow.BookMyShowBackendSpring.Service;


import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.UserEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.UserResponseDto;

public interface UserService {

    public UserResponseDto addUser(UserEntryDto userEntryDto);
    public UserResponseDto getUser(UserResponseDto userResponseDto);
}
