package com.nutrilens.api.controller;

import com.nutrilens.api.dto.request.LoginRequestDTO;
import com.nutrilens.api.dto.request.RegisterRequestDTO;
import com.nutrilens.api.dto.response.AuthResponseDTO;
import com.nutrilens.api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        log.info("================================================================================");
        log.info(">>> [AUTH API] Incoming POST /api/v1/auth/login for username: '{}'", request.getUsername());
        AuthResponseDTO response = authService.login(request);
        log.info("<<< [AUTH API] LOGIN SUCCESS: user='{}', role='{}', tokenIssued=true", response.getUsername(), response.getRole());
        log.info("================================================================================");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        log.info("================================================================================");
        log.info(">>> [AUTH API] Incoming POST /api/v1/auth/register for user: '{}', email: '{}'", request.getUsername(), request.getEmail());
        AuthResponseDTO response = authService.register(request);
        log.info("<<< [AUTH API] REGISTER SUCCESS: user='{}', userId={}, role='{}'", response.getUsername(), response.getUserId(), response.getRole());
        log.info("================================================================================");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<AuthResponseDTO> getCurrentUser(java.security.Principal principal) {
        if (principal == null) {
            log.warn(">>> [AUTH API] GET /api/v1/auth/me called without authenticated Principal!");
            return ResponseEntity.status(org.springframework.http.HttpStatus.UNAUTHORIZED).build();
        }
        log.info(">>> [AUTH API] GET /api/v1/auth/me for principal: '{}'", principal.getName());
        return ResponseEntity.ok(authService.getCurrentUser(principal.getName()));
    }
}
