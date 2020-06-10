package cn.yezihao.controller;

import cn.yezihao.entity.Student;
import cn.yezihao.service.impl.StudentServiceImpl;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/student")
    @ResponseBody
    public LayuiTypeJson<Student> findAllStudent() {
        return studentService.studentList();
    }

    @GetMapping("/toAddStudt")
    public String toAddStudt() {
        return "admin/studt/studtAdd";
    }

    @PostMapping("/addStudent")
    @ResponseBody
    public int addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/toUpdateStudt/{Sno}")
    public String toUpdateStudt(@PathVariable("Sno") Integer Sno, Model model) {
        Student student = studentService.selectTcherById(Sno);
        model.addAttribute("studt",student);
        return "admin/studt/studtUpdate";
    }

    @PostMapping("/updateStudent")
    @ResponseBody
    public int updateStudent(Student student) {
        return studentService.updateStudent(student);
    }    // 弹出层 提交 更新谜语表单

    @PostMapping("/delStudent/{Sno}")
    @ResponseBody
    public void delStudent(@PathVariable("Sno") Integer Sno) {
        studentService.deleteStudent(Sno);
    }

    // 删除多行数据 返回json字符串
    @PostMapping("/delManyStudt")
    @ResponseBody
    public int delManyStudt(@RequestParam("sno[]") String[] sno) {
        return studentService.delManyStudt(sno);
    }

    // 谜语 模糊查询
    @PostMapping("/selectS")
    @ResponseBody
    public LayuiTypeJson<Student> selectBySearch(@RequestParam("search") String search) {
        return studentService.selectBySearch(search);
    }


}
