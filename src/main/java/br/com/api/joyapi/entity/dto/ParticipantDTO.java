package br.com.api.joyapi.entity.dto;

public class ParticipantDTO {
    private String name;
    private String photo;
    
    public ParticipantDTO(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}
