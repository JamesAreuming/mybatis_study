package mybatis_study.mappers.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Course;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;
import mybatis_study.mappers.CourseMapper;

public class CourseMapperImpl implements CourseMapper{
	private static final CourseMapperImpl instance = new CourseMapperImpl();
	
	private String namespace = "mybatis_study.mappers.CourseMapper";
//	private SqlSession sqlSession;
	
	private CourseMapperImpl() {}
	
	public static CourseMapperImpl getInstance() {
		return instance;
	}

	@Override
	public List<Course> selectCourseByCondition(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {		
			return sqlSession.selectList(namespace+".selectCourseByCondition", map);
		}
	}

	@Override
	public List<Course> selectCaseCourses(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {		
			return sqlSession.selectList(namespace+".selectCaseCourses", map);
		}
	}

	@Override
	public List<Course> selectWhereCourses(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {		
			return sqlSession.selectList(namespace+".selectWhereCourses", map);
		}
	}

	@Override
	public List<Course> selectTrimCourses(Map<String, Object> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {	
			return  sqlSession.selectList(namespace+".selectTrimCourses", map);
		}
	}

}
