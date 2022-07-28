package com.franco.carsAPI.service;

import com.franco.carsAPI.model.Favorite;
import com.franco.carsAPI.repository.FavoriteRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterface;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Log4j2
@Service
public class FavoriteService implements ServiceInterface<Favorite,Long> {
    @Autowired
    private FavoriteRepository repository ;
    @Override
    public List<Favorite> findAll() {
        return repository.findAll();
    }

    @Override
    public Favorite findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    public Favorite findByProductIdAndUserId( Long productId , Long userId  ){
        return repository.findByProductIdAndUserId(productId,userId) ;
    }

    @Override
    public Favorite save(Favorite entity) {
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

    public String deleteByProductIdAndUserId(Long productId , Long userId ) {
        Long id = this.findByProductIdAndUserId(productId,userId).getId() ;
        log.info("Id a borrar: " + id );
        return this.delete(id) ;
    }

    @Override
    public Boolean exist(Long id) {
        for (Favorite e : this.findAll()){
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }
}
