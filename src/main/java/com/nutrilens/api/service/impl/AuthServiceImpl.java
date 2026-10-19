package com.nutrilens.api.service.impl;

import com.nutrilens.api.dto.request.LoginRequestDTO;
import com.nutrilens.api.dto.request.RegisterRequestDTO;
import com.nutrilens.api.dto.response.AuthResponseDTO;
import com.nutrilens.api.entity.User;
import com.nutrilens.api.exception.EntityNotFoundException;
import com.nutrilens.api.repository.UserRepository;
import com.nutrilens.api.security.JwtTokenProvider;
import com.nutrilens.api.service.AuthService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AuthServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostConstruct
    public void seedInitialUsers() {
        if (!userRepository.existsByUsername("admin")) {
            User admin = User.builder()
                    .username("admin")
                    .email("admin@nutrilens.com")
                    .passwordHash(passwordEncoder.encode("admin123"))
                    .fullName("NutriLens System Admin")
                    .weightKg(new BigDecimal("70.00"))
                    .heightCm(new BigDecimal("175.00"))
                    .role("ROLE_ADMIN")
                    .isActive(true)
                    .build();
            userRepository.save(admin);
            log.info("Initialized default admin user: admin / admin123");
        }

        if (!userRepository.existsByUsername("user1")) {
            User user1 = User.builder()
                    .username("user1")
                    .email("user1@nutrilens.com")
                    .passwordHash(passwordEncoder.encode("user123"))
                    .fullName("Nguyễn Văn An (Mobile User)")
                    .weightKg(new BigDecimal("65.00"))
                    .heightCm(new BigDecimal("170.00"))
                    .role("ROLE_USER")
                    .isActive(true)
                    .build();
            userRepository.save(user1);
            log.info("Initialized default mobile AR user: user1 / user123");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public AuthResponseDTO login(LoginRequestDTO request) {
        User user = userRepository.findByUsernameAndIsActiveTrue(request.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found or account inactive: " + request.getUsername()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid password credentials");
        }

        String token = jwtTokenProvider.generateToken(user.getUsername());

        return AuthResponseDTO.builder()
                .token(token)
                .tokenType("Bearer")
                .userId(user.getId())
                .username(user.getUsername())
                .fullName(user.getFullName())
                .role(user.getRole())
                .weightKg(user.getWeightKg())
                .build();
    }

    @Override
    @Transactional
    public AuthResponseDTO register(RegisterRequestDTO request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username is already taken");
        }
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email is already registered");
        }

        User newUser = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .fullName(request.getFullName())
                .weightKg(request.getWeightKg() != null ? request.getWeightKg() : new BigDecimal("65.00"))
                .role("ROLE_USER")
                .isActive(true)
                .build();

        User savedUser = userRepository.save(newUser);
        String token = jwtTokenProvider.generateToken(savedUser.getUsername());

        return AuthResponseDTO.builder()
                .token(token)
                .tokenType("Bearer")
                .userId(savedUser.getId())
                .username(savedUser.getUsername())
                .fullName(savedUser.getFullName())
                .role(savedUser.getRole())
                .weightKg(savedUser.getWeightKg())
                .build();
    }
}
