package mybatis_study.mappers.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Student;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;
import mybatis_study.mappers.StudentMapper;

public class StudentMapperImpl implements StudentMapper{
	private static final StudentMapperImpl instance = new StudentMapperImpl();
	
	private String namaspace = "mybatis_study.mappers.StudentMapper";
//	private SqlSession sqlSession;
	
	private StudentMapperImpl() {}
	
	public static StudentMapperImpl getInstance() {
		return instance;
	}

	@Override
	public Student selectStudentByNO(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namaspace + ".selectStudentByNO", student);
		}
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namaspace + ".selectStudentByNoWithResultMap", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {		
			return sqlSession.selectList(namaspace + ".selectStudentByAll");
		}
	}

	@Override
	public int insertStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namaspace + ".insertStudent", student);
			return res;
		}
	}

	@Override
	public int deleteStudent(int id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.delete(namaspace +  ".deleteStudent", id);
		}
	}

	@Override
	public int updateStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.update(namaspace +  ".updateStudent", student);
		}
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namaspace +  ".selectStudentByAllForResultMap");
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namaspace +  ".selectStudentByAllForHashMap");
		}
	}
}
