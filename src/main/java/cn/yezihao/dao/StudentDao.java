package cn.yezihao.dao;

import cn.yezihao.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {

    List<Student> findAllStudent();

    Student selectStudtById(@Param("Sno") Integer Sno);

    void addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Integer Sno);

    List<Student> selectBySearch(@Param("search") String search);
}
