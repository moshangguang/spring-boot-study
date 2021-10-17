package com.springboot;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthorizationTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
        simpleAccountRealm.addAccount("Fox", "123456", "admin");
    }

    @Test
    public void testAuthorization(){
        // 1.构建SecurityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        // realm 什么时候调，怎么判断的
        defaultSecurityManager.setRealm(simpleAccountRealm);

        //2. Subject提交认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("Fox","123456");
        // 比较用户信息，用户是否存在，密码是否正确
        // AuthenticatingRealm.doGetAuthenticationInfo  认证自定义逻辑 （扩展点）
        // spring security    UserDetailsService
        // AuthorizingRealm.doGetAuthorizationInfo   授权自定义逻辑
        subject.login(token);


        System.out.println(subject.isAuthenticated());

        //验证
        subject.checkRole("admin");
        //subject.checkRoles("admin","user");

    }
}
