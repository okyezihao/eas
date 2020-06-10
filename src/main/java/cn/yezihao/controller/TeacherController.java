package cn.yezihao.controller;

import cn.yezihao.entity.Teacher;
import cn.yezihao.service.impl.TeacherServiceImpl;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teacherService;

    @GetMapping("/teacher")
    @ResponseBody
    public LayuiTypeJson<Teacher> findAllTeacher() {
        return teacherService.teacherList();
    }

    @GetMapping("/toAddTcher")
    public String toAddTcher() {
        return "admin/teach/teachAdd";
    }

    @PostMapping("/addTeacher")
    @ResponseBody
    public int addTeacher(Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @GetMapping("/toUpdateTcher/{Tno}")
    public String toUpdateTcher(@PathVariable("Tno") Integer Tno, Model model) {
        Teacher teacher = teacherService.selectTcherById(Tno);
        model.addAttribute("tcher",teacher);
        return "admin/teach/teachUpdate";
    }

    @PostMapping("/updateTeacher")
    @ResponseBody
    public int updateTeacher(Teacher teacher) {
        return teacherService.updateTeacher(teacher);
    }    // 弹出层 提交 更新谜语表单

    @PostMapping("/delTeacher/{Tno}")
    @ResponseBody
    public void delTeacher(@PathVariable("Tno") Integer Tno) {
        teacherService.deleteTeacher(Tno);
    }

    // 删除多行数据 返回json字符串
    @PostMapping("/delManyTcher")
    @ResponseBody
    public int delManyTcher(@RequestParam("tno[]") String[] tno) {
        return teacherService.delManyTcher(tno);
    }

    // 谜语 模糊查询
    @PostMapping("/select")
    @ResponseBody
    public LayuiTypeJson<Teacher> selectBySearch(@RequestParam("search") String search) {
        return teacherService.selectBySearch(search);
    }

}
