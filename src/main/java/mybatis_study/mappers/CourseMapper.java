package mybatis_study.mappers;

import java.util.List;
import java.util.Map;

import mybatis_study.dto.Course;
import mybatis_study.dto.CourseStat;

public interface CourseMapper {
	List<Course> selectCourseByCondition(Map<String, Object> map);
	List<Course> selectCaseCourses(Map<String, Object> map);
	List<Course> selectWhereCourses(Map<String, Object> map);
	List<Course> selectTrimCourses(Map<String, Object> map);
	List<Course> selectCourseForeachbyTutors(Map<String, Object> map);
	
	int insertCourses(Map<String, Object> map);
	
	int deletecourses(Map<String, Object> map);
	
	int insertCourse(Course course);
	int deleteCourse(int id);
	
	//프로시저
	Map<String, Object> getCourseCountByTutor(Map<String, Object> param);
	Map<String, Object> getCourseCountByTutor2(Map<String, Object> param);
	
	CourseStat getCourseCountByTutor3(int param);
}
