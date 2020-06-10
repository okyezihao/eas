package cn.yezihao.service.impl;

import cn.yezihao.entity.User;
import cn.yezihao.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    public User selectUserByName(String username) {

        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("038bdaf98f2037b31f1e75b5b4c9b26e");
        if (username.equals(user.getUsername())) {
            return user;
        } else {
            return null;
        }
    }

    public int updateUser(User user) {
        return 0;
    }


}
