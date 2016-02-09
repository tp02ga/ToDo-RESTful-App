package com.coderscampus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.User;
import com.coderscampus.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{
  @Autowired
  private UserRepository userRepo;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
  {
    User user = userRepo.findByUsername(username);
    
    if (user == null)
      throw new UsernameNotFoundException("User with username: " + username + " not found");
    
    return new CustomSpringUser(user);
  }

}
