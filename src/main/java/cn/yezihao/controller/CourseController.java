package cn.yezihao.controller;

import cn.yezihao.entity.Course;
import cn.yezihao.entity.Student;
import cn.yezihao.service.impl.CourseServiceImpl;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/course")
    @ResponseBody
    public LayuiTypeJson<Course> findAllCourse() {
        return courseService.courseList();
    }

    @GetMapping("/toAddCour")
    public String toAddCour() {
        return "admin/cour/courAdd";
    }

    @PostMapping("/addCourse")
    @ResponseBody
    public int addCourse(Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/toUpdateCour/{Courceno}")
    public String toUpdateCour(@PathVariable("Courceno") Integer Courceno, Model model) {
        Course course = courseService.selectCourById(Courceno);
        model.addAttribute("cour",course);
        return "admin/cour/courUpdate";
    }

    @PostMapping("/updateCourse")
    @ResponseBody
    public int updateCourse(Course course) {
        return courseService.updateCourse(course);
    }

    @PostMapping("/delCourse/{Courceno}")
    @ResponseBody
    public void delCourse(@PathVariable("Courceno") Integer Courceno) {
        courseService.deleteCourse(Courceno);
    }

    @PostMapping("/delManyCour")
    @ResponseBody
    public int delManyCour(@RequestParam("Courceno[]") String[] Courceno) {
        return courseService.delManyCour(Courceno);
    }

    @PostMapping("/selectC")
    @ResponseBody
    public LayuiTypeJson<Course> selectBySearch(@RequestParam("search") String search) {
        return courseService.selectBySearch(search);
    }

}
