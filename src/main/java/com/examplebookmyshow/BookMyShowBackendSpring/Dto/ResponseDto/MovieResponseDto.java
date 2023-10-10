package com.examplebookmyshow.BookMyShowBackendSpring.Dto.ResponseDto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Builder
@Data
public class MovieResponseDto {
    int id;
    String name;
    LocalDate releaseDate;
}
