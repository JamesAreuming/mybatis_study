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
	private SqlSession sqlSession;
	
	private StudentMapperImpl() {}
	
	public static StudentMapperImpl getInstance() {
		return instance;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Student selectStudentByNO(Student student) {
			return sqlSession.selectOne(namespace + ".selectStudentByNO", student);
	}

	@Override
	public Student selectStudentByNoWithResultMap(Student student) {
			return sqlSession.selectOne(namespace + ".selectStudentByNoWithResultMap", student);
	}

	@Override
	public List<Student> selectStudentByAll() {	
			return sqlSession.selectList(namespace + ".selectStudentByAll");
	}

	@Override
	public int insertStudent(Student student) {
			return sqlSession.insert(namespace + ".insertStudent", student);
	}

	@Override
	public int deleteStudent(int id) {
			return sqlSession.delete(namespace +  ".deleteStudent", id);
	}

	@Override
	public int updateStudent(Student student) {
			return sqlSession.update(namespace +  ".updateStudent", student);
	}

	@Override
	public List<Student> selectStudentByAllForResultMap() {
			return sqlSession.selectList(namespace +  ".selectStudentByAllForResultMap");
	}

	@Override
	public List<Map<String, Object>> selectStudentByAllForHashMap() {
			return sqlSession.selectList(namespace +  ".selectStudentByAllForHashMap");
	}

	@Override
	public Student selectStudentByNoAssociation(Student student) {
		try (SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true)) {		
			return sqlSession.selectOne(namespace +  ".selectStudentByNoAssociation", student);
		}
	}

	@Override
	public int insertEnumStudent(Student student) {
			return sqlSession.insert(namespace + ".insertEnumStudent", student);
	}

	@Override
	public Student selectAllStudentByMap(Map<String, String> map) {
			return sqlSession.selectOne(namespace + ".selectAllStudentByMap",map);
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
		sqlSession.select(namespace + ".selectStudentForMap",studId, resultHandler);
		return map;
	}

	@Override
	public int updateSetStudent(Student student) {
			return sqlSession.update(namespace + ".updateSetStudent",student);
	}
}
