package br.com.api.joyapi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "organizers")
@Data
public class Organizer extends Person {

	@Id
	@GeneratedValue	(strategy = GenerationType.AUTO)
	@Column(name = "participant_id")
	private Long id;


	@OneToMany(mappedBy = "organizer")
	private List<Event> events;

}
