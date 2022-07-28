package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.Policy;
import com.franco.carsAPI.repository.PolicyRepository;
import com.franco.carsAPI.repository.PolicyProductRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterface;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyService implements ServiceInterface<Policy,Integer> {
    @Autowired
    PolicyRepository policyRepository;
    @Autowired
    PolicyProductRepository policyProductRepository;
    @Autowired
    ObjectMapper objectMapper ;

    public List<Policy> findAll(){
        return policyRepository.findAll() ;
    }

    public Policy findById( Integer id ){
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return policyRepository.findById(id).get() ;
    }

    public Policy save( Policy policy){
        return policyRepository.save(policy) ;
    }

    @Override
    public String delete(Integer id) {

        if (this.exist(id)){
            policyRepository.deleteById(id);
            return "Deleted" ;
        }
        throw new BadRequestException("El ID proveido no pertenece a ningun dato en la base de datos") ;

    }

    @Override
    public Boolean exist(Integer id) {
        for (Policy policy : this.findAll()
             ) {
            if (policy.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

}
