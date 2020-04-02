package mybatis_study.mappers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import mybatis_study.AbstractTest;
import mybatis_study.dto.PhoneNumber;
import mybatis_study.dto.Student;
import mybatis_study.mappers.impl.StudentMapperImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest{

	private static StudentMapper dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentMapperImpl.getInstance();
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
	public void test01SelectStudentByNO() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNO(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNoWithResultMap(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	@Test
	public void test03SelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = dao.selectStudentByAll();
		Assert.assertNotNull(lists);
		for(Student std : lists) {
			log.debug(std.toString());
		}
	}
	
//	@Test
	public void test04InsertStudent() {
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1988, 9, 20); // newDate.set(1988, 10, 20); : 1988-11-20일로 들어감
		
		Student student = new Student();
		student.setStudId(3);
		student.setName("정아름");
		student.setEmail("hothihi5@gmail.com");
		student.setPhone(new PhoneNumber("010-1111-3245"));
		student.setDob(newDate.getTime());
		int res = dao.insertStudent(student);
		Assert.assertEquals(1, res);
	}
	
//	@Test
	public void test05DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		int deleteStudent = dao.deleteStudent(3);
		Assert.assertSame(1, deleteStudent);
	}
	
	
//	@Test
	public void test05UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(3);
		student.setName("정미녀");
		student.setEmail("pinkmiin@naver.com");
		student.setPhone(new PhoneNumber("010-1234-4567"));
		student.setDob(new Date());
		
		int result = dao.updateStudent(student);
		Assert.assertSame(1, result);
	}
	
	@Test
	public void test06SelectStudentByAllForResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(lists);
		
		for(Student std : lists) {
			log.debug(std.toString());
		}
	}
	
	@Test
	public void test07SelectStudentByAllForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Map<String, Object>> lists = dao.selectStudentByAllForHashMap();
		Assert.assertNotNull(lists);
		
		for(Map<String, Object> map : lists) {
			for(Entry<String, Object> e : map.entrySet()) {
				log.debug(String.format("[KEY]%s -> [VALUE]%s", e.getKey(), e.getValue()));
			}
		}
	}
	}


