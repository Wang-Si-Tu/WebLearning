package com.test.Service;

import com.test.Dao.UsersRepository;
import com.test.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public String login(Users user) {
        //System.out.println(user.getAccount()+" "+user.getPassword());
        Users queryResult=usersRepository.findByAccount(user.getAccount());
        System.out.println(queryResult.getAccount()+" "+queryResult.getPassword());
        if(queryResult==null){
            return "Fail";
        }
        else{
            if(queryResult.getPassword().equals(user.getPassword())) return "Success";
            return "Fail";
        }
    }
}
