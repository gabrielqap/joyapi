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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "adress")
	private String adress;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;

	@ManyToMany(mappedBy = "events")
	private List<Participant> participants;

	@ManyToOne
    @JoinColumn(name = "id")
    private Organizer organizer;
}
