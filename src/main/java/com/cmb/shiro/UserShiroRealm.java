package com.cmb.shiro;

import com.cmb.entity.User;
import com.cmb.exception.BusinessException;
import com.cmb.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iuserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        if(username == null) {
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();
        Set<String> stringPermissions = new HashSet<String>();
        roles.add("USER");
        stringPermissions.add("USER:DELETE");//角色:权限

        info.setRoles(roles);//角色可以通过数据库查询得到
        info.setStringPermissions(stringPermissions);//权限可以通过数据库查询得到

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken autToken) throws AuthenticationException {

        UsernamePasswordToken userPwdToken = (UsernamePasswordToken) autToken;
        String userName = userPwdToken.getUsername();

        User user = iuserService.selectUserByUserName(userName);
        if (null == user) {
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),
                user.getPassword().toCharArray(), getName());

        return authenticationInfo;
    }
}
