package com.eval.coronakit.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.UserRepository;



@Service
	public class UserDetailsServiceImpl implements UserDetailsService{
	    @Autowired
	    private PasswordEncoder pEnc;
	    
	    @Autowired
	    private UserRepository userRepo; 
	    
	   
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        UserDetails userDetails;
	        com.eval.coronakit.entity.User user = userRepo.findByUsername(username);
	        
	        if(user==null) {
	            throw new UsernameNotFoundException("No Such User Found  ");
	        }
	        
	        List<GrantedAuthority> authorities= new ArrayList<>();
	        authorities.add(new SimpleGrantedAuthority(user.getRole()));
	        
	        
	        userDetails = (UserDetails) new User(
	                user.getUsername(),
	                user.getEncodedPassword(),
	                authorities);
	        
	        
	        return userDetails;
	    }
	    public com.eval.coronakit.entity.User save(com.eval.coronakit.entity.User user) {
	        ((com.eval.coronakit.entity.User) user).setEncodedPassword(pEnc.encode(user.getPassword()));
	        return userRepo.save(user);
	    } 
	}

