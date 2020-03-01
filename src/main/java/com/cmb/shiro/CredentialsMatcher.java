package com.cmb.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.util.SimpleByteSource;

/**
 * 自定义凭证(密码)匹配器
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        // 对前台传入的明文数据加密，根据自定义加密规则加密
        Object tokencredential = new SimpleByteSource((char[]) token.getCredentials());
        // 从数据库获取的加密数据
        Object accunt = new SimpleByteSource((char[]) info.getCredentials());
        // 返回对比结果
        return equals(accunt, tokencredential);
    }
}
