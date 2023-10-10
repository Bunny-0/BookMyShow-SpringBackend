package com.examplebookmyshow.BookMyShowBackendSpring.Service.ServiceImpl;

import com.examplebookmyshow.BookMyShowBackendSpring.Convertor.UserConvertor;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.UserEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.UserResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.UserEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.UserRespository;
import com.examplebookmyshow.BookMyShowBackendSpring.Service.UserService;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRespository userRespository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {
        UserEntity userEntity= UserConvertor.convertDtoToEntity(userEntryDto);
        userRespository.save(userEntity);
        UserResponseDto userResponseDto= UserConvertor.convertEntityToDto(userEntity);
        return userResponseDto;

    }

    @Override
    public UserResponseDto getUser(UserResponseDto userResponseDto) {
        UserEntity userEntity= userRespository.findById(userResponseDto.getId()).get();
        UserResponseDto userResponse=UserConvertor.convertEntityToDto(userEntity);
        return userResponse;
    }
}
