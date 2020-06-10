package cn.yezihao.controller;

import cn.yezihao.entity.Teacher;
import cn.yezihao.entity.Teaching;
import cn.yezihao.service.impl.TeachingServiceImpl;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class TeachingController {

    @Autowired
    private TeachingServiceImpl teachingService;

    @GetMapping("/teaching")
    @ResponseBody
    public LayuiTypeJson<Teaching> findAllTeaching(){
        System.out.println(teachingService.findAllTeaching());
        return teachingService.teachingList();
    }

    @GetMapping("/toAddTching")
    public String toAddTching() {
        return "admin/teaching/teachingAdd";
    }

    @GetMapping("/toUpdateTching")
    public String toUpdateTching() {
        return "admin/teaching/teachingUpdate";
    }

    @GetMapping("/toDeleteTching")
    public String delTeaching() {
        return "admin/teaching/teachingDelete";
    }

    @PostMapping("/selectT")
    @ResponseBody
    public LayuiTypeJson<Teacher> selectBySearch(@RequestParam("search") String search) {
        return teachingService.selectBySearch(search);
    }



}
