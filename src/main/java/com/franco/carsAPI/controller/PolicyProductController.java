package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.PolicyProduct;
import com.franco.carsAPI.model.DTOResponse.PolicyProductDTO;
import com.franco.carsAPI.model.DTORequest.IncomePolicyProductDTO;
import com.franco.carsAPI.service.PolicyService;
import com.franco.carsAPI.service.PolicyProductService;
import com.franco.carsAPI.service.ProductService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy_product")
@CrossOrigin( origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyProductController implements ControllerInterface<PolicyProductDTO, IncomePolicyProductDTO,Long> {

    @Autowired
    PolicyProductService service;
    @Autowired
    ProductService productService;
    @Autowired
    PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<PolicyProductDTO>> findAll(){
        return ResponseEntity.ok(service.toDTOList(service.findAll())) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<PolicyProductDTO> findById(@PathVariable Long id ){
        return ResponseEntity.ok(service.toDTO(service.findById(id))) ;
    }
    @PostMapping
    public ResponseEntity<PolicyProductDTO> save(@RequestBody IncomePolicyProductDTO entity){
        PolicyProduct policyProduct = new PolicyProduct() ;
        policyProduct.setDescription(entity.getDescription());
        policyProduct.setProduct(productService.findById(entity.getProduct()));
        policyProduct.setPolicy(policyService.findById(entity.getPolicy()));
        return ResponseEntity.ok(service.toDTO(service.save(policyProduct))) ;
    }

    @Override
    public ResponseEntity<PolicyProductDTO> modify(
            @PathVariable Long id,
            @RequestBody IncomePolicyProductDTO entity) {
        PolicyProduct policyProduct = new PolicyProduct() ;
        policyProduct.setId(id);
        policyProduct.setProduct(productService.findById(entity.getProduct()));
        policyProduct.setPolicy(policyService.findById(entity.getPolicy()));
        return ResponseEntity.ok(service.toDTO(service.save(policyProduct))) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id ){
        return ResponseEntity.ok(service.delete(id)) ;
    }
}
