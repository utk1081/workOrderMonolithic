package de.gloresoft.workorderapi.services.security;

import de.gloresoft.workorderapi.entities.User;
import de.gloresoft.workorderapi.exceptions.UserAlreadyExistsException;
import de.gloresoft.workorderapi.repositories.security.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder bCryptEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder bCryptEncoder) {
        this.userRepository = userRepository;
        this.bCryptEncoder = bCryptEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles;

        User user = userRepository.findByUsername(username);
        if(user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        }
        throw new UsernameNotFoundException("User not found with the name: "+username);
    }

    public User save(User user) {
        try {
           User newUser = new User();
           newUser.setUsername(user.getUsername());
           newUser.setPassword(bCryptEncoder.encode(user.getPassword()));
           newUser.setDateOfBirth(user.getDateOfBirth());
           newUser.setRole(user.getRole());
           return userRepository.save(newUser);
        } catch (Exception e) {
            throw new UserAlreadyExistsException("User with username:"+user.getUsername()+ " already exists.");
        }
    }


}
