package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Reservation;
import com.franco.carsAPI.model.DTOResponse.ReservationDTOResponse;
import com.franco.carsAPI.model.DTORequest.IncomeReservationDTO;
import com.franco.carsAPI.service.ProductService;
import com.franco.carsAPI.service.ReservationService;
import com.franco.carsAPI.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins = "*")
public class ReservationController implements ControllerInterface<ReservationDTOResponse, IncomeReservationDTO,Long> {

    @Autowired
     ReservationService service ;
     @Autowired
     ProductService productService ;
     @Autowired
     UserService userService ;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Lista de Ciudades",
            notes = "Devuelve todas las ciudades en la base de datos")
    @GetMapping
    public ResponseEntity<List<ReservationDTOResponse>> findAll() {
        return ResponseEntity.ok(service.toDTOList(service.findAll())) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Ciudad",
            notes = "Devuelve una ciudad filtrada por su Id ")
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTOResponse> findById(
            @ApiParam(
                    name =  "id",
                    type = "Long",
                    value = "Id de la ciudad a encontrar",
                    example = "1",
                    required = true )
            @PathVariable Long id){
        return ResponseEntity.ok(service.toDTO(service.findById(id))) ;
    }

    @GetMapping("/findByUserId/{id}")
    public List<ReservationDTOResponse> findAllReservationDTOByUserId( @PathVariable Long id ){
        return service.findAllReservationDTOByUserId(id) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Reserva",
            notes = "Devuelve la Reserva que se acaba de guardar")
    @PostMapping
    public ResponseEntity<ReservationDTOResponse> save(
            @ApiParam(
                    name =  "entity",
                    type = "Reservation",
                    value = "    \"startTime\": \"hh:mm:ss\",\n" +
                            "    \"startDay\": \"aaaa-MM-dd\",\n" +
                            "    \"finishDay\": \"aaaa-MM-dd\",\n" +
                            "    \"product\": Integer,\n" +
                            "    \"user\": Integer\n",
                    required = true )
            @RequestBody IncomeReservationDTO entity){
        Reservation reservation = new Reservation() ;
        reservation.setStartTime(entity.getStartTime());
        reservation.setStartDay(entity.getStartDay());
        reservation.setFinishDay(entity.getFinishDay());
        reservation.setProduct(productService.findById(entity.getProduct()));
        reservation.setUser(userService.findById(entity.getUser()));
        return ResponseEntity.ok(service.toDTO(service.save(reservation))) ;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation(value = "Devuelve una Ciudad",
            notes = "Devuelve la Ciudad que se acaba de modificar")
    @PutMapping
    public ResponseEntity<ReservationDTOResponse> modify(
            @PathVariable Long id,
            @ApiParam(
                    name =  "entity",
                    type = "Reservation",
                    value = "\"cityName\":\"nombre de la ciudad\",\n" +
                            "\"country\": Id del pais al que pertenece\n",
                    example = "Córdoba",
                    required = true )
            @RequestBody IncomeReservationDTO entity ){
        Reservation reservation = new Reservation() ;
        reservation.setId(id);
        reservation.setStartTime(entity.getStartTime());
        reservation.setStartDay(entity.getStartDay());
        reservation.setFinishDay(entity.getFinishDay());
        reservation.setProduct(productService.findById(entity.getProduct()));
        reservation.setUser(userService.findById(entity.getUser()));
        return ResponseEntity.ok(service.toDTO(service.save(reservation))) ;
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
