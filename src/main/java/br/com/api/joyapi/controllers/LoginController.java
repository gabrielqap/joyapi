package br.com.api.joyapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.joyapi.entity.dto.PersonDTO;
import br.com.api.joyapi.entity.dto.ResponseDTO;
import br.com.api.joyapi.service.LoginService;

public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody PersonDTO personDTO) {
        if (LoginService.authenticateUser(personDTO)) {
            ResponseDTO responseDTO = new ResponseDTO("Successful login!");
            return ResponseEntity.ok(responseDTO);  
        } else {
            ResponseDTO responseDTO = new ResponseDTO("Invalid credentials!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDTO); // Retorna 401 Unauthorized
        }
    }
}
