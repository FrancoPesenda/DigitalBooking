package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.City;
import com.franco.carsAPI.model.DTOResponse.CityDTO;
import com.franco.carsAPI.model.DTORequest.IncomeCityDTO;
import com.franco.carsAPI.service.CityService;
import com.franco.carsAPI.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@CrossOrigin(origins = "*")
public class CityController implements ControllerInterface<CityDTO, IncomeCityDTO,Long> {

    @Autowired
    private CityService service ;
    @Autowired
    private CountryService countryService;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Ciudades",
            notes = "Devuelve todas las ciudades en la base de datos")
    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){

        return ResponseEntity.ok(service.toDTOList(service.findAll())) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Ciudad",
            notes = "Devuelve una ciudad filtrada por su Id ")
    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la ciudad a encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id){
        return ResponseEntity.ok(service.toDTO(service.findById(id))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Ciudades",
            notes = "Devuelve una ciudad filtrada por el nombre de una ciudad ")
    @GetMapping("/findCityByName/{name}")
    public ResponseEntity<List<CityDTO>> findCityDTOByCityName(
            @ApiParam(
                    name =  "name",
                    type = "String",
                    value = "nombre de la ciudad por la cual queremos filtrar, pueden ser valores parciales",
                    example = "Córdoba",
                    required = true )
            @PathVariable String name ){
        return ResponseEntity.ok(service.findCityDTOByCityName(name)) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Ciudad",
            notes = "Devuelve la Ciudad que se acaba de guardar")
    @PostMapping
    public ResponseEntity<CityDTO> save(
            @ApiParam(
                    name =  "entity",
                    type = "City",
                    value = "\"cityName\":\"nombre de la ciudad\",\n" +
                            "\"country\": Id del pais al que pertenece\n",
                    example = "Córdoba",
                    required = true )
            @RequestBody IncomeCityDTO entity ){
        City city = new City() ;
        city.setCityName(entity.getCityName());
        city.setCountry(countryService.findById(entity.getCountry()));
        return ResponseEntity.ok(service.toDTO(service.save(city))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Ciudad",
            notes = "Devuelve la Ciudad que se acaba de modificar")
    @PutMapping
    public ResponseEntity<CityDTO> modify(
            @PathVariable Long id,
            @ApiParam(
                    name = "entity",
                    type = "City",
                    value = "\"cityName\":\"nombre de la ciudad\",\n" +
                            "\"country\": Id del pais al que pertenece\n",
                    example = "Córdoba",
                    required = true )
            @RequestBody IncomeCityDTO entity ){
        City city = new City() ;
        city.setId(id);
        city.setCityName(entity.getCityName());
        city.setCountry(countryService.findById(entity.getCountry()));
        return ResponseEntity.ok(service.toDTO(service.save(city))) ;
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
                    value = "Id de la ciudad que estoy buscando borrar",
                    example = "1",
                    required = true )
            @PathVariable Long id){
        return ResponseEntity.ok(service.delete(id)) ;
    }

}
