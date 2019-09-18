package com.example.demo.repo.dbsimakbmn;

import com.example.demo.domain.dbsimakbmn.KodeBarangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface KodeBarangRepository extends JpaRepository<KodeBarangEntity, String> {
}
