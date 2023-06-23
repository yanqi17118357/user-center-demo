package com.usercenterbackend.service;

import com.usercenterbackend.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;


    @Test
    public void userAddTest() {

        User user = new User();
        user.setUsername("dog");
        user.setUserAccount("111");
        user.setAvatarUrl("https://npm.elemecdn.com/yanqi1711-picx@1.0.11/img/me.webp");
        user.setGender(0);
        user.setUserPassword("222");
        user.setPhone("333");
        user.setEmail("444");

        boolean result = userService.save(user);

        System.out.println(user.getId());

        Assertions.assertTrue(result);


    }

    @Test
    void userRegister() {

        // 密码为空
        String userAccount = "dog123";
        String userPassword = "";
        String checkPassword = "12345678";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 账户小于4位
        userAccount = "yan";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 密码小于8位
        userAccount = "dog123";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 账户包含特殊字符
        userAccount = "dog 123";
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 密码与校验密码不符
        userAccount = "dog123";
        userPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 用户名重复
        userPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        // 正常通过
        userAccount = "doge";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result>0);

    }

}
