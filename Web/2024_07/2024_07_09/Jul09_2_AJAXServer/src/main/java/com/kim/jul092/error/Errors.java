package com.kim.jul092.error;

import java.util.List;

//Error 데이터 하나하나를 List의 형태로 내보내기 위한 클래스
public class Errors {
	private List<Error> error;
	
	public Errors() {
		// TODO Auto-generated constructor stub
	}

	public Errors(List<Error> error) {
		super();
		this.error = error;
	}

	public List<Error> getError() {
		return error;
	}
	
	public void setError(List<Error> error) {
		this.error = error;
	}
	
}
