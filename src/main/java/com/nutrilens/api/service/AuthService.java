package com.nutrilens.api.service;

import com.nutrilens.api.dto.request.LoginRequestDTO;
import com.nutrilens.api.dto.request.RegisterRequestDTO;
import com.nutrilens.api.dto.response.AuthResponseDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO request);
    AuthResponseDTO register(RegisterRequestDTO request);
    AuthResponseDTO getCurrentUser(String username);
}
