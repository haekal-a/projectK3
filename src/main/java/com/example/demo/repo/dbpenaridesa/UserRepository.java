package com.example.demo.repo.dbpenaridesa;

import com.example.demo.domain.User;
import com.example.demo.domain.dbpenaridesa.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Reza Pahlevie on 31/08/2019.
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);

}
