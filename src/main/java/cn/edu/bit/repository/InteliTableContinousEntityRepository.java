package cn.edu.bit.repository;

import cn.edu.bit.model.InteliTableContinousEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 初 on 2015/8/20.
 */
public interface InteliTableContinousEntityRepository extends JpaRepository<InteliTableContinousEntity, Integer> {

    public Page<InteliTableContinousEntity> findByAddressAndType(int address, String type, Pageable pageable);

    public Page<InteliTableContinousEntity> findByAddress(int address, Pageable pageable);

    public Page<InteliTableContinousEntity> findByType(String type, Pageable pageable);

    public InteliTableContinousEntity findByAddressAndTimestrampAndType(int address, String timestramp, String type);
}
