package cn.yezihao.controller;

import cn.yezihao.entity.User;
import cn.yezihao.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/updateUser")
    @ResponseBody
    public int updateUser(User user) {
        ByteSource salt = ByteSource.Util.bytes(user.getUsername());
        String md5 = new SimpleHash("md5", user.getPassword(), salt, 1024).toHex();
        user.setPassword(md5);

        User user1 = userService.selectUserByName(user.getUsername());
        if (!user1.getPassword().equals(user.getPassword())) {
            userService.updateUser(user);
            return 200;
        }
        return 404;
    }

}
