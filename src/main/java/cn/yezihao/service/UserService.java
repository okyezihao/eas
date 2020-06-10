package cn.yezihao.service;

import cn.yezihao.entity.User;

public interface UserService {

    User selectUserByName(String username);

    int updateUser(User user);
}
