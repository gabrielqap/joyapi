package br.com.api.joyapi.entity;

import java.util.List;
import java.util.Set;

import br.com.api.joyapi.entity.enums.EventEnum;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "participants")
@AttributeOverride(name = "id", column = @Column(name = "participant_id"))
public class Participant extends Person {
	@ManyToMany
    @JoinTable(
        name = "participants_events",
        joinColumns = @JoinColumn(name = "participant_id"),
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
	private List<Event> events;

	@ElementCollection(targetClass = EventEnum.class)
    @CollectionTable(name = "participant_preferred_events", joinColumns = @JoinColumn(name = "id"))
    @Enumerated(EnumType.STRING)
	private Set<EventEnum> favoritesEvents;

}
