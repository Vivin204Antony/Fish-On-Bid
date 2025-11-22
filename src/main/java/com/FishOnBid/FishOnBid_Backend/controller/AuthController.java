package com.FishOnBid.FishOnBid_Backend.controller;

import com.FishOnBid.FishOnBid_Backend.entity.User;
import com.FishOnBid.FishOnBid_Backend.repository.UserRepository;
import com.FishOnBid.FishOnBid_Backend.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User exists = userRepository.findByEmail(user.getEmail());

        if (exists == null || !exists.getPassword().equals(user.getPassword())) {
            return "Invalid credentials";
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}
