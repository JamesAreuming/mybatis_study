package mybatis_study.mappers;

import mybatis_study.dto.Tutor;

public interface TutorMapper {

	Tutor selectTutorByTutorId(Tutor findTutor);
	
	int insertTutor(Tutor tutor);
	int deleteTutor(int id);
}
