package com.coderscampus.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.coderscampus.domain.ToDo;
import com.coderscampus.domain.User;

public class CustomSpringUser extends User implements UserDetails
{
  private static final long serialVersionUID = 4914759309490328945L;

  public CustomSpringUser () {}
  
  public CustomSpringUser (User user) 
  {
    super(user);
  }
  
  @Override
  public Set<ToDo> getToDos()
  {
    return super.getToDos();
  }
  
  @Override
  public Set<Authorities> getAuthorities()
  {
    return super.getAuthorities();
  }
  
  @Override
  public String getPassword()
  {
    return super.getPassword();
  }
  
  @Override
  public String getUsername()
  {
    return super.getUsername();
  }
  
  @Override
  public boolean isAccountNonExpired()
  {
    return true;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return true;
  }

  @Override
  public boolean isEnabled()
  {
    return true;
  }

}
