package com.pelin.authenticationserver.auth;

import com.pelin.authenticationserver.config.JwtService;
import com.pelin.authenticationserver.model.Role;
import com.pelin.authenticationserver.model.User;
import com.pelin.authenticationserver.model.builder.UserBuilder;
import com.pelin.authenticationserver.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }
    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var user = register(request)
                .role(Role.ADMIN)
                .build();
        userRepository.save(user);
        return getAuthenticationResponse(user);
    }

    public AuthenticationResponse registerSender(RegisterRequest request) {
        var user =register(request)
                .role(Role.SENDER)
                .build();
        userRepository.save(user);
        return getAuthenticationResponse(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
         authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(
                         request.getEmail(),
                         request.getPassword()
                 )
         );
         var user = userRepository.findByEmail(request.getEmail())
                 .orElseThrow();
        return getAuthenticationResponse(user);
    }
    public AuthenticationResponse registerRecipient(RegisterRequest request) {
        var user =register(request)
                .role(Role.RECIPIENT)
                .build();
        userRepository.save(user);
        return getAuthenticationResponse(user);
    }

    private UserBuilder register(RegisterRequest request){
        return new UserBuilder().firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()));

    }
    private AuthenticationResponse getAuthenticationResponse(User user) {
        var jwtToken = jwtService.generateToken(user);
        return  AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
