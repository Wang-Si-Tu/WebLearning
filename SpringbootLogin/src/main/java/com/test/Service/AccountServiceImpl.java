package com.test.Service;

import com.test.Dao.UsersRepository;
import com.test.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<Users> getAccount() {
//        for(Users user:usersRepository.getAccount()){
//            System.out.println(user.getAccount());
//            System.out.println(user.getPassword());
//        }
        return usersRepository.getAccount();
    }

    @Override
    @Transactional
    public void deleteAccount(String account) {
        usersRepository.deleteByAccount(account);
    }

    @Override
    @Transactional
    public void addAccount(Users user) {
        usersRepository.addAccount(user.getAccount(),user.getPassword());
    }
}
