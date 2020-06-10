package cn.yezihao.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping({"/toLogin", "/"})
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model) {

        Subject subject = SecurityUtils.getSubject();

        ByteSource salt = ByteSource.Util.bytes(username);
        String md5 = new SimpleHash("md5", password, salt, 1024).toHex();
        UsernamePasswordToken token = new UsernamePasswordToken(username, md5);
        try {
            subject.login(token);
            System.out.println("用户登录=>[" + username + "]");
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            session.setAttribute("loginUser", token.getUsername());
            return "redirect:/admin/toTeach";
        } catch (UnknownAccountException e) { // 用户名不存在
            model.addAttribute("msg", "用户名错误！");
            return "login";
        } catch (IncorrectCredentialsException e) { // 密码不存在
            model.addAttribute("msg2", "密码错误!");
            return "login";
        }

    }

    // 注销
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        Subject currentSubject = SecurityUtils.getSubject();
        System.out.println("用户注销=>[" + currentSubject.getSession() + "]");
        currentSubject.logout();
        session.removeAttribute("loginUser");
        return "login";
    }

    // 未授权页面
    @GetMapping("/noAuth")
    public String unAuthorized() {
        return "error/noAuth";
    }

}
