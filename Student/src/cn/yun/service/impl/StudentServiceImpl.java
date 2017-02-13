package cn.yun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yun.mapper.StudentMapper;
import cn.yun.po.Student;
import cn.yun.service.StudentService;

/*
 * cxf 3.0.2
 * spring 3.2.0
 * mybatis 3.2.7
 * jdk1.7
 * tomcat7.0下运行正常
 * url访问地址为：http://localhost:8080/Student/services/rest/student/1
 * 数据库的data.sql文件在resources文件夹下
 * jar包本来在lib目录下
 * 因为只有get查询，所以spring中没加事物
 * 我很希望来贵公司实习
 * 
 */

public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentMapper studentMapper;

	public Student getStudentById(int studentId) {
	//	return null;
		return studentMapper.selectByPrimaryKey(studentId);
	}

}
