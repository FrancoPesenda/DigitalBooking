package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Feature;
import com.franco.carsAPI.model.FeatureProduct;
import com.franco.carsAPI.model.Product;
import com.franco.carsAPI.model.DTOResponse.FeatureProductDTO;
import com.franco.carsAPI.model.DTORequest.IncomeFeatureProductDTO;
import com.franco.carsAPI.service.FeatureService;
import com.franco.carsAPI.service.FeatureProductService;
import com.franco.carsAPI.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature_product")
@CrossOrigin(origins = "*")
public class FeatureProductController implements ControllerInterface<FeatureProductDTO, IncomeFeatureProductDTO,Long> {

    @Autowired
    private FeatureProductService service ;
    @Autowired
    private ProductService productService;
    @Autowired
    private FeatureService featureService;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Productos con sus Características",
            notes = "Devuelve todas las Características en la base de datos")
    @GetMapping
    public ResponseEntity<List<FeatureProductDTO>> findAll(){
        return ResponseEntity.ok(this.service.toDTOList(service.findAll())) ;
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<FeatureProductDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.toDTO(service.findById(id))) ;
    }

    @PostMapping
    public ResponseEntity<FeatureProductDTO> save(@RequestBody IncomeFeatureProductDTO entity ){
        FeatureProduct featureProduct = new FeatureProduct() ;
        Product product = productService.findById(entity.getProduct()) ;
        Feature feature = featureService.findById(entity.getFeature()) ;
        featureProduct.setProduct(product);
        featureProduct.setFeature(feature);
        return ResponseEntity.ok(service.toDTO(service.save(featureProduct))) ;
    }

    @PutMapping
    public ResponseEntity<FeatureProductDTO> modify(
            @PathVariable Long id,
            @RequestBody IncomeFeatureProductDTO entity ){
        FeatureProduct featureProduct = new FeatureProduct() ;
        Product product = productService.findById(entity.getProduct()) ;
        Feature feature = featureService.findById(entity.getFeature()) ;
        featureProduct.setId(id);
        featureProduct.setProduct(product);
        featureProduct.setFeature(feature);
        return ResponseEntity.ok(service.toDTO(service.save(featureProduct))) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id)) ;
    }

}
