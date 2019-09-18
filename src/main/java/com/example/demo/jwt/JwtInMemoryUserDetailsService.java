package com.example.demo.jwt;

//import com.example.demo.domain.UserInfo;

import com.example.demo.domain.User;
import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.repo.dbpenaridesa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public JwtInMemoryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // kode ini menggunkanan nama user yg dihardcode diatas
  /*@Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }*/

    // code ini menggunakan nama user dari database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new JwtUserDetails(user.getUsername(), user.getPassword(), user.getRole());

        /*if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("UserInfo not found with username: " + username);
        }*/

        /*return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());*/

    }

}


