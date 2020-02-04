package com.zingmp3.service.user;

import com.zingmp3.model.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByUsername(String username);
}
