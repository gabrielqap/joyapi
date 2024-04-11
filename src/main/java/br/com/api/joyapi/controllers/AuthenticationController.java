package br.com.api.joyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.joyapi.entity.User;
import br.com.api.joyapi.entity.dto.AuthenticationDTO;
import br.com.api.joyapi.entity.dto.LoginResponseDTO;
import br.com.api.joyapi.entity.dto.RegisterDTO;
import br.com.api.joyapi.service.AuthorizationService;
import br.com.api.joyapi.service.TokenService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity <Object> login (@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
                
        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity <Object> register (@RequestBody @Validated RegisterDTO data) {

        boolean created = authorizationService.createNewUser(data);
        if(!created){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
