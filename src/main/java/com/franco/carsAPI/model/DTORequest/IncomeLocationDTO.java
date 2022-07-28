package com.franco.carsAPI.model.DTORequest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IncomeLocationDTO {
    String address ;
    String addressNumber ;
    String latitude ;
    String longitude ;
    Long city ;
}
