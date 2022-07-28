package com.franco.carsAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.franco.carsAPI.model.Category;
import com.franco.carsAPI.model.DTOResponse.CategoryDTO;
import com.franco.carsAPI.repository.CategoriesRepository;
import com.franco.carsAPI.repository.ProductRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.*;

@Service
public class CategoriesService implements ServiceInterfaceDTO<Category,CategoryDTO,Long> {

    @Autowired
    private CategoriesRepository repository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ObjectMapper objectMapper ;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }


    @Override
    public Category save(Category entity) {

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
        for (Category e : this.findAll()){
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<CategoryDTO> findAllDTO() {

        return this.toDTOList(this.findAll()) ;
    }

    @Override
    public CategoryDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    @Override
    public CategoryDTO toDTO(Category entity) {
        Integer total = 0 ;
        if (this.findById(entity.getId()).getProduct() != null ){
            total = this.findById(entity.getId()).getProduct().size() ;
        }
        return new CategoryDTO(
                entity.getId(),
                entity.getSingularTitle(),
                entity.getPluralTitle(),
                entity.getImage(),
                total) ;
    }

    @Override
    public Set<CategoryDTO> toDTOSet(Set<Category> entitySet) {
        Set<CategoryDTO> setDTO = new HashSet<>() ;
        for (Category category : entitySet
             ) {
            setDTO.add(this.toDTO(category)) ;
        }
        return setDTO ;
    }

    @Override
    public List<CategoryDTO> toDTOList(List<Category> entityList) {
        List<CategoryDTO> listDTO = new ArrayList<>() ;
        for (Category category : entityList
        ) {
            listDTO.add(this.toDTO(category)) ;
        }
        return listDTO;
    }
}
