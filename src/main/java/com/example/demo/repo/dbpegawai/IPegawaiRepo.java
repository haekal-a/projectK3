package com.example.demo.repo.dbpegawai;

import com.example.demo.domain.dbpegawai.PegawaiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IPegawaiRepo extends JpaRepository<PegawaiEntity, String> {
    PegawaiEntity findByNip (String nip);
}
