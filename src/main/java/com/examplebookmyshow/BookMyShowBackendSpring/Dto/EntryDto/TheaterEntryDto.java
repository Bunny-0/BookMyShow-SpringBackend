package com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@Builder

public class TheaterEntryDto {

    private String name;

    private String city;

    private String address;
}
