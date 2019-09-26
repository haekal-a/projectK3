package com.example.demo.jwt;

//import com.example.demo.domain.UserInfo;

import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.model.PegawaiOutputModel;
import com.example.demo.repo.dbpenaridesa.IUserRepo;
import com.example.demo.service.PegawaiService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    private IUserRepo userRepo;
    private PegawaiService pegawaiService;
    private UserService userService;

    @Autowired
    public JwtInMemoryUserDetailsService(IUserRepo userRepo, PegawaiService pegawaiService, UserService userService) {
        this.userRepo = userRepo;
        this.pegawaiService = pegawaiService;
        this.userService = userService;
    }

    // code ini menggunakan nama user dari database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, BadCredentialsException {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        PegawaiOutputModel pegawai = pegawaiService.getDataPegawai(username);

        // cek role
        if (user.getRole().equals("admin") && !pegawai.getSeksi().equals("Kepegawaian dan Umum")) {
            user.setRole("user");
            userService.saveUser(user);
        } else if (user.getRole().equals("user") && pegawai.getSeksi().equals("Kepegawaian dan Umum")) {
            user.setRole("admin");
            userService.saveUser(user);
        }

        return new JwtUserDetails(user.getUsername(), user.getPassword(), user.getRole(), pegawai);
    }

}


