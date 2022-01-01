package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		List<User> usersList = userRepository.findUser(userName);

		if (usersList != null && usersList.size() == 1) {
			User users = usersList.get(0);

			List<String> roleList = new ArrayList<String>();
			for (Role role : users.getRoles()) {
				roleList.add(role.getRoleName());
			}

            return User.builder()
                	.username(users.getUsername())
                	//change here to store encoded password in db
                	.password( bCryptPasswordEncoder.encode(users.getPassword()) )
                	.roles(roleList.toArray(new String[0]))
                	.build();
		} else {
			throw new UsernameNotFoundException("User Name is not Found");
		}
	}
}
