package com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class TheaterResponseDto {
    int id;
    private String name;
    private String city;
    private String address;
}
