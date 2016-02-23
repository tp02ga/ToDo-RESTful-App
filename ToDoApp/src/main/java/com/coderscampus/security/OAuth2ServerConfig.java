package com.coderscampus.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
public class OAuth2ServerConfig
{
  
  @Configuration
  @EnableResourceServer
  protected static class ResourceServer extends ResourceServerConfigurerAdapter
  {
    private static final String TODO_APP = "todo-app";

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
      http.authorizeRequests().antMatchers("/todo/api").access("#oauth2.hasScope('read')");
    }
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception
    {
      resources.resourceId(TODO_APP);
    }
  }
  
  @Configuration
  @EnableAuthorizationServer
  protected static class AuthorizationServer extends AuthorizationServerConfigurerAdapter
  {
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception
    {
      clients
        .inMemory()
          .withClient("my-app-name")
          .resourceIds(ResourceServer.TODO_APP)
          .authorizedGrantTypes("client_credentials")
          .scopes("read", "write", "dogPoop")
          .secret("2387sk3sdjk3!");
    }
  }
}
