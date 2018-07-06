//package ru.itpark.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//
//import javax.persistence.*;
//import java.util.Collection;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
////public class Account {
//public class Account implements UserDetails {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String username;
//    private String email;
//    private String password;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    private Collection<GrantedAuthority> authorities;
//    private boolean isAccountNonExpired;
//    private boolean isAccountNonLocked;
//    private boolean isCredentialsNonExpired;
//    private boolean isEnabled;
//
//}
