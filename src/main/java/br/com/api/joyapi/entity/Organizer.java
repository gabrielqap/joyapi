package br.com.api.joyapi.entity;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Table(name = "organizer")
@AttributeOverride(name = "id", column = @Column(name = "organizer_id"))
@Entity
public class Organizer extends Person {
	@OneToMany(mappedBy = "organizer")
	private List<Event> events;

}
