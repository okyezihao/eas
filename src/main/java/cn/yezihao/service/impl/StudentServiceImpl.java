package cn.yezihao.service.impl;

import cn.yezihao.dao.StudentDao;
import cn.yezihao.entity.Student;
import cn.yezihao.service.StudentService;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public LayuiTypeJson<Student> studentList() {
        List<Student> list = studentDao.findAllStudent();
        LayuiTypeJson<Student> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
        return json;
    }

    public Student selectTcherById(Integer Sno) {
        return studentDao.selectStudtById(Sno);
    }

    public int addStudent(Student student) {
        studentDao.addStudent(student);
        return 200;
    }

    public int updateStudent(Student student) {
        studentDao.updateStudent(student);
        return 200;
    }

    public void deleteStudent(Integer Sno) {
        studentDao.deleteStudent(Sno);
    }

    public int delManyStudt(String[] Sno) {
        for (int i = 0; i < Sno.length; i++) {
            String n = Sno[i];
            int t = Integer.parseInt(n);
            studentDao.deleteStudent(t);
        }
        return 1;
    }

    public LayuiTypeJson<Student> selectBySearch(String search) {
        List<Student> students = studentDao.selectBySearch(search);
        LayuiTypeJson<Student> json = new LayuiTypeJson<>();
        json.setCount(students.size());
        json.setData(students);
        return json;
    }
}
