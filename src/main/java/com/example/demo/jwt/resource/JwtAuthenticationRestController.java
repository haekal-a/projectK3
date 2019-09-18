package com.example.demo.jwt.resource;

import com.example.demo.domain.dbpenaridesa.UserEntity;
import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.jwt.JwtUserDetails;
import com.example.demo.model.CommonResponseModel;
import com.example.demo.model.PegawaiOutputModel;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserOutputModel;
import com.example.demo.service.PegawaiService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class JwtAuthenticationRestController {

    @Value("${jwt.http.request.header}")
    private String tokenHeader;

    private final UserService userService;
    private final PegawaiService pegawaiService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService jwtInMemoryUserDetailsService;
    private final PasswordEncoder bcryptEncoder;

    @Autowired
    public JwtAuthenticationRestController(UserService userService, PegawaiService pegawaiService, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserDetailsService jwtInMemoryUserDetailsService, PasswordEncoder bcryptEncoder) {
        this.userService = userService;
        this.pegawaiService = pegawaiService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtInMemoryUserDetailsService = jwtInMemoryUserDetailsService;
        this.bcryptEncoder = bcryptEncoder;
    }

    @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtTokenRequest authenticationRequest)
            throws AuthenticationException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtTokenResponse(token, userDetails));
    }

    @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) jwtInMemoryUserDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token)) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtTokenResponse(refreshedToken, user));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // untuk insert data baru
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserModel user) throws Exception {

        // cek akun user
        UserOutputModel output = userService.getUser(user.getUsername());
        if (output.getUsername() == null) {

            // cek validasi nip
            PegawaiOutputModel pegawai = pegawaiService.getDataPegawai(user.getUsername());
            if (pegawai.getNip() != null) {

                UserEntity newUser = new UserEntity();
                newUser.setUsername(user.getUsername());
                newUser.setPassword(bcryptEncoder.encode(user.getPassword()));

                if (pegawai.getSeksi().equals("Kepegawaian dan Umum")) {
                    newUser.setRole("admin");
                } else {
                    newUser.setRole("user");
                }

                return ResponseEntity.ok(new CommonResponseModel("Sukses", "0", null, userService.saveUser(newUser)));
            } else {
                return ResponseEntity.ok(new CommonResponseModel("Gagal", "1", "Data nip tidak valid", null));
            }
        } else {
            return ResponseEntity.ok(new CommonResponseModel("Gagal", "1", "Data sudah ada", null));
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }
}
