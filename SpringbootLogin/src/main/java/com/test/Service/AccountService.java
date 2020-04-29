package com.test.Service;

import com.test.Entity.Users;

import java.util.List;

public interface AccountService {
    public List<Users> getAccount();
    public void deleteAccount(String account);
    public void addAccount(Users user);
}
