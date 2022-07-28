package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.DTORequest.FavoriteDTORequest;
import com.franco.carsAPI.model.Favorite;
import com.franco.carsAPI.service.FavoriteService;
import com.franco.carsAPI.service.ProductService;
import com.franco.carsAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
@CrossOrigin(origins = "*")
public class FavoriteController implements ControllerInterface<Favorite, FavoriteDTORequest,Long> {

    @Autowired
    FavoriteService service ;
    @Autowired
    ProductService productService ;
    @Autowired
    UserService userService ;

    @GetMapping
    public ResponseEntity<List<Favorite>> findAll() {
        return ResponseEntity.ok(service.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorite> findById( @PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id)) ;
    }

    @GetMapping("/productIdAndUserId")
    public ResponseEntity<Favorite> findByProductIdAndUserId(
            @RequestParam("productId")
                    Long productId ,
            @RequestParam("userId")
                    Long userId ){
        return ResponseEntity.ok(service.findByProductIdAndUserId(productId,userId)) ;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_CLIENT') and hasRole('ROLE_ADMIN')")
    public ResponseEntity<Favorite> save( @RequestBody FavoriteDTORequest entity) {
        Favorite favorite = new Favorite() ;
        favorite.setProduct(productService.findById(entity.getProduct()));
        favorite.setUser(userService.findById(entity.getUser()));
        return ResponseEntity.ok(service.save(favorite)) ;
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_CLIENT') and hasRole('ROLE_ADMIN')")
    public ResponseEntity<Favorite> modify(
            @PathVariable Long id,
            @RequestBody FavoriteDTORequest entity) {
        Favorite favorite = new Favorite() ;
        favorite.setId(id);
        favorite.setProduct(productService.findById(entity.getProduct()));
        favorite.setUser(userService.findById(entity.getUser()));
        return ResponseEntity.ok(service.save(favorite)) ;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_CLIENT') and hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> delete( @PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }


    @DeleteMapping("/productIdAndUserId")
    @PreAuthorize("hasRole('ROLE_CLIENT') and hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> deleteByProductIdAndUserId(
            @RequestParam("productId")
            Long productId ,
            @RequestParam("userId")
            Long userId ){
        return ResponseEntity.ok(service.deleteByProductIdAndUserId(productId,userId)) ;
    }



}
