package com.posdataservice.payload;


import java.util.Set;



import com.posdataservice.model.Role;

import lombok.Data;


@Data
public class SignupRequest {
//    @NotBlank
    private String username;
 
//    @NotBlank
//    @Size(max = 50)
//    @Email
    private String email;
    
    private Set<Role> roles;
    
//    @NotBlank
//    @Size(min = 6, max = 40)
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<Role> getRoles() {
      return this.roles;
    }
    
    public void setRole(Set<Role> roles) {
      this.roles = roles;
    }
}