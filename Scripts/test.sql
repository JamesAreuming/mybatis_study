select user(), database (); -- user_mybatis_study@localhost / mybatis_study

select * from addresses;
select * from tutors;
select * from students;
select * from course_enrollment;
select * from courses;

-- 타입핸들러로이용해서 쓰기
select stud_id as studID, name, email, dob, phone
	from students
	where stud_id=1;
	

-- 타입핸들러 쓰지 않고, 최대한 sql에서 할수있도록
select stud_id, name, email, dob, phone,
	substring(phone, 1, 3) as f,
	substring(phone, 5, 3) as m,
	substring(phone, 9, 4) as l
	from students where stud_id =1;
	
-- 리스트
select STUD_ID as studId, NAME, EMAIL, PHONE, DOB from students;