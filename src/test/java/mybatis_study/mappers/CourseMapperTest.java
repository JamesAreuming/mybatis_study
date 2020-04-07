package mybatis_study.mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study.AbstractTest;
import mybatis_study.dto.Course;
import mybatis_study.dto.CourseStat;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;
import mybatis_study.mappers.impl.CourseMapperImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest extends AbstractTest{
	
	private static CourseMapperImpl dao;
    private static SqlSession sqlSession;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = CourseMapperImpl.getInstance();
        sqlSession = MyBatisSqlSessionFactory.openSession(true);
        dao.setSqlSession(sqlSession);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		sqlSession.close();
	}

	@Test
	public void test01SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		GregorianCalendar cal = new GregorianCalendar(2013,1,1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		
		List<Course> courses = dao.selectCourseByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	@Test
	public void test02SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		GregorianCalendar cal = new GregorianCalendar(2013,1,1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("courseName", "%java%");
		
		List<Course> courses = dao.selectCourseByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	@Test
	public void test03SelectCourseByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		GregorianCalendar cal = new GregorianCalendar(2013,1,1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", cal.getTime());
		
		List<Course> courses = dao.selectCourseByCondition(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}	
	
	@Test
	public void test04SelectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
		List<Course> courses = dao.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%java%");
		courses = dao.selectCaseCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	@Test
	public void test05SelectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
		
		map.put("tutorId", 1);
		courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}	
		
		map.put("courseName", "%java%");
		courses = dao.selectWhereCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}			
		
		map.clear();
		map.put("endDate", new Date());
		courses = dao.selectWhereCourses(map);
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	@Test
	public void test06SelectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");	
		
		Map<String, Object> map = new HashMap<String, Object>();
		ListTrimCourses(map);
		
		map.put("tutorId", 1);
		ListTrimCourses(map);
		
		map.clear();		
		map.put("courseName", "%java%");
		map.put("tutorId", 1);
		ListTrimCourses(map);
	}

	private void ListTrimCourses(Map<String, Object> map) {
		List<Course> courses = dao.selectTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	
	@Test
	public void test07SelectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");	
		
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);
		
		List<Course> courses = dao.selectCourseForeachbyTutors(map);
		Assert.assertNotNull(courses);
		
		for(Course c : courses) {
			log.trace(c.toString());
		}
	}
	
	//@Test
	public void test08InsertCourses() {
		List<Course> tutors = new ArrayList<Course>();
		tutors.add(new Course(4, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(5, "mysql", "database", new Date(), new Date(), 3));
		tutors.add(new Course(6, "mariaDb", "database", new Date(), new Date(), 4));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutors", tutors);
		
		int res = dao.insertCourses(map);
		Assert.assertEquals(3, res);
	}
	
	//@Test
	public void test09DeleteCourses() {
	    List<Integer> courseIds = Arrays.asList(4, 5, 6);
        
	    Map<String, Object> map = new HashMap<String, Object>();
	    map.put("courseIds", courseIds);
	        
	    int res = dao.deletecourses(map);
	    Assert.assertEquals(3, res);
	}
			
	//@Test
	public void test10InsertCourse() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1988, 9, 20); // newDate.set(1988, 10, 20); : 1988-11-20일로 들어감
		
		Course course = new Course(8, "Python", "Programming", new Date(), new Date(), 6);
		int res = dao.insertCourse(course);
		Assert.assertEquals(1, res);		
	}
	
	@Test
	public void test11getCourseCountByTutor() {
	   log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
	   Map<String, Object> param = new HashMap<>();
	   param.put("tutor_id", 1);
	   Map<String,Object> map= dao.getCourseCountByTutor(param);
	   Assert.assertNotEquals(0, map.size());
	}

	@Test
	public void test12getCourseCountByTutor2() {
	   log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
	   Map<String, Object> param = new HashMap<>();
	   param.put("tutor_id", 1);
	   Map<String,Object> map= dao.getCourseCountByTutor2(param);
	   Assert.assertNotEquals(0, map.size());
	}

	@Test
	public void test12getCourseCountByTutor3() {
	   log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
	   CourseStat stat = dao.getCourseCountByTutor3(1);
	   Assert.assertNotNull(stat);
	}
}

