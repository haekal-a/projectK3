package com.example.demo.repo.dbsimakbmn;

import com.example.demo.domain.dbsimakbmn.MasterBmnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Repository
@Transactional
public interface IMasterBmnRepo extends  JpaRepository<MasterBmnEntity, BigDecimal> {
}
