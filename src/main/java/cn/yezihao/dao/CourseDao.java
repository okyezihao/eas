package cn.yezihao.dao;

import cn.yezihao.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseDao {
    List<Course> findAllCourse();

    void addCourse(Course course);

    Course selectCourById(@Param("Courceno") Integer Courceno);

    void updateCourse(Course course);

    void deleteCourse(Integer Courceno);

    List<Course> selectBySearch(@Param("search") String search);
}
