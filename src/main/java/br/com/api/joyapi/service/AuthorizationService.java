package br.com.api.joyapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.api.joyapi.entity.User;
import br.com.api.joyapi.entity.dto.AuthenticationDTO;
import br.com.api.joyapi.entity.dto.LoginResponseDTO;
import br.com.api.joyapi.entity.dto.RegisterDTO;
import br.com.api.joyapi.repository.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

    public boolean createNewUser(RegisterDTO data) {
        
        if (repository.findByUsername(data.username()) != null) { return false;}

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.username(), encryptedPassword, data.role());

        repository.save(user);

        return true;

    }
}
