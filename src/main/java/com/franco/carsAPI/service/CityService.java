package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.City;
import com.franco.carsAPI.model.DTOResponse.CityDTO;
import com.franco.carsAPI.repository.CityRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CityService implements ServiceInterfaceDTO<City,CityDTO,Long>{

    @Autowired
    private CityRepository repository;
    @Autowired
    private ObjectMapper objectMapper ;

    public List<City> findCityByCityName ( String name ){
        return repository.findCityByCityName(name).get() ;
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }


    @Override
    public City findById(Long id) {

        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;

    }

    @Override
    public City save(City entity) {
        return repository.save(entity);
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
        for (City city : this.findAll()
             ) {
            if (city.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<CityDTO> findAllDTO() {

        return this.toDTOList(this.findAll()) ;
    }

    @Override
    public CityDTO findDTOById(Long id) {

        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public CityDTO toDTO(City entity) {
        return new CityDTO(
                entity.getId(),
                entity.getCityName() ,
                entity.getCountry().getCountry()
        ) ;
    }

    @Override
    public Set<CityDTO> toDTOSet(Set<City> entitySet) {
        Set<CityDTO> setDTO = new HashSet<>() ;
        for (City entity: entitySet
        ) {
            setDTO.add(this.toDTO(entity)) ;
        }
        return setDTO ;
    }

    @Override
    public List<CityDTO> toDTOList(List<City> entityList) {
        List<CityDTO> listDTO = new ArrayList<>() ;
        for (City entity: entityList
        ) {
            listDTO.add(this.toDTO(entity)) ;
        }
        return listDTO ;
    }

    public List<CityDTO> findCityDTOByCityName( String cityName ){
        return this.toDTOList(repository.findCityByCityName(cityName).get()) ;
    }

}
