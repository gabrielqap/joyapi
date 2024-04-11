package br.com.api.joyapi.entity;

import java.sql.Date;
import br.com.api.joyapi.entity.enums.GenderEnum;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class Person {
	@Id
	@GeneratedValue	(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String photo;
	
	private GenderEnum gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "created_at", updatable = false)
	private Date createdAt;

	@Column(nullable = false, unique = true)
	private String email;

	@OneToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public boolean isUserIdPresent() {
        return this.getUser() != null && this.getUser().getId() != null;
    }

    @PrePersist
    public void validate() {
        if (!isUserIdPresent()) {
            throw new IllegalStateException("userId is required");
        }
    }
}
