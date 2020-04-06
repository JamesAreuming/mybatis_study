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

desc students;

insert into students(stud_id, name, email, phone, dob)
values(3, '정아름', 'hothihi5@gmail.com', '010-4252-3245', '1988-10-20');

select * from students;

delete from students where stud_id = 5;

select * from students;

update students
	set name='정미녀', email='pinkmiin@naver.com', phone='010-1234-4567', dob='2000-10-20'
where stud_id=3;

select * from students;

select user(),database();

show tables;

select * from addresses;

	select stud_id, name, email, phone, dob, a.addr_id, street, city, state, zip, country
		from students s join addresses a on s.addr_id = a.addr_id
		where stud_id = 1;
		
select * from courses;

select * from tutors;

select t.tutor_id , t.name, t.email, c.course_id, c.name, c.description, c.start_date, c.end_date
	from tutors t left outer join courses c on t.tutor_id  = c.tutor_id
	where t.tutor_id = 1;
	

desc students;

alter table students add gender tinyint unsigned;

select * from students;


insert into students(stud_id, name, email, phone, dob, gender)
values(4, 'test', 'test@naver.com', '010-1111-1111', '1990-10-10', 1);

desc user_pics;

select * from user_pics;