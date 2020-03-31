package mybatis_study.mappers;

import java.util.List;

import mybatis_study.dto.Student;

public interface StudentMapper {
	//타입핸들러를 사용
	Student selectStudentByNO(Student student);
	//타입핸들러를 사용하지 않음 
	Student selectStudentByNoWithResultMap(Student student); 
	//리스트
	List<Student> selectStudentByAll();
}
