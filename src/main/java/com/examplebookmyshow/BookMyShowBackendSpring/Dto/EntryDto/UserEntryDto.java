package com.examplebookmyshow.BookMyShowBackendSpring.Dto.EntryDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntryDto {
    String name;
    String mobileNo;
}
