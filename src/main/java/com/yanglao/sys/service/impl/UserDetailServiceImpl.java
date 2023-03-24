package com.yanglao.sys.service.impl;







import com.yanglao.sys.entity.SysUser;
import com.yanglao.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证校验的方法
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    ISysUserService UserService;


    /**
     * 完成账号的校验
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.需要根据账号查询
        List<SysUser> list = UserService.queryByUserName(username);
        if(list != null && list.size() == 1){
            // 账号是存在的
            SysUser SysUser= list.get(0);
            // 根据当前登录的账号查询到关联的角色信息
            List<GrantedAuthority> listRole = new ArrayList<>();
            if(SysUser.getAuthority() == null)
            {
                listRole.add(new SimpleGrantedAuthority("user"));
            }else{
                listRole.add(new SimpleGrantedAuthority(SysUser.getAuthority()));
            }


            // 密码模拟的是就数据库查询出来
            return new User(SysUser.getUserName(), SysUser.getUserPassword(),listRole);
        }
        return null;
    }
}
