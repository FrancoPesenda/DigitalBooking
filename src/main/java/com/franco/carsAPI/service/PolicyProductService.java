package com.franco.carsAPI.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.PolicyProduct;
import com.franco.carsAPI.model.DTOResponse.PolicyProductDTO;
import com.franco.carsAPI.repository.PolicyRepository;
import com.franco.carsAPI.repository.PolicyProductRepository;
import com.franco.carsAPI.repository.ProductRepository;
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
public class PolicyProductService implements ServiceInterfaceDTO<PolicyProduct , PolicyProductDTO , Long > {
    @Autowired
    PolicyProductRepository repository ;
    @Autowired
    PolicyRepository policyRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ObjectMapper objectMapper ;

    @Override
    public List<PolicyProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public PolicyProduct findById(Long id) {
        if (this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    @Override
    public PolicyProduct save(PolicyProduct entity) {
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
        for (PolicyProduct pp : this.findAll()
             ) {
            if (pp.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<PolicyProductDTO> findAllDTO() {
        return null;
    }

    @Override
    public PolicyProductDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public PolicyProductDTO toDTO(PolicyProduct entity) {
        return new PolicyProductDTO(
                entity.getPolicy().getPolicy(),
                entity.getDescription()
        );
    }

    @Override
    public Set<PolicyProductDTO> toDTOSet(Set<PolicyProduct> entitySet) {
        Set<PolicyProductDTO> listDTO = new HashSet<>() ;
        for (PolicyProduct pp : entitySet
        ) {
            listDTO.add(this.toDTO(pp)) ;
        }
        return listDTO;
    }

    @Override
    public List<PolicyProductDTO> toDTOList(List<PolicyProduct> entityList) {
        List<PolicyProductDTO> listDTO = new ArrayList<>() ;
        for (PolicyProduct pp : entityList
        ) {
            listDTO.add(this.toDTO(pp)) ;
        }
        return listDTO;
    }

    public Set<PolicyProductDTO> findAllPolicyByProductId(Long id ){
        Set<PolicyProductDTO> list = new HashSet<>() ;
        for (PolicyProduct p : repository.findAllPolicyProductByProductId(id).get()
        ) {
            list.add(this.toDTO(p)) ;
        }
        return list ;
    }

}
