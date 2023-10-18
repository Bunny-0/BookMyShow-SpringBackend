package com.examplebookmyshow.BookMyShowBackendSpring.Convertor;

import com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto.UserEntryDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto.UserResponseDto;
import com.examplebookmyshow.BookMyShowBackendSpring.Model.UserEntity;
import com.examplebookmyshow.BookMyShowBackendSpring.Repository.UserRespository;

public class UserConvertor {

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return  UserEntity.builder().name(userEntryDto.getName()).mobileno(userEntryDto.getMobileNo()).build();

    }
    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobileNo(userEntity.getMobileno()).build();
    }
}
