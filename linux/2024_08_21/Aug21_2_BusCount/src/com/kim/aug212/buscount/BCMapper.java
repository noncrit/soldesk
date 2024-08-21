package com.kim.aug212.buscount;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class BCMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final Text WORD = new Text();
	private static final IntWritable COUNT = new IntWritable(); 
	
	@Override
	protected void map(Object key,
			Text value, 
			Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		
		//요일 구하기 위한 Calendar 객체
		Calendar c = Calendar.getInstance();
		
		//요일 구하기 위한 sdf, date 선언
		SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date date =null;
		
		//승차수 + 하차수 저장을 위한 변수
		int total_p = 0;
		
		//csv 파일 형식이라 한 줄씩 읽어오기 가능
		StringTokenizer st = new StringTokenizer(line, "\n");
		
		while(st.hasMoreTokens()) {
			
			String input = st.nextToken();
			//2021 01 01, 100, 한성여객종점, 12, 0
			//연 월 일, 버스 번호, 정류장 이름, 승차인원, 하차인원
			String[] input_array = input.split(", ");
			
			// 승차수+하차수를 total_p에 정수형으로 변환해서 저장
			try {
				total_p = Integer.parseInt(input_array[3])+Integer.parseInt(input_array[4]);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//String day_result = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.KOREAN);
			try {
				date = format.parse(input_array[0]);
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if(date!=null) {
				c.setTime(date);
				String result = c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.KOREAN);
				
				WORD.set(result);
				COUNT.set(total_p);
				context.write(WORD, COUNT);
			}
					
		}
				
	}
	
}
