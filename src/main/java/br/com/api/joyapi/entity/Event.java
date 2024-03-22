package br.com.api.joyapi.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "events")
@Data
public class Event {
	@Id
	@GeneratedValue	(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	private Date date;

	private String adress;

	private String city;
	
	private String state;

	@ManyToMany(mappedBy = "events")
	private List<Participant> participants;

	@ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;
}
