package com.franco.carsAPI.service;

import com.franco.carsAPI.model.Location;
import com.franco.carsAPI.model.DTOResponse.LocationDTO;
import com.franco.carsAPI.repository.CityRepository;
import com.franco.carsAPI.repository.CountryRepository;
import com.franco.carsAPI.repository.LocationRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationService implements ServiceInterfaceDTO<Location , LocationDTO ,Long> {

    @Autowired
    LocationRepository repository ;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    CountryRepository countryRepository;

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }

    @Override
    public Location findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get();
    }

    @Override
    public Location save(Location entity) {
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
        for (Location e : this.findAll()
        ) {
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    public Boolean existByAdressNameAndNumber( String addres , String number ){
        return repository.findLocationByAddressAndAddressNumber(addres, number).isPresent();
    }

    public Location findLocationByAddressAndAddressNumber( String address , String number ){
        return repository.findLocationByAddressAndAddressNumber(address , number).get() ;
    }

    @Override
    public List<LocationDTO> findAllDTO() {
        return this.toDTOList(this.findAll());
    }

    @Override
    public LocationDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public LocationDTO toDTO(Location entity) {
        return new LocationDTO(
                entity.getId(),
                entity.getAddress(),
                entity.getAddressNumber(),
                entity.getLatitude(),
                entity.getLongitude(),
                cityRepository.findById(entity.getCity().getId()).get().getCityName(),
                countryRepository.findById(entity.getCity().getCountry().getId()).get().getCountry()
        );
    }

    @Override
    public Set<LocationDTO> toDTOSet(Set<Location> entitySet) {
        Set<LocationDTO> listDTO = new HashSet<>() ;
        for (Location e : entitySet
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

    @Override
    public List<LocationDTO> toDTOList(List<Location> entityList) {
        List<LocationDTO> listDTO = new ArrayList<>() ;
        for (Location e : entityList
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

    public List<Location> findAllLocationByCityId( Long id ){
        return repository.findAllLocationByCityId(id).get() ;
    }

}
