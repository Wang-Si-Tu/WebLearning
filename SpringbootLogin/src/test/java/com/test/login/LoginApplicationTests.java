package com.test.login;

import com.test.Dao.UsersRepository;

import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class LoginApplicationTests {

    @Autowired
    private UsersRepository usersRepository;
    @Test
    void contextLoads() {
        //System.out.println(usersRepository.findByAccount("David").getPassword());
        System.out.println(usersRepository.findByAccount("David"));
    }

}
