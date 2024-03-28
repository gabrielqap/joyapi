package br.com.api.joyapi.entity;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Table(name = "event")
@Data
public class Event {
	@Id
	@GeneratedValue	(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	private String adress;

	private String city;
	
	private String state;

	@ManyToMany(mappedBy = "events")
	private List<Participant> participants;

	@ManyToOne(optional = false)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;
}
