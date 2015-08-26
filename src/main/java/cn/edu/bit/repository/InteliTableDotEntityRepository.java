package cn.edu.bit.repository;

import cn.edu.bit.model.Ade7758DotEntity;
import cn.edu.bit.model.InteliTableDotEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 初 on 2015/8/20.
 */
public interface InteliTableDotEntityRepository extends JpaRepository<InteliTableDotEntity, Integer> {

    public Page<InteliTableDotEntity> findByAddress(int address,Pageable pageable);
}
