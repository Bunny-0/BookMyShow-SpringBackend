package com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    int id;
    String name;
    String mobileNo;
}
