package com.example.demo.repo.dbpenaridesa;

import com.example.demo.domain.dbpenaridesa.PeminjamanEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PeminjamanRepoCustomImpl implements IPeminjamanRepoCustom {
    @PersistenceContext
    private EntityManager entityManager;
}
