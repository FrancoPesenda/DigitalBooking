package com.franco.carsAPI.controller;

import com.franco.carsAPI.model.DTORequest.IncomeUserDTO;
import com.franco.carsAPI.model.DTOResponse.UserDTO;
import com.franco.carsAPI.model.User;
import com.franco.carsAPI.service.RoleService;
import com.franco.carsAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*"  , maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService service ;
    @Autowired
    private RoleService roleService ;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){

        return ResponseEntity.ok(service.findAllDTO()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findDTOById(id)) ;
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(
            @RequestBody IncomeUserDTO entity ){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder() ;
        User user = new User() ;
        user.setName(entity.getName());
        user.setLastName(entity.getLastname());
        user.setEmail(entity.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        user.setRole(roleService.findById((long)1));
        return ResponseEntity.ok(service.toDTO(service.save(user))) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> modify(
            @PathVariable Long id,
            @RequestBody IncomeUserDTO entity ){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder() ;
        User user = new User() ;
        user.setId(id);
        user.setName(entity.getName());
        user.setLastName(entity.getLastname());
        user.setEmail(entity.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        user.setRole(roleService.findById((long)1));
        return ResponseEntity.ok(service.toDTO(service.save(user))) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id)) ;
    }

}
