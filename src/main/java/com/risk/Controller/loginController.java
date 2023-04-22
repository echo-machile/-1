package com.risk.Controller;

import com.risk.Service.UserService;
import com.risk.entity.User;
import com.risk.untils.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class loginController {

    User user = new User();
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public Res getList(@RequestBody Map<String,String> map){
        System.out.println(map);
        String name = map.get("username");
        String passwd = map.get("password");
        String corr = userService.getPasswordByName(name);
        System.out.println(passwd);
        System.out.println(corr);
        if (passwd.equals(corr) ){

            user = userService.getUserByName(name);
            return Res.ok(user);
        }else {
            return Res.error("用户名或者密码错误!!!");
        }
    }

    @GetMapping("/currentUser")
    public Res getCurrentUser(){
        return Res.ok(this.user);
    }

}
