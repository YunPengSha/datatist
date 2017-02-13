package cn.yun.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.yun.mapper.StudentMapper;
import cn.yun.po.Student;

public class MapperTest {
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {

		InputStream inputStream = Resources
				.getResourceAsStream("test/SqlMapConfig-test.xml");

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	//测试Mapper是否能正常运行
	@Test
	public void testFindOrdersAndUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
		
		Student s = mapper.selectByPrimaryKey(1);
		
		System.out.println(s);
		
		sqlSession.close();
	}
}
