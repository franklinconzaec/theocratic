package com.franklinconza.theocratic.security.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFindResponseRepository userFindResponseRepository;

    public List<UserFindResponse> findUserByRole(int roleId) {
        return userFindResponseRepository.findUserByRol(roleId);
    }
}
