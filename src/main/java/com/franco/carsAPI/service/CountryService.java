package com.franco.carsAPI.service;

import com.franco.carsAPI.model.Country;
import com.franco.carsAPI.repository.CountryRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;
import java.util.List;

@Service
public class CountryService implements ServiceInterface<Country , Long> {

    @Autowired
    private CountryRepository repository ;

    @Override
    public List<Country> findAll() {
        return repository.findAll() ;
    }

    @Override
    public Country findById(Long id) {
        if (!exist(id)){
            throw new EntityNotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }

        return repository.findById(id).get() ;
    }

    @Override
    public Country save(Country entity) {
        return repository.save(entity);
    }

    @Override
    public String delete(Long id ){

        if (this.exist(id)){
            repository.deleteById(id);
            return "Deleted" ;
        }
        throw new BadRequestException("El ID proveido no pertenece a ningun dato en la base de datos") ;

    }

    @Override
    public Boolean exist(Long id) {
        for (Country country : this.findAll() ){
            if (country.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }
}
