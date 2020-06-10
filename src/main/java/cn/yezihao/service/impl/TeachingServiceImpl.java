package cn.yezihao.service.impl;

import cn.yezihao.dao.TeachingDao;
import cn.yezihao.entity.Teacher;
import cn.yezihao.entity.Teaching;
import cn.yezihao.service.TeachingService;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachingServiceImpl implements TeachingService {

    @Autowired
    private TeachingDao teachingDao;

    public List<Teaching> findAllTeaching() {
        return teachingDao.findAllTeaching();
    }


    public LayuiTypeJson<Teaching> teachingList() {
        List<Teaching> list = findAllTeaching();
        LayuiTypeJson<Teaching> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
        return json;
    }

    public LayuiTypeJson<Teacher> selectBySearch(String search) {
        List<Teacher> teachers = teachingDao.selectBySearch(search);
        LayuiTypeJson<Teacher> json = new LayuiTypeJson<>();
        json.setCount(teachers.size());
        json.setData(teachers);
        return json;
    }
}
