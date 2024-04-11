package br.com.api.joyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.api.joyapi.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    UserDetails findByUsername(String username);
}
