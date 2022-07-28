package com.franco.carsAPI.controller.controllerInterface;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ControllerInterface <EO,EI,I>{

    ResponseEntity<List<EO>> findAll() ;

    ResponseEntity<EO> findById(I id ) ;

    ResponseEntity<EO> save ( EI entity ) ;

    ResponseEntity<EO> modify ( I Id ,EI entity ) ;

    ResponseEntity<String> delete(I id ) ;

}
