package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.City;
import com.franco.carsAPI.model.Location;
import com.franco.carsAPI.model.DTOResponse.LocationDTO;
import com.franco.carsAPI.model.DTORequest.IncomeLocationDTO;
import com.franco.carsAPI.service.CityService;
import com.franco.carsAPI.service.CountryService;
import com.franco.carsAPI.service.LocationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "*")
public class LocationController implements ControllerInterface<LocationDTO, IncomeLocationDTO, Long> {

    @Autowired
    private LocationService service ;
    @Autowired
    private CityService cityService;
    @Autowired
    private CountryService countryService;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve un Array con las Categorias de la base de datos")
    @GetMapping
    public ResponseEntity<List<LocationDTO>> findAll() {
        return ResponseEntity.ok(service.findAllDTO()) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve una Categoria filtrado por ID ")
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id del producto que estoy buscando encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){
        return ResponseEntity.ok(service.findDTOById(id)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve una Categoria que se acaba de guardar")
    @PostMapping
    public ResponseEntity<LocationDTO> save(
            @ApiParam(
                    name =  "Ubicación",
                    type = "Location",
                    value = "\"title\": \"Titulo de la Categoría\",\n" +
                            "\"description\": \"Descripción de la categoría\",\n" +
                            "\"image\": \"URL de la imágen\"\n",
                    required = true)
            @RequestBody IncomeLocationDTO e){
        City city = cityService.findById(e.getCity()) ;
        Location location = new Location() ;
        location.setAddress(e.getAddress());
        location.setAddressNumber(e.getAddressNumber());
        location.setLatitude(e.getLatitude());
        location.setLongitude(e.getLongitude());
        location.setCity(city);
        return ResponseEntity.ok(service.toDTO(service.save(location))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Categoria",
            notes = "Devuelve una Categoria que se acaba de modificar")
    @PutMapping
    public ResponseEntity<LocationDTO> modify(
            @PathVariable Long id,
            @ApiParam(
                    name =  "Ubicación",
                    type = "Location",
                    value = "\"title\": \"Titulo de la Categoría\",\n" +
                            "\"description\": \"Descripción de la categoría\",\n" +
                            "\"image\": \"URL de la imágen\"\n",
                    required = true)
            @RequestBody IncomeLocationDTO e){
        City city = cityService.findById(e.getCity()) ;
        Location location = new Location() ;
        location.setId(id);
        location.setAddress(e.getAddress());
        location.setAddressNumber(e.getAddressNumber());
        location.setLatitude(e.getLatitude());
        location.setLongitude(e.getLongitude());
        location.setCity(city);
        return ResponseEntity.ok(service.toDTO(service.save(location))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Mensaje",
            notes = "Devuelve un String deleted en caso de que se borro correctamente")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la categoria que estoy buscando borrar",
                    example = "1",
                    required = true )
            @PathVariable Long id ){

        return ResponseEntity.ok(service.delete(id));
    }
}
