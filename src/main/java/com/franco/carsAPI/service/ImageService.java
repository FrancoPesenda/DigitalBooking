package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.Image;
import com.franco.carsAPI.model.DTOResponse.ImageDTO;
import com.franco.carsAPI.repository.ImageRepository;
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
public class ImageService implements ServiceInterfaceDTO<Image,ImageDTO,Long> {

    @Autowired
    private ImageRepository repository ;
    @Autowired
    private ObjectMapper objectMapper ;

    @Override
    public List<Image> findAll() {
        return repository.findAll();
    }

    @Override
    public Image findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get();
    }

    @Override
    public Image save(Image entity) {
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
        for (Image e : this.findAll()
             ) {
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<ImageDTO> findAllDTO() {
        return this.toDTOList(this.findAll());
    }

    @Override
    public ImageDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public ImageDTO toDTO(Image entity) {
        return new ImageDTO(
                entity.getId(),
                entity.getTitle(),
                entity.getUrl()
        );
    }

    public Set<ImageDTO> findByProductId( Long id ){
        return this.toDTOSet(repository.findAllImageFromProductID(id).get()) ;
    }

    @Override
    public Set<ImageDTO> toDTOSet(Set<Image> entitySet) {
        Set<ImageDTO> listDTO = new HashSet<>() ;
        for (Image e : entitySet
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

    @Override
    public List<ImageDTO> toDTOList(List<Image> entityList) {
        List<ImageDTO> listDTO = new ArrayList<>() ;
        for (Image e : entityList
        ) {
            listDTO.add(this.toDTO(e)) ;
        }
        return listDTO;
    }

}
