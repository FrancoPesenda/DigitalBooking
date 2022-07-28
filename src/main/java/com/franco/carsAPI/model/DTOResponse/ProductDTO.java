package com.franco.carsAPI.model.DTOResponse;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTO {

    Long id;
    String name;
    String descriptionTitle;
    String description;
    CategoryDTO categoryDTO;
    LocationDTO locationDTO;
    Double score;
    Set<ImageDTO> imageDTOSet;
    Set<FeatureDTO> featureDTOSet;
    Set<PolicyProductDTO> policyProductDTOSet;
    List<LocalDate> reservationDTOList ;

}
