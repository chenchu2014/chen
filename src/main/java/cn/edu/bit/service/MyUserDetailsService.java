package cn.edu.bit.service;

import cn.edu.bit.model.MyUserEntity;
import cn.edu.bit.model.MyUserProxy;
import cn.edu.bit.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        MyUserEntity myUserEntity = myUserRepository.findOne(username);
        if (myUserEntity == null)
            return null;
        return new MyUserProxy(myUserEntity);
    }
}
