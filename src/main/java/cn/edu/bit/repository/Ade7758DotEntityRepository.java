package cn.edu.bit.repository;

import cn.edu.bit.model.Ade7758DotEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 初 on 2015/8/20.
 */
public interface Ade7758DotEntityRepository extends JpaRepository<Ade7758DotEntity, Integer> {

    public Page<Ade7758DotEntity> findByAddress(int address,Pageable pageable);
}
