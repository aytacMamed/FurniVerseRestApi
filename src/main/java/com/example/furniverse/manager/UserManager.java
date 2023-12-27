package com.example.furniverse.manager;

import com.example.furniverse.dto.RegisterRequest;
import com.example.furniverse.dto.UserDTO;
import com.example.furniverse.entity.Role;
import com.example.furniverse.entity.User;
import com.example.furniverse.mapper.UserMapper;
import com.example.furniverse.repository.UserRepository;
import com.example.furniverse.security.JwtService;
import com.example.furniverse.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    UserDetailsService authService;

private final UserMapper userMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserManager(UserRepository userRepository,
                       PasswordEncoder passwordEncoder, UserMapper userMapper, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Override
    public void saveUser(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return null;
    }

    @Override
    public void register(RegisterRequest request) {

        User user = User
                .builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
    }

    @Override
    public String login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        UserDetails user = userMapper.toMyUserDetails(findUserByEmail(request.email()));

        return jwtService.generateToken(user);
    }


}
