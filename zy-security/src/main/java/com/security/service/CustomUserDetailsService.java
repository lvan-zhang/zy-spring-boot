package com.security.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

//    private final UserRepository userRepository;

//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        这里的userRepository就是数据库了，比如jpa或者MyBatis
//        Optional<User> user = userRepository.findByUsername(username);
        Optional<User> user = null;

        if (!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }

        User userEntity = user.get();
        return org.springframework.security.core.userdetails.User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities("USER") // 可以根据角色实现更复杂的逻辑
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!userEntity.isEnabled())
                .build();
    }
}
