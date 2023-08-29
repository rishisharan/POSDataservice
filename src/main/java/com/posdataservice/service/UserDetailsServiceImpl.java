package com.posdataservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.posdataservice.model.Users;
import com.posdataservice.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepository.findUserByUsername(userName);
        return UserDetailsImpl.build(user);
    }
	 
	 
}