package cn.edu.bit.repository;

import cn.edu.bit.model.LogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by chu on 2015/5/27.
 */
public interface LogEntityRepository extends PagingAndSortingRepository<LogEntity, Integer> {

    public Page<LogEntity> findByAddressAndType(int address, String type, Pageable pageable);

    public Page<LogEntity> findByAddress(int address, Pageable pageable);

    public Page<LogEntity> findByType(String type, Pageable pageable);


}
