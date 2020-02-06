package com.zingmp3.service.user;

import com.zingmp3.model.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    void saveUser(User user);
}
