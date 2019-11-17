package com.codingParkFun.rmsbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codingParkFun.rmsbackend.model.UserDetail;
import com.codingParkFun.rmsbackend.model.UserRole;
import com.codingParkFun.rmsbackend.model.Users;
import com.codingParkFun.rmsbackend.repository.UserRepository;
import com.codingParkFun.rmsbackend.repository.UserRoleRepository;

@Service
public class UsersService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	private UserRoleRepository UserRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Users user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		List<UserRole> roles = UserRoleRepository.findByUserId(user.getId());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		for(UserRole role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
				
		return new User(user.getUsername(), user.getPassword(), authorities);
	}
	
	public UserDetail getUserByName(String username) {
		Users user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		List<UserRole> roles = UserRoleRepository.findByUserId(user.getId());
		
		return new UserDetail(user.getUsername(), user.getSchoolId(), roles.get(0).getRole());
	}

}
