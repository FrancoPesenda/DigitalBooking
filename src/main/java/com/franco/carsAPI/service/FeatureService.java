package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.Feature;
import com.franco.carsAPI.model.DTOResponse.FeatureDTO;
import com.franco.carsAPI.repository.FeatureRepository;
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
public class FeatureService implements ServiceInterfaceDTO<Feature,FeatureDTO,Long> {

    @Autowired
    private FeatureRepository repository ;
    @Autowired
    private ObjectMapper objectMapper ;

    public Feature add( Feature entitie ) { return repository.save(entitie) ; }

    @Override
    public List<Feature> findAll() {
        return repository.findAll() ;
    }

    @Override
    public Feature findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    @Override
    public Feature save(Feature entity) {
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
        for (Feature feature : this.findAll()){
            if (feature.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<FeatureDTO> findAllDTO() {
        return this.toDTOList(this.findAll());
    }

    @Override
    public FeatureDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id));
    }

    @Override
    public FeatureDTO toDTO(Feature entity) {
        return new FeatureDTO(
                entity.getId(),
                entity.getFeature()
        );
    }

    @Override
    public Set<FeatureDTO> toDTOSet(Set<Feature> entitySet) {
        Set<FeatureDTO> listDTO = new HashSet<>() ;
        for (Feature feature : entitySet
        ) {
            listDTO.add(this.toDTO(feature)) ;
        }
        return listDTO;
    }

    @Override
    public List<FeatureDTO> toDTOList(List<Feature> entityList) {
        List<FeatureDTO> listDTO = new ArrayList<>() ;
        for (Feature feature : entityList
        ) {
            listDTO.add(this.toDTO(feature)) ;
        }
        return listDTO;
    }


}
