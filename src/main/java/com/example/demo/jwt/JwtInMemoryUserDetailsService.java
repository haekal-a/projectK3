package com.example.demo.jwt;

//import com.example.demo.domain.UserInfo;

import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.model.PegawaiOutputModel;
import com.example.demo.repo.dbpenaridesa.IUserRepo;
import com.example.demo.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    public JwtInMemoryUserDetailsService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // code ini menggunakan nama user dari database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        PegawaiOutputModel pegawai = pegawaiService.getDataPegawai(username);
        return new JwtUserDetails(user.getUsername(), user.getPassword(), user.getRole(), pegawai);

    }

}


