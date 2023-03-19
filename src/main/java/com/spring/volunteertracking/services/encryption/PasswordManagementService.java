package com.spring.volunteertracking.services.encryption;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordManagementService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public PasswordManagementService() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public String hashPassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }
}
