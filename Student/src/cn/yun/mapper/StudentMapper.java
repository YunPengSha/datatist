package cn.yun.mapper;

import cn.yun.po.Student;

public interface StudentMapper {

    Student selectByPrimaryKey(Integer id);

}