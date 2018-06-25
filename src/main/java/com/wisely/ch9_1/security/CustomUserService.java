package com.wisely.ch9_1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wisely.ch9_1.dao.SysUserRepository;
import com.wisely.ch9_1.domain.SysUser;

public class CustomUserService implements UserDetailsService { //1-实现这个用户安全管理接口
	@Autowired
	SysUserRepository userRepository;

	/**
	 * 重写这个方法获取用户
	 * @param username
	 * @return
     */
	@Override
	public UserDetails loadUserByUsername(String username) { //2
		
		SysUser user = userRepository.findByUsername(username); 
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return user; //3-获得用户
	}

}
