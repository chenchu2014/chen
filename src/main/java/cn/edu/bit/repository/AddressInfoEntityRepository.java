package cn.edu.bit.repository;

import cn.edu.bit.model.AddressInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 初 on 2015/5/31.
 */
public interface AddressInfoEntityRepository extends PagingAndSortingRepository<AddressInfoEntity, Integer> {

    public long countByAddress(int address);

    @Transactional
    @Modifying
    @Query("update AddressInfoEntity set lastTime=? ,version=? where address=?")
    public void refresh(String lastTime, String version, int address);

    @Query("select a from AddressInfoEntity a order by lastTime")
    public Page<AddressInfoEntity> findOrderByLastTimeDesc(Pageable pageable);

}
