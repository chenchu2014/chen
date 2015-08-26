package cn.edu.bit.repository;

import cn.edu.bit.model.Ade7758ContinousEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 初 on 2015/8/20.
 */
public interface Ade7758ContinousEntityRepository extends JpaRepository<Ade7758ContinousEntity, Integer> {

    public Page<Ade7758ContinousEntity> findByAddressAndType(int address, String type, Pageable pageable);

    public Page<Ade7758ContinousEntity> findByAddress(int address, Pageable pageable);

    public Page<Ade7758ContinousEntity> findByType(String type, Pageable pageable);

    public Ade7758ContinousEntity findByAddressAndTimestrampAndType(int address, String timestramp, String type);
}
