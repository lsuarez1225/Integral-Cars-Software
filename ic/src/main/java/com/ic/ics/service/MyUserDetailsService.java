package com.ic.ics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ic.ics.model.Authority;
import com.ic.ics.model.User;
import com.ic.ics.repository.UserRepository;
import com.ic.ics.util.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	
		//Optional<User> user = userRepository.findByUsername(userName);
		//return new MyUserDetails(user);
		
		// Busca el usuario con el repositorio y si no existe lanza una excepción.
		User appUser = userRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException("No existe el usuario"));
		
		List grantList = new ArrayList();
		for (Authority authority: appUser.getAuthority()) {
			// ROLE_USER, ROLE_ADMIN
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantList.add(grantedAuthority);
		}
		
		UserDetails user = (UserDetails) new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), grantList);
	
		return user;
	}
}
