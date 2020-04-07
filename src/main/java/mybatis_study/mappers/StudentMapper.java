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
	
	//여러 개의 입력 파라미터 전달
	Student selectAllStudentByMap(Map<String, String> map);
	
	//resultset 처리방식의 재정의
	Map<Integer, String> selectStudentForMap(int studId);
	//Map<Integer, String> selectStudentForMap(int studId);
	
	int updateSetStudent(Student student);

}
