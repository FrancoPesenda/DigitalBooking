package com.franco.carsAPI.model.DTOResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationDateDTOResponse {
    LocalDate startDay ;
    LocalDate finishDay ;
}
