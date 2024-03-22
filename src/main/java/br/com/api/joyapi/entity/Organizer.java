package br.com.api.joyapi.entity;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "organizers")
@AttributeOverride(name = "id", column = @Column(name = "organizer_id"))
@Entity
public class Organizer extends Person {
	@OneToMany(mappedBy = "organizer")
	private List<Event> events;

}
