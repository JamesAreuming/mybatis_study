package mybatis_study.mappers.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;

import mybatis_study.dto.Course;
import mybatis_study.dto.CourseStat;
import mybatis_study.mappers.CourseMapper;

public class CourseMapperImpl implements CourseMapper{
	private static final CourseMapperImpl instance = new CourseMapperImpl();
	
	private String namespace = "mybatis_study.mappers.CourseMapper";
	private SqlSession sqlSession;
	
	private CourseMapperImpl() {}
	
	public static CourseMapperImpl getInstance() {
		return instance;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Course> selectCourseByCondition(Map<String, Object> map) {	
			return sqlSession.selectList(namespace+".selectCourseByCondition", map);
	}

	@Override
	public List<Course> selectCaseCourses(Map<String, Object> map) {		
			return sqlSession.selectList(namespace+".selectCaseCourses", map);
	}

	@Override
	public List<Course> selectWhereCourses(Map<String, Object> map) {	
			return sqlSession.selectList(namespace+".selectWhereCourses", map);
	}

	@Override
	public List<Course> selectTrimCourses(Map<String, Object> map) {	
			return  sqlSession.selectList(namespace+".selectTrimCourses", map);
	}

	@Override
	public List<Course> selectCourseForeachbyTutors(Map<String, Object> map) {
			return  sqlSession.selectList(namespace+".selectCourseForeachbyTutors", map);
	}

	@Override
	public int insertCourses(Map<String, Object> map) {
			return  sqlSession.insert(namespace+".insertCourses", map);
	}

	@Override
	public int deletecourses(Map<String, Object> map) {	
			return  sqlSession.delete(namespace+".deletecourses", map);
	}

	@Override
	public int insertCourse(Course course) {
			return sqlSession.insert(namespace + ".insertCourse", course);
	}

	@Override
	public int deleteCourse(int id) {
			return sqlSession.delete(namespace +  ".deleteCourse", id);
	}

	@Override
	public Map<String, Object> getCourseCountByTutor(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
		ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {

			@Override
			public void handleResult(ResultContext<? extends CourseStat> resultContext) {
				CourseStat state = resultContext.getResultObject();
				map.put(state.getTutor(), state.getTotal());
				
			}
		};
	    sqlSession.select(namespace + ".getCourseCountByTutor", param, resultHandler);
        return map;
	}

	@Override
	public Map<String, Object> getCourseCountByTutor2(Map<String, Object> param) {
		Map<String, Object> map = new HashMap<>();
	    ResultHandler<CourseStat> resultHandler = new ResultHandler<CourseStat>() {
	        @Override
	        public void handleResult(ResultContext<? extends CourseStat> resultContext) {
	            CourseStat state = resultContext.getResultObject();
	            map.put(state.getTutor(), state.getTotal());
	        }
	    };
	    sqlSession.select(namespace + ".getCourseCountByTutor2", param, resultHandler);
        return map;
	}

	@Override
	public CourseStat getCourseCountByTutor3(int param) {
		return sqlSession.selectOne(namespace + ".getCourseCountByTutor3", param);
	}

}
