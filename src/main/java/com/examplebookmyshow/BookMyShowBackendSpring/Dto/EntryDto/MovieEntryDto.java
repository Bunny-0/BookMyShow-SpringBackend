package com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
@Builder
public class MovieEntryDto {

    String name;
    LocalDate releaseDate;
}
