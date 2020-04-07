package mybatis_study.mappers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

import mybatis_study.AbstractTest;
import mybatis_study.dto.Gender;
import mybatis_study.dto.PhoneNumber;
import mybatis_study.dto.Student;
import mybatis_study.jdbc.MyBatisSqlSessionFactory;
import mybatis_study.mappers.impl.StudentMapperImpl;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentMapperTest extends AbstractTest{

	private static StudentMapperImpl dao;
	private static SqlSession sqlSession;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = StudentMapperImpl.getInstance();
		sqlSession = MyBatisSqlSessionFactory.openSession(true);
		dao.setSqlSession(sqlSession);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
		sqlSession.close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
	public void test01SelectStudentByNO() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNO(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
	//@Test
	public void test02SelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStudent = dao.selectStudentByNoWithResultMap(student);
		log.debug(selectStudent.toString());
		Assert.assertEquals(student.getStudId(), selectStudent.getStudId());
	}
	
//	@Test
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
	
	//@Test
	public void test06SelectStudentByAllForResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		List<Student> lists = dao.selectStudentByAllForResultMap();
		Assert.assertNotNull(lists);
		
		for(Student std : lists) {
			log.debug(std.toString());
		}
	}
	
	//@Test
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
	
	//@Test
	public void test08SelectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		Student selectStd = dao.selectStudentByNoAssociation(student);
		Assert.assertNotNull(selectStd);
		log.debug(selectStd.toString());
	}
	
//	@Test
	public void test09InsertEnumStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990,2,28);
		Student student = new Student();
		student.setStudId(5);
		student.setName("test2");
		student.setEmail("test2@naver.com");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGrnder(Gender.FEMALE);
		int res = dao.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		student.setStudId(6);
		student.setName("test3");
		student.setEmail("test1@naver.com");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1235-1235"));
		student.setGrnder(Gender.MALE);
		int res1 = dao.insertEnumStudent(student);
		Assert.assertEquals(1, res1);	
	}
	
	@Test
	public void test10SelectAllStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String, String> maps = new HashMap<>();
		maps.put("name", "Timothy");
		maps.put("email", "timothy@gmail.com");
		Student student = dao.selectAllStudentByMap(maps);
		Assert.assertNotNull(student);
		log.debug(student.toString());
		
		maps.remove("email");
		student = dao.selectAllStudentByMap(maps);
		log.debug(student.toString());
		
		maps.clear();
		maps.put("email", "timothy@gmail.com");
		student = dao.selectAllStudentByMap(maps);
		log.debug(student.toString());
	}
	
	@Test
	public void test11SelectAllStudentForMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
	Map<Integer, String> map = dao.selectStudentForMap(3);
	Assert.assertNotNull(map);
	
	for(Entry<Integer, String>entry : map.entrySet()) {
		System.out.printf("KEY[%s] --- VALUE[%S]%n", entry.getKey(), entry.getValue());
		}
	}
	
	@Test
	public void test12UpdateSetStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Student student = new Student();
		student.setStudId(1);
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int result = dao.updateSetStudent(student);
		Assert.assertSame(1, result);
		
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988,04,25).getTime());
		
		result = dao.updateSetStudent(student);
		Assert.assertSame(1, result);
	}
}

	


