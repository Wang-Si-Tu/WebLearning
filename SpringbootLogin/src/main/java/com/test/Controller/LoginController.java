package com.test.Controller;

import com.test.Entity.Users;
import com.test.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @CrossOrigin
    @RequestMapping(value="/api/login",method=RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Users user){
        //System.out.println(user.getAccount()+" "+user.getPassword());
        return loginService.login(user);
    }
}
