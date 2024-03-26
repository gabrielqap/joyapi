package br.com.api.joyapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.joyapi.entity.Person;
import br.com.api.joyapi.entity.dto.PersonDTO;
import br.com.api.joyapi.service.LoginService;

public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<Person> login(@RequestBody PersonDTO personDTO) {
        Person loggedPerson = LoginService.authenticateUser(personDTO);
        if (loggedPerson != null) {
            return ResponseEntity.ok(loggedPerson);  
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Retorna 401 Unauthorized
        }
    }
}
