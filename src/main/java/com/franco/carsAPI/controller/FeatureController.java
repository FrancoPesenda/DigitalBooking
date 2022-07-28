package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Feature;
import com.franco.carsAPI.model.DTORequest.IncomeFeatureDTO;
import com.franco.carsAPI.service.FeatureService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feature")
@CrossOrigin(origins = "*")
public class FeatureController implements ControllerInterface<Feature, IncomeFeatureDTO , Long> {

    @Autowired
    private FeatureService service ;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Características",
            notes = "Devuelve todas las Características en la base de datos")
    @GetMapping
    public ResponseEntity<List<Feature>> findAll(){

        return ResponseEntity.ok(service.findAll()) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Características",
            notes = "Devuelve una Características filtrada por su Id ")
    @GetMapping("/getByID/{id}")
    public ResponseEntity<Feature> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la Característica a encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id){
        return ResponseEntity.ok(service.findById(id)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Características",
            notes = "Devuelve una Características que se acaba de guardar ")
    @PostMapping
    public ResponseEntity<Feature> save(
            @ApiParam(
                    name =  "entity",
                    type = "Feature",
                    value = "feature\":\"Característica\"",
                    required = true )
            @RequestBody IncomeFeatureDTO entity ){
        Feature feature = new Feature() ;
        feature.setFeature(entity.getFeature());
        return ResponseEntity.ok(service.add(feature)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Características",
            notes = "Devuelve una Características que se acaba de modificar ")
    @PutMapping
    public ResponseEntity<Feature> modify(
            @PathVariable Long id,
            @ApiParam(
                    name =  "entity",
                    type = "Feature",
                    value = "feature\":\"Característica\"",
                    required = true )
            @RequestBody IncomeFeatureDTO entity ){
        Feature feature = new Feature() ;
        feature.setId(id);
        feature.setFeature(entity.getFeature());
        return ResponseEntity.ok(service.add(feature)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un String",
            notes = "Devuelve un String deleted en caso de que se borro correctamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la Característica a borrar",
                    example = "1",
                    required = true )
            @PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("Deleted Correct") ;
    }

}
