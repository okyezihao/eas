package cn.yezihao.controller;

import cn.yezihao.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 教师信息
    @GetMapping("/toTeach")
    public String toTeach(){
        return "admin/teach";
    }


    // 授课信息
    @GetMapping("/toTeaching")
    public String toTeaching(){
        return "admin/teaching";
    }

    // 学籍处理
    @GetMapping("/toSsp")
    public String toSsp(){
        return "admin/ssp";
    }

    // 课程管理
    @GetMapping("/toCm")
    public String toCm(){
        return "admin/cm";
    }

    // 学生成绩
    @GetMapping("/toSg")
    public String toSg(){
        return "admin/sg";
    }

    // 管理员修改密码
    @GetMapping("/toSetting")
    public String toSetting(Model model){
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        model.addAttribute("User",user);
        return "admin/setting";
    }


}
