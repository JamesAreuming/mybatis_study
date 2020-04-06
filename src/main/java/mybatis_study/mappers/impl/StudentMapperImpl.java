package mybatis_study.mappers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Student;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;
import mybatis_study.mappers.StudentMapper;

public class StudentMapperImpl implements StudentMapper{
	private static final StudentMapperImpl instance = new StudentMapperImpl();
	
	private String namespace = "mybatis_study.mappers.StudentMapper";
//	private SqlSession sqlSession;
	
	private StudentMapperImpl() {}
	
	public static StudentMapperImpl getInstance() {
		return instance;
	}

	@Override
	public Student selectStudentByNO(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNO", student);
		}
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap", student);
		}
	}

	@Override
	public List<Student> selectStudentByAll() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {		
			return sqlSession.selectList(namespace + ".selectStudentByAll");
		}
	}

	@Override
	public int insertStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertStudent", student);
			return res;
		}
	}

	@Override
	public int deleteStudent(int id) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.delete(namespace +  ".deleteStudent", id);
		}
	}

	@Override
	public int updateStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.update(namespace +  ".updateStudent", student);
		}
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace +  ".selectStudentByAllForResultMap");
		}
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectList(namespace +  ".selectStudentByAllForHashMap");
		}
	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {		
			return sqlSession.selectOne(namespace +  ".selectStudentByNoAssociation", student);
		}
	}

	@Override
	public int insertEnumStudent(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			int res = sqlSession.insert(namespace + ".insertEnumStudent", student);
		return res;
		}
	}

	@Override
	public Student selectAllStudentByMap(Map<String, String> map) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			return sqlSession.selectOne(namespace + ".selectAllStudentByMap",map);
	}
	}

	@Override
	public Map<Integer, String> selectStudentForMap(int studId) {
		Map<Integer, String> map = new HashMap<>();
		ResultHandler<Student> resultHandler = new ResultHandler<Student>() {
			@Override
			public void handleResult(ResultContext<? extends Student> resultContext) {
				Student student= resultContext.getResultObject();
				map.put(student.getStudId(), student.getName());
			}
		};
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()) {
			sqlSession.select(namespace + ".selectStudentForMap",studId, resultHandler);
			return map;
	}
	}

}
