package com.franco.carsAPI.service;

import com.franco.carsAPI.model.DTOResponse.AuthenticationDTOResponse;
import com.franco.carsAPI.model.DTOResponse.UserDTO;
import com.franco.carsAPI.model.Favorite;
import com.franco.carsAPI.model.Product;
import com.franco.carsAPI.model.User;
import com.franco.carsAPI.model.security.PaswordEncoder;
import com.franco.carsAPI.repository.UserRepository;
import com.franco.carsAPI.service.serviceInterface.ServiceInterfaceDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Log4j2
@Service
public class UserService implements ServiceInterfaceDTO<User , UserDTO , Long >, UserDetailsService {

    @Autowired
    private UserRepository repository ;
    @Autowired
    private ProductService productService ;

    public List<User> findAll(){ return repository.findAll() ; }

    public User findById( Long id ) {
        if (!this.exist(id)){
            throw new NotFoundException("El ID proveido no pertenece a ningun dato en la base de datos") ;
        }
        return repository.findById(id).get() ;
    }

    public User findByEmail( String email ){
        for (User e : this.findAll()
             ) {
            if (e.getEmail().equals(email)){
                return e ;
            }
        }
        throw new NotFoundException("El Email proveido no pertenece a ningun dato en la base de datos") ;
    }

    public User save( User entitie ) { return repository.save(entitie) ; }

    public String delete( Long id ) {
        if (this.exist(id)){
            repository.deleteById(id);
            return "Deleted" ;
        }
        throw new BadRequestException("El ID proveido no pertenece a ningun dato en la base de datos") ;
    }

    @Override
    public Boolean exist(Long id) {
        for (User user : this.findAll()){
            if (user.getId().equals(id)){
                return true ;
            }
        }
        return false ;
    }

    @Override
    public List<UserDTO> findAllDTO() {
        return this.toDTOList(this.findAll()) ;
    }

    @Override
    public UserDTO findDTOById(Long id) {
        return this.toDTO(this.findById(id)) ;
    }

    public List<Product> findAllProduct( Long id ){
        List<Product> list = new ArrayList<>() ;
        if (this.findById(id).getFavoriteSet() == null){
            return list ;
        }
        for (Favorite e : this.findById(id).getFavoriteSet()
             ) {
            list.add(e.getProduct()) ;
        }
        return list ;
    }

    @Override
    public UserDTO toDTO(User entity) {
        return new UserDTO(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getRole().getName(),
                productService.toDTOList(this.findAllProduct(entity.getId()))
        );
    }

    public AuthenticationDTOResponse toJwtDTO(User entity , String jwt ){
        return new AuthenticationDTOResponse(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getRole().getName(),
                productService.toDTOList(this.findAllProduct(entity.getId())),
                jwt
        );
    }

    @Override
    public Set<UserDTO> toDTOSet(Set<User> entitySet) {
        Set<UserDTO> setDTO = new HashSet<>() ;
        for (User e : entitySet
        ) {
            setDTO.add(this.toDTO(e)) ;
        }
        return setDTO ;
    }

    @Override
    public List<UserDTO> toDTOList(List<User> entityList) {
        List<UserDTO> setDTO = new ArrayList<>() ;
        for (User e : entityList
        ) {
            setDTO.add(this.toDTO(e)) ;
        }
        return setDTO ;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Consultara username " + email + " en base de datos");
        User user = repository.findByEmail(email);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        PaswordEncoder paswordEncoder = new PaswordEncoder() ;
        log.info("Usuario autenticado: " + email);
        return new org.springframework.security.core.userdetails.User(email, user.getPassword(), true, true, true, true, authorities);
    }
}
