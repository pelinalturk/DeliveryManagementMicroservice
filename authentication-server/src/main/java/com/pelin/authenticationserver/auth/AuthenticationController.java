package com.pelin.authenticationserver.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register/admin")
    @PreAuthorize("ADMIN")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerAdmin(request));
    }

    @PostMapping("/register/sender")
    @PreAuthorize("SENDER")
    public ResponseEntity<AuthenticationResponse> registerSender(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerSender(request));
    }

    @PostMapping("/register/recipient")
    public ResponseEntity<AuthenticationResponse> registerRecipient(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authenticationService.registerRecipient(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
