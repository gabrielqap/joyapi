package br.com.api.joyapi.entity.dto;

import lombok.Data;

@Data
public class PersonDTO {
    private String username;
    private String password;
    private String type;
}