// package com.naoto.portfolio.app.service;

// import java.util.HashSet;
// import java.util.Set;


// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.naoto.portfolio.domain.todos.service.UserRepository;

// import lombok.RequiredArgsConstructor;

// @RequiredArgsConstructor
// @Service

// public class UseDetailsServiceImpl implements UserDetailsService {
//     private final UserRepository userRepository;

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        var user = this.userRepository.findByName(username);

//        if (user == null) {
//         throw new UsernameNotFoundException("User [" + username + "] not found.");
//        }
//        return createUser(user);
//     }

//     private UserDetails createUser(com.naoto.portfolio.domain.todos.model.User user) {
//         Set<GrantedAuthority> auth = new HashSet<>();
//         auth.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//         User userDetails = new User(user.getName(), user.getPassword(), auth);
//         return userDetails;
//     }

// }
