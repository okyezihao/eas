package cn.yezihao.dao;

import cn.yezihao.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherDao {

    List<Teacher> findAllTeacher();

    int addTeacher(Teacher teacher);

    Teacher selectTcherById(@Param("Tno") Integer Tno);

    int updateTeacher(Teacher teacher);

    void deleteTeacher(Integer tno);

    List<Teacher> selectBySearch(@Param("search") String search);
}
