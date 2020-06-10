package cn.yezihao.service.impl;

import cn.yezihao.dao.TeacherDao;
import cn.yezihao.entity.Teacher;
import cn.yezihao.service.TeacherService;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public List<Teacher> findAllTeacher() {
        return teacherDao.findAllTeacher();
    }

    public Teacher selectTcherById(Integer Tno) {
        return teacherDao.selectTcherById(Tno);
    }

    public int addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
        return 200;
    }

    public LayuiTypeJson<Teacher> teacherList() {
        List<Teacher> list = teacherDao.findAllTeacher();
        LayuiTypeJson<Teacher> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
        return json;
    }

    public int updateTeacher(Teacher teacher) {
        teacherDao.updateTeacher(teacher);
        return 200;
    }

    public void deleteTeacher(Integer Tno) {
        teacherDao.deleteTeacher(Tno);
    }

    public int delManyTcher(String[] Tno) {
        for (int i = 0; i < Tno.length; i++) {
            String n = Tno[i];
            int t = Integer.parseInt(n);
            teacherDao.deleteTeacher(t);
        }
        return 1;
    }

    public LayuiTypeJson<Teacher> selectBySearch(String search) {
        List<Teacher> teachers = teacherDao.selectBySearch(search);
        LayuiTypeJson<Teacher> json = new LayuiTypeJson<>();
        json.setCount(teachers.size());
        json.setData(teachers);
        return json;
    }

}
