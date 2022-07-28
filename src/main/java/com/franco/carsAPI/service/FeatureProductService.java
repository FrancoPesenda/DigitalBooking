package com.franco.carsAPI.service;

import com.franco.carsAPI.model.FeatureProduct;
import com.franco.carsAPI.model.DTOResponse.FeatureDTO;
import com.franco.carsAPI.model.DTOResponse.FeatureProductDTO;
import com.franco.carsAPI.repository.FeatureProductRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.*;

@Service
public class FeatureProductService implements ServiceInterfaceDTO<FeatureProduct, FeatureProductDTO, Long > {

    @Autowired
    private FeatureProductRepository repository ;
    @Autowired
    private FeatureService featureService;

    @Override
    public List<FeatureProduct> findAll() {
        return repository.findAll();
    }

    @Override
    public FeatureProduct findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    @Override
    public FeatureProduct save(FeatureProduct entity) {
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
        for (FeatureProduct featureProduct : this.findAll()
             ) {
            if (featureProduct.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<FeatureProductDTO> findAllDTO() {
        return this.toDTOList(this.findAll());
    }

    @Override
    public FeatureProductDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id));
    }

    @Override
    public FeatureProductDTO toDTO(FeatureProduct entity) {
        return new FeatureProductDTO(
                entity.getId(),
                entity.getProduct().getId(),
                entity.getProduct().getName(),
                entity.getFeature().getFeature()
        );
    }

    @Override
    public Set<FeatureProductDTO> toDTOSet(Set<FeatureProduct> entitySet) {
        Set<FeatureProductDTO> listDTO = new HashSet<>() ;
        for (FeatureProduct featureProduct : entitySet
        ) {
            listDTO.add(this.toDTO(featureProduct)) ;
        }
        return listDTO;
    }

    @Override
    public List<FeatureProductDTO> toDTOList(List<FeatureProduct> entityList) {
        List<FeatureProductDTO> listDTO = new ArrayList<>() ;
        for (FeatureProduct featureProduct : entityList
        ) {
            listDTO.add(this.toDTO(featureProduct)) ;
        }
        return listDTO;
    }

    public Set<FeatureDTO> findAllFeatureDTOByProductId(Long id ){
        Set<FeatureDTO> featureSet = new HashSet<>() ;
        for (FeatureProduct f : repository.findAllFeatureByProductId(id).get()
             ) {
            featureSet.add(featureService.toDTO(f.getFeature())) ;
        }
        return featureSet ;
    }

}
