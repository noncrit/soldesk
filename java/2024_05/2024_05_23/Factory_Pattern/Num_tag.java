package com.kim.may23_2.student;

import java.util.Objects;

public class Num_tag {
	
	private static String tag_array[];
	
	public Num_tag() {
		// TODO Auto-generated constructor stub
	}

	public Num_tag(String[] tag_array) {
		super();
		this.tag_array = tag_array;
	}
	
	public int decier(String[] tag_array, String name) {
	
		for (int i = 0; i < 30; i++) {
			
			if( Objects.isNull(tag_array[i]) ) {
				tag_array[i]=name;
			}
		
		}
		
		for (int i = 0; i < 30; i++) {
			
			if(tag_array[i].equals(name)) {
				return i;
			}
			
		}
		return -1;
	}
	
	

}
