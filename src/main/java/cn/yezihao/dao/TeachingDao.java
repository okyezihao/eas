package cn.yezihao.dao;

import cn.yezihao.entity.Teacher;
import cn.yezihao.entity.Teaching;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeachingDao {
    List<Teaching> findAllTeaching();

    List<Teacher> selectBySearch(@Param("search") String search);
}
