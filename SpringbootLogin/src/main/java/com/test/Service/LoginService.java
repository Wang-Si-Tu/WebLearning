package com.test.Service;

import com.test.Entity.Users;
import org.springframework.stereotype.Service;

public interface LoginService {
    public String login(Users user);
}
