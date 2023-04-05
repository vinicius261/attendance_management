package com.cacauworking.attendance_management.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HolidaysListDTO {
    private List<HolidayDTO> holidays;
}
