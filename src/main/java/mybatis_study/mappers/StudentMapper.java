package mybatis_study.mappers;

import java.util.List;
import java.util.Map;

import mybatis_study.dto.Student;

public interface StudentMapper {
	//타입핸들러를 사용
	Student selectStudentByNO(Student student);
	//타입핸들러를 사용하지 않음 
	Student selectStudentByNoWithResultMap(Student student); 
	//리스트
	List<Student> selectStudentByAll();
	//insert
	int insertStudent(Student student);
	//delete
	int deleteStudent(int id);
	//update
	int updateStudent(Student student);
	//결과매핑 : 1대1, 1대 多
	List<Student> selectStudentByAllForResultMap();
	//결과매핑 : HashMap
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	Student selectStudentByNoAssociation(Student student);
	
	//enum 다루기
	int insertEnumStudent(Student student);
}
