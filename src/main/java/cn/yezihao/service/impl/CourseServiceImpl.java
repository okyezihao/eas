package cn.yezihao.service.impl;

import cn.yezihao.dao.CourseDao;
import cn.yezihao.entity.Course;
import cn.yezihao.entity.Student;
import cn.yezihao.service.CourseService;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public LayuiTypeJson<Course> courseList() {
        List<Course> list = courseDao.findAllCourse();
        LayuiTypeJson<Course> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
        return json;
    }

    public int addCourse(Course course) {
        courseDao.addCourse(course);
        return 200;
    }

    public Course selectCourById(Integer Courceno) {
        return courseDao.selectCourById(Courceno);

    }

    public int updateCourse(Course course) {
        courseDao.updateCourse(course);
        return 200;
    }

    public void deleteCourse(Integer Courceno) {
        courseDao.deleteCourse(Courceno);
    }

    public int delManyCour(String[] Courceno) {
        for (int i = 0; i < Courceno.length; i++) {
            String n = Courceno[i];
            int t = Integer.parseInt(n);
            courseDao.deleteCourse(t);
        }
        return 1;
    }

    public LayuiTypeJson<Course> selectBySearch(String search) {
        List<Course> students = courseDao.selectBySearch(search);
        LayuiTypeJson<Course> json = new LayuiTypeJson<>();
        json.setCount(students.size());
        json.setData(students);
        return json;
    }
}
