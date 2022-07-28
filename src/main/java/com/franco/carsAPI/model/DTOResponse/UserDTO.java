package com.franco.carsAPI.model.DTOResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long id ;
    String name ;
    String lastname ;
    String email ;
    String role ;
    List<ProductDTO> favoriteList ;
}
