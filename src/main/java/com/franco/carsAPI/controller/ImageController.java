package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Image;
import com.franco.carsAPI.model.Product;
import com.franco.carsAPI.model.DTOResponse.ImageDTO;
import com.franco.carsAPI.model.DTORequest.IncomeImageDTO;
import com.franco.carsAPI.service.ImageService;
import com.franco.carsAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImageController implements ControllerInterface<ImageDTO, IncomeImageDTO,Long> {

    @Autowired
    private ImageService service ;
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ImageDTO>> findAll(){
        return ResponseEntity.ok(service.toDTOList(service.findAll())) ;
    }

    @Override
    public ResponseEntity<ImageDTO> findById(Long id) {
        return ResponseEntity.ok(service.toDTO(service.findById(id))) ;
    }

    @PostMapping
    public ResponseEntity<ImageDTO> save( @RequestBody IncomeImageDTO entity ){
        Image image = new Image() ;
        Product product = productService.findById(entity.getProduct()) ;
        image.setTitle(entity.getTitle());
        image.setUrl(entity.getUrl());
        image.setProduct(product);
        return ResponseEntity.ok(service.toDTO(service.save(image))) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImageDTO> modify(
            @PathVariable Long id,
            @RequestBody IncomeImageDTO entity) {
        Image image = new Image() ;
        Product product = productService.findById(entity.getProduct()) ;
        image.setId(id);
        image.setTitle(entity.getTitle());
        image.setUrl(entity.getUrl());
        image.setProduct(product);
        return ResponseEntity.ok(service.toDTO(service.save(image))) ;
    }

    @Override
    public ResponseEntity<String> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
