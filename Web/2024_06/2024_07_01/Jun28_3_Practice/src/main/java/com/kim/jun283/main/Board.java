package com.kim.jun283.main;

public class Board {
	private String j_ID;
	private String j_IMG;
	private String doi;
	private String content;
	private int postNum;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Board(String j_ID, String j_IMG, String doi, String content, int postNum) {
		super();
		this.j_ID = j_ID;
		this.j_IMG = j_IMG;
		this.doi = doi;
		this.content = content;
		this.postNum = postNum;
	}



	public String getJ_ID() {
		return j_ID;
	}



	public void setJ_ID(String j_ID) {
		this.j_ID = j_ID;
	}



	public String getJ_IMG() {
		return j_IMG;
	}



	public void setJ_IMG(String j_IMG) {
		this.j_IMG = j_IMG;
	}



	public String getDoi() {
		return doi;
	}



	public void setDoi(String doi) {
		this.doi = doi;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getPostNum() {
		return postNum;
	}



	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}



	
	
	
}
