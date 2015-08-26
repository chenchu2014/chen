package cn.edu.bit.repository;

import cn.edu.bit.model.MyUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chu on 2015/5/27.
 */
public interface MyUserRepository extends PagingAndSortingRepository<MyUserEntity, String> {

    @Transactional
    @Modifying
    @Query("update MyUserEntity set password =?2 where username=?1")
    public void modifyPassword(String username, String md5Password);

    public Page<MyUserEntity> findByRole(String role, Pageable pageable);

    @Transactional
    public void deleteByUsername(String username);
}
