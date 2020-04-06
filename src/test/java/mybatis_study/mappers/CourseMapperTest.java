package mybatis_study.mappers;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study.AbstractTest;
import mybatis_study.dto.Course;
import mybatis_study.mappers.impl.CourseMapperImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseMapperTest extends AbstractTest{
	
	private static CourseMapper dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = CourseMapperImpl.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
}

