package com.franco.carsAPI.service;

import com.franco.carsAPI.model.Role;
import com.franco.carsAPI.repository.RoleRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
@Service
public class RoleService implements ServiceInterface<Role,Long> {
    @Autowired
    RoleRepository repository ;
    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Role findById(Long id) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    @Override
    public Role save(Role entity) {
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
        for (Role e : this.findAll()){
            if (e.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }
}
