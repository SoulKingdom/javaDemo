//package com.example.junittest.service.impl;
//
//import com.example.junittest.entity.SysRole;
//import com.example.junittest.entity.SysUser;
//import com.example.junittest.entity.SysUserRole;
//import com.example.junittest.service.SysRoleService;
//import com.example.junittest.service.SysUserRoleService;
//import com.example.junittest.service.SysUserService;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//*
// *  @dept 上海软件研发中心
// *  @description TODO
// *  @author HaoXin.Liu
// *  @date 2019/10/18 15:20
// *
//
//@Service("userDetailsService")
//public class CustomUserDetailsService implements UserDetailsService {
//    @Resource
//    private SysUserService userService;
//
//    @Resource
//    private SysRoleService roleService;
//
//    @Resource
//    private SysUserRoleService userRoleService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        // 从数据库中取出用户信息
//        SysUser user = userService.selectByName(username);
//
//        // 判断用户是否存在
//        if(user == null) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//
//        // 添加权限
//        List<SysUserRole> userRoles = userRoleService.listByUserId(user.getId());
//        for (SysUserRole userRole : userRoles) {
//            SysRole role = roleService.selectById(userRole.getRoleId());
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        // 返回UserDetails实现类
//        return new User(user.getName(), user.getPassword(), authorities);
//    }
//}
