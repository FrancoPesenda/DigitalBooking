package com.franco.carsAPI.controller;

import com.franco.carsAPI.controller.controllerInterface.ControllerInterface;
import com.franco.carsAPI.model.Policy;
import com.franco.carsAPI.model.DTORequest.IncomePolicyDTO;
import com.franco.carsAPI.service.PolicyService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policy")
@CrossOrigin( origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PolicyController implements ControllerInterface<Policy, IncomePolicyDTO , Integer> {

    @Autowired
    PolicyService policyService;

    @GetMapping
    public ResponseEntity<List<Policy>> findAll(){
        return ResponseEntity.ok(policyService.findAll()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> findById(@PathVariable Integer id ){
        return ResponseEntity.ok(policyService.findById(id)) ;
    }

    @PostMapping
    public ResponseEntity<Policy> save( @RequestBody IncomePolicyDTO entity ){
        Policy policy = new Policy();
        policy.setPolicy(entity.getPolicy());
        return ResponseEntity.ok(policyService.save(policy)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> modify(
            @PathVariable Integer id,
            @RequestBody IncomePolicyDTO entity) {
        Policy policy = new Policy();
        policy.setId(id);
        policy.setPolicy(entity.getPolicy());
        return ResponseEntity.ok(policyService.save(policy)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id ){
        return ResponseEntity.ok(policyService.delete(id)) ;
    }
}
