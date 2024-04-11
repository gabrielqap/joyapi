package br.com.api.joyapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.joyapi.entity.dto.AuthenticationDTO;
import br.com.api.joyapi.entity.dto.RegisterDTO;
import br.com.api.joyapi.service.AuthorizationService;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("/login")
    public ResponseEntity <Object> login (@RequestBody @Validated AuthenticationDTO data){
        var token = authorizationService.login(data);

        return ResponseEntity.ok(token);
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
