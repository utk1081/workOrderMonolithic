package de.gloresoft.workorderapi.controllers;

import de.gloresoft.workorderapi.config.JwtTokenUtil;
import de.gloresoft.workorderapi.converters.UserDtoToUser;
import de.gloresoft.workorderapi.entities.security.AuthenticationRequest;
import de.gloresoft.workorderapi.entities.security.AuthenticationResponse;
import de.gloresoft.workorderapi.entities.security.UserDto;
import de.gloresoft.workorderapi.services.security.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@CrossOrigin(origins = "${workorders.gui.application.url}")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final UserDtoToUser userDtoToUser;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsServiceImpl, UserDtoToUser userDtoToUser) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.userDtoToUser = userDtoToUser;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) throws Exception {
        return ResponseEntity.ok(userDetailsServiceImpl.save(userDtoToUser.convert(userDto)));
    }
}
