package com.franco.carsAPI.model.DTOResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDTO {
    Long id ;
    String address ;
    String addressNumber ;
    String latitude ;
    String longitude ;
    String city ;
    String country ;
}
