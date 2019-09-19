package com.example.demo.repo.dbsimakbmn;

import com.example.demo.domain.dbsimakbmn.MasterBmnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface IMasterBmnRepo {

    List<Object[]> getBarangByKondisiAndStatus();
}
