package com.coderscampus.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coderscampus.security.Authorities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"authorities", "toDos"})
public class User
{
  private Long id;
  private String username;
  private String password;
  private Set<Authorities> authorities = new HashSet<Authorities>();
  private Set<ToDo> toDos = new TreeSet<ToDo>();
  
  public User() {}
  
  public User(User user)
  {
    this.id = user.id;
    this.username = user.username;
    this.authorities = user.authorities;
    this.password = user.password;
    this.toDos = user.toDos;
  }
  
  @Id
  @GeneratedValue
  public Long getId()
  {
    return id;
  }
  public void setId(Long id)
  {
    this.id = id;
  }
  public String getUsername()
  {
    return username;
  }
  public void setUsername(String username)
  {
    this.username = username;
  }
  public String getPassword()
  {
    return password;
  }
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
  public Set<Authorities> getAuthorities()
  {
    return authorities;
  }
  public void setAuthorities(Set<Authorities> authorities)
  {
    this.authorities = authorities;
  }
  
  @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
  public Set<ToDo> getToDos()
  {
    return toDos;
  }
  public void setToDos(Set<ToDo> toDos)
  {
    this.toDos = toDos;
  }
  
  
}
