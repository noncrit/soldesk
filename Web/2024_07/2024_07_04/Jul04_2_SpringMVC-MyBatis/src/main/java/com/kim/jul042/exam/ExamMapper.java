package com.kim.jul042.exam;

import java.util.List;

public interface ExamMapper {

	public abstract int regExam(Exam exam);
	public abstract int regExam_test(Exam_test exam);
	
	public abstract List<Exam> getAllExam();
	public abstract List<Exam_test> getAllExam_test();
}
