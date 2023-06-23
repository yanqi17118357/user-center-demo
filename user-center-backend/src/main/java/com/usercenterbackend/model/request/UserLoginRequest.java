package com.usercenterbackend.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求
 */
@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = 1748358001739473498L;

    private String userAccount;

    private String userPassword;
}
