package com.example.demo.repo;

import com.example.demo.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Reza Pahlevie on 31/08/2019.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);

}
