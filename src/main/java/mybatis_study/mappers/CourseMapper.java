package mybatis_study.mappers;

import java.util.List;
import java.util.Map;

import mybatis_study.dto.Course;

public interface CourseMapper {
	List<Course> selectCourseByCondition(Map<String, Object> map);
	List<Course> selectCaseCourses(Map<String, Object> map);
	List<Course> selectWhereCourses(Map<String, Object> map);
	List<Course> selectTrimCourses(Map<String, Object> map);
}
