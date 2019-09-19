package com.example.demo.repo.dbsimakbmn;

import com.example.demo.domain.dbsimakbmn.MasterBmnEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class MasterBmnRepoImpl implements IMasterBmnRepo, JpaRepository<MasterBmnEntity, BigDecimal> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getBarangByKondisiAndStatus() {
        String s = "SELECT \n" +
                "    a.*, b.sts_barang, b.Kondisi kondisi_db_penari\n" +
                "FROM\n" +
                "    db_simak_bmn.master_bmn a\n" +
                "        JOIN\n" +
                "    db_penari_desa.status_barang b ON a.id = b.id_barang\n" +
                "WHERE\n" +
                "    a.Kondisi = '0' AND b.sts_barang = '1'";
        Query query = entityManager.createNativeQuery(s);
        return query.getResultList();
    }

    @Override
    public List<MasterBmnEntity> findAll() {
        return null;
    }

    @Override
    public List<MasterBmnEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<MasterBmnEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<MasterBmnEntity> findAllById(Iterable<BigDecimal> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(BigDecimal bigDecimal) {

    }

    @Override
    public void delete(MasterBmnEntity masterBmnEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends MasterBmnEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends MasterBmnEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends MasterBmnEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<MasterBmnEntity> findById(BigDecimal bigDecimal) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(BigDecimal bigDecimal) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends MasterBmnEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<MasterBmnEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public MasterBmnEntity getOne(BigDecimal bigDecimal) {
        return null;
    }

    @Override
    public <S extends MasterBmnEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends MasterBmnEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends MasterBmnEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends MasterBmnEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends MasterBmnEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends MasterBmnEntity> boolean exists(Example<S> example) {
        return false;
    }
}
