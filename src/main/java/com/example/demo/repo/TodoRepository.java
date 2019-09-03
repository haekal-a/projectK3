package com.example.demo.repo;

import com.example.demo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface TodoRepository extends JpaRepository<Todo, BigDecimal> {

    List<Todo> getTodosByUsername (String username);


}
