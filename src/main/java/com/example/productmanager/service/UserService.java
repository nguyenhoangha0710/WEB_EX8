package com.example.productmanager.service;

import com.example.productmanager.entity.User;
import com.example.productmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() { return userRepository.findAll(); }
    public Optional<User> findById(Long id) { return userRepository.findById(id); }
    public User save(User user) { return userRepository.save(user); }
    public void deleteById(Long id) { userRepository.deleteById(id); }
    public Optional<User> login(String email, String password) {
        return userRepository.findByEmail(email).filter(u -> u.getPassword().equals(password));
    }
    public boolean existsByEmail(String email) { return userRepository.existsByEmail(email); }
}


