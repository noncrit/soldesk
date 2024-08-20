package com.kim.aug201.wc;
// Hadoop 작업의 첫번째 - : Map

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

// 1단계 : 다운받은 소설책을 분석하라고 넣어줄 것
// >>key : 없고 / Value : String(Hadoop 에서는 String이 Text)
//
// 2단계 : 결과를 받아오기(단어, 등장횟수 데이터)
// key : String, value : int
//	ex) I 1 / am 1 / sleepy 1

public class WCMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	// 결과처리를 위해 자료형을 맞추려면 아예 메소드 밖에서 실행하는게 좋다.=> 굳이 반복문 안에서 실행할 필요가 없음
	// Singleton 처리까지
	// 각각의 WORD에 1을 붙여서 전달
	private static final Text WORD = new Text();
	private static final IntWritable ONE = new IntWritable(1); 
	
	// Map을 override => 한 문장마다 이 method가 호출될 예정
	@Override
	protected void map(Object key, // data의 유무 체크
			Text value, // *중요 : 한 줄씩 잘라낸 문장 자체 -> 해당하는 문장을 가져오기 위해 필요함
			Mapper<Object, Text, Text, IntWritable>.Context context) //Context : 결과 처리하는 역할
			throws IOException, InterruptedException {
		
		//기존에 불러온 Text를 String 객체로 바꿔주는 작업
		String line = value.toString();
		
		//문장을 단어로 나누기
		//정확하게 단어의 위치를 체크 - split으로 인덱스 활용하기
		//그냥 나누는 것만 필요할 때 - tokenizer 활용
		StringTokenizer st = new StringTokenizer(line, " ");
		
		while(st.hasMoreTokens()) {
			// 결과 처리 작업 (Hadoop 의 자료형에 맞춰서 다시 Text로 넘겨줘야함)
			WORD.set(st.nextToken());
			context.write(WORD, ONE);
		}
		//super.map(key, value, context);
	}
}
