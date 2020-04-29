package com.test.Controller;

import com.test.Entity.Users;
import com.test.Service.AccountService;
import com.test.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value="/api")
public class UserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody Users user){
        //System.out.println(user.getAccount()+" "+user.getPassword());
        return loginService.login(user);
    }

    @CrossOrigin
    @RequestMapping(value="/getAccount",method=RequestMethod.POST)
    @ResponseBody
    public List<Users> getAccount(){
        //System.out.println(user.getAccount()+" "+user.getPassword());
//        for(Users user:getAccountService.getAccount()){
//            System.out.println(user.getAccount());
//            System.out.println(user.getPassword());
//        }
        return accountService.getAccount();
    }

    @CrossOrigin
    @RequestMapping(value="/deleteAccount",method=RequestMethod.POST)
    @ResponseBody
    public String deleteAccount(@RequestBody Users user){
        System.out.println(user.getAccount());
        System.out.println(user.getPassword());
        try{
            accountService.deleteAccount(user.getAccount());
            return "Success";
        }
        catch (Exception e){
            return "Fail";
        }
    }

    @CrossOrigin
    @RequestMapping(value="/addAccount",method=RequestMethod.POST)
    @ResponseBody
    public String addAccount(@RequestBody Users user){
        System.out.println(user.getAccount());
        System.out.println(user.getPassword());
        try{
            accountService.addAccount(user);
            return "Success";
        }
        catch (Exception e){
            return "Fail";
        }
    }
}
