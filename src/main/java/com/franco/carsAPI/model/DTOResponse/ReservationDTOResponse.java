package com.franco.carsAPI.model.DTOResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDTOResponse {

    Long id ;
    LocalTime startTime ;
    LocalDate startDay ;
    LocalDate finishDay ;
    ProductDTO product;

}
