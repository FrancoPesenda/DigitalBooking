package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Country;
import com.franco.carsAPI.model.DTORequest.IncomeCountryDTO;
import com.franco.carsAPI.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@CrossOrigin(origins = "*")
public class CountryController implements ControllerInterface<Country , IncomeCountryDTO , Long> {

    @Autowired
    private CountryService service ;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Países",
            notes = "Devuelve todas las Países en la base de datos")
    @GetMapping
    public ResponseEntity<List<Country>> findAll(){
        return ResponseEntity.ok(service.findAll()) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un País",
            notes = "Devuelve un País filtrada por su Id ")
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id del País que buscando encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.findById(id)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un País",
            notes = "Devuelve el País que se acaba de guardar")
    @PostMapping
    public ResponseEntity<Country> save(
            @ApiParam(
                    name =  "entity",
                    type = "City",
                    value = "    \"country\":\"nombre del país\"\n",
                    required = true )
            @RequestBody IncomeCountryDTO entity ){
        Country country = new Country() ;
        country.setCountry(entity.getCountry());
        return ResponseEntity.ok(service.save(country)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve un País",
            notes = "Devuelve el País que se acaba de modificar")
    @PutMapping
    public ResponseEntity<Country> modify(
            @PathVariable Long id,
            @ApiParam(
                    name =  "entity",
                    type = "City",
                    value = "    \"country\":\"nombre del país\"\n",
                    required = true )
            @RequestBody IncomeCountryDTO entity ){
        Country country = new Country() ;
        country.setId(id);
        country.setCountry(entity.getCountry());
        return ResponseEntity.ok(service.save(country)) ;
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
                    value = "Id del País que buscando encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.delete(id)) ;
    }

}
