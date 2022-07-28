package com.franco.carsAPI.controller;

import com.franco.carsAPI.model.User;
import com.franco.carsAPI.model.DTOResponse.AuthenticationDTOResponse;
import com.franco.carsAPI.model.DTORequest.AuthenticationDTORequest;
import com.franco.carsAPI.model.security.PaswordEncoder;
import com.franco.carsAPI.service.UserService;
import com.franco.carsAPI.service.serviceInterface.IJwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*" , maxAge = 3600, methods = {RequestMethod.GET, RequestMethod.POST})
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PaswordEncoder paswordEncoder ;
    @Autowired
    private UserService userService ;
    @Autowired
    private IJwtService jwtService;


    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationDTORequest authenticationDTORequest) throws Exception{

        User entity = userService.findByEmail(authenticationDTORequest.getEmail()) ;

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDTORequest.getEmail(), authenticationDTORequest.getPassword()));
        }catch (BadCredentialsException e) {
            throw new Exception("Incorrect", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDTORequest.getEmail());
        final String jwt = jwtService.generateToken(userDetails);
        final AuthenticationDTOResponse userAndJwt = userService.toJwtDTO(entity,jwt);

        return ResponseEntity.ok((userAndJwt));
    }

}
