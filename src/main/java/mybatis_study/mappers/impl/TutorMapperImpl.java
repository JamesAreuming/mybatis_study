package mybatis_study.mappers.impl;

import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Tutor;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;
import mybatis_study.mappers.TutorMapper;

public class TutorMapperImpl implements TutorMapper {
	private static final TutorMapperImpl instance = new TutorMapperImpl();

	private final String namespace = "mybatis_study.mappers.TutorMapper";
	private SqlSession sqlSession;

	private TutorMapperImpl() {}

	public static TutorMapperImpl getInstance() {
		return instance;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	@Override
	public Tutor selectTutorByTutorId(Tutor tutor) {
		return sqlSession.selectOne(namespace + ".selectTutorByTutorId", tutor);
	}

	@Override
	public int insertTutor(Tutor tutor) {
			return sqlSession.insert(namespace + ".insertTutor", tutor);
	}

	@Override
	public int deleteTutor(int id) {
			return sqlSession.delete(namespace +  ".deleteTutor", id);
	}
}