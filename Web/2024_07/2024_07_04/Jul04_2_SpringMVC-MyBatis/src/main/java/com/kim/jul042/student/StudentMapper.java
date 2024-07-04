package com.kim.jul042.student;

import java.util.List;

public interface StudentMapper {
	// method 리턴 타입
	// insert update delete -> 영향을 받은 데이터의 수 - return 타입이 int
	// select
	// 결과가 하나 - resultType 객체 (Student)
	// 결과가 여러 개 - List<resultType 객체> (List<Student>)
	
	//Mapper.xml의 ID = interface의 method name 이어야 연결 가능
	//Mapper.xml의 ParameterType 과 동일하게 맞춰주기
	public abstract int regStudent(Student s);
	
	public abstract List<Student> getAllStudent();
}
