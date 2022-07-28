package com.franco.carsAPI.model.DTORequest;

import com.franco.carsAPI.model.Image;
import com.franco.carsAPI.model.PolicyProduct;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDTORequest {

    String name ;
    String descriptionTitle ;
    String description ;
    Long category ;
    String address ;
    String addressNumber ;
    String latitude ;
    String longitude ;
    Long city ;
    ArrayList<Long> featuresArray ;
    ArrayList<PolicyProduct> policyProductArray ;
    ArrayList<Image> imageArray ;

}
