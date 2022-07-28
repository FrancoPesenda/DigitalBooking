package com.franco.carsAPI.model.DTOResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDTO {

    Long id ;
    String title ;
    String url ;

}
