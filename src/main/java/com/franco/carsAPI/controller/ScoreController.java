package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Score;
import com.franco.carsAPI.model.DTORequest.IncomeScoreDTO;
import com.franco.carsAPI.service.ProductService;
import com.franco.carsAPI.service.ScoreService;
import com.franco.carsAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
@CrossOrigin(origins = "*" )
public class ScoreController implements ControllerInterface<Score, IncomeScoreDTO,Long> {

    @Autowired
    private ScoreService service;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Score>> findAll(){
        return ResponseEntity.ok(service.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> findById(@PathVariable Long id ){

        return ResponseEntity.ok(service.findById(id)) ;
    }

    @PostMapping
    public ResponseEntity<Score> save( @RequestBody IncomeScoreDTO entity ){
        Score score = new Score() ;
        score.setScore(entity.getScore());
        score.setProduct(productService.findById(entity.getProduct()));
        score.setUser(userService.findById(entity.getUser()));
        return ResponseEntity.ok(service.save(score)) ;
    }

    @PutMapping
    public ResponseEntity<Score> modify(
            @PathVariable Long id,
            @RequestBody IncomeScoreDTO entity ){
        Score score = new Score() ;
        score.setId(id);
        score.setScore(entity.getScore());
        score.setProduct(productService.findById(entity.getProduct()));
        score.setUser(userService.findById(entity.getUser()));
        return ResponseEntity.ok(service.save(score)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
