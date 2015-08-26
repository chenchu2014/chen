package cn.edu.bit.controller;

import cn.edu.bit.model.MyUserEntity;
import cn.edu.bit.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 初 on 2015/8/22.
 */

@Controller
public class UserManagerController {

    @Autowired
    private Md5PasswordEncoder md5Encoder;

    @Autowired
    private MyUserRepository myUserRepository;

    @RequestMapping(value = "/modifyPassword.do", method = RequestMethod.POST)
    public ModelAndView modifyPassword(String oldPassword, String newPassword, HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (!userDetails.getPassword().equals(md5Encoder.encodePassword(oldPassword, null))) {
            modelAndView.addObject("result", "旧密码错误");
        } else {
            modelAndView.addObject("result", "密码修改成功");
            myUserRepository.modifyPassword(userDetails.getUsername(), md5Encoder.encodePassword(newPassword, null));
        }
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext()
                .getAuthentication());
        modelAndView.setViewName("template/user-manager/modify-password-result");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = "/admin/addUser.do", method = RequestMethod.POST)
    public String modifyPassword(String username, String password) {
        MyUserEntity myUserEntity = new MyUserEntity();
        myUserEntity.setUsername(username);
        myUserEntity.setPassword(md5Encoder.encodePassword(password, null));
        myUserEntity.setRole("ROLE_USER");

        myUserRepository.save(myUserEntity);

        return "{}";
    }

    @ResponseBody
    @RequestMapping(value = "/admin/removeUser.do", method = RequestMethod.POST)
    public String removeUser(String username) {
        myUserRepository.deleteByUsername(username);
        return "{}";
    }
}
