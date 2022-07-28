package com.franco.carsAPI.service;

import com.franco.carsAPI.model.Reservation;
import com.franco.carsAPI.model.DTOResponse.ReservationDTOResponse;
import com.franco.carsAPI.repository.ReservationRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Log4j2
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservationService implements ServiceInterfaceDTO<Reservation, ReservationDTOResponse, Long> {

    @Autowired
    ReservationRepository repository ;
    @Autowired
    ProductService productService;

    @Override
    public List<Reservation> findAll() {
        return repository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }
    // AGREGAR AL CONTROLLER
    public List<ReservationDTOResponse> findAllDTOByProductId(Long id ){
        List<ReservationDTOResponse> list = new ArrayList<>() ;
        for (Reservation e : this.findAll()
             ) {
            if (e.getProduct().getId().equals(id)){
                list.add(this.toDTO(e)) ;
            }
        }
        return list ;
    }

    public List<Reservation> findAllByProductId( Long id ){
        List<Reservation> list = new ArrayList<>() ;
        for (Reservation e : this.findAll()
        ) {
            if (e.getProduct().getId().equals(id)){
                list.add(e) ;
            }
        }
        return list ;
    }

    @Override
    public Reservation save(Reservation entity) {
        return repository.save(entity) ;
    }

    @Override
    public String delete(Long id) {

        if (this.exist(id)){
            repository.deleteById(id);
            return "Deleted" ;
        }
        throw new BadRequestException("El ID proveido no pertenece a ningun dato en la base de datos") ;

    }

    @Override
    public Boolean exist(Long id) {
        for (Reservation e : this.findAll()){
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<ReservationDTOResponse> findAllDTO() {
        return this.toDTOList(this.findAll()) ;
    }

    @Override
    public ReservationDTOResponse findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public ReservationDTOResponse toDTO(Reservation entity) {
        return new ReservationDTOResponse(
                entity.getId(),
                entity.getStartTime(),
                entity.getStartDay(),
                entity.getFinishDay(),
                productService.toDTO(productService.findById(entity.getProduct().getId()))
        );
    }

    @Override
    public Set<ReservationDTOResponse> toDTOSet(Set<Reservation> entitySet) {
        Set<ReservationDTOResponse> listDTO = new HashSet<>() ;
        for (Reservation e : entitySet
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

    public List<Reservation> findAllReservationByUserId( Long id ){
        return repository.findAllReservationByUserId(id) ;
    }

    public List<ReservationDTOResponse> findAllReservationDTOByUserId( Long id ){
        List<ReservationDTOResponse> list = new ArrayList<>();
        for (Reservation e : repository.findAllReservationByUserId(id)){
            list.add(new ReservationDTOResponse(
               e.getId(),
               e.getStartTime(),
               e.getStartDay(),
               e.getFinishDay(),
               productService.toDTO(e.getProduct())
            ));
        }
        return list ;
    }



    @Override
    public List<ReservationDTOResponse> toDTOList(List<Reservation> entityList) {
        List<ReservationDTOResponse> listDTO = new ArrayList<>() ;
        for (Reservation e : entityList
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }
}
