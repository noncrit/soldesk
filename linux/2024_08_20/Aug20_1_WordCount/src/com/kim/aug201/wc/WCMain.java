package com.kim.aug201.wc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 소설책 => 작가가 무슨 단어를 자주 사용했는지 파악해보기

// Hadoop 을 이용해서 표현 : 서버급 컴퓨터 여러대로 병렬처리해서 분석하는 프로그램

// 굳이 Window 측에서 코드 짜는 이유..?  : 자동완성 쓰려고

// hadoop-common, hadoop-mapreduce-client-core 라이브러리만 있으면 됨

// Hadoop 의 마지막 단계
public class WCMain {
	public static void main(String[] args) {
		try {
			// 설정
			Configuration c = new Configuration();
			
			// Hadoop 작업을 하겠다고 선언할 수 있는 job
			Job j = Job.getInstance(c);
			
			// 각 단계별 담당할 클래스 지정
			j.setMapperClass(WCMapper.class);	//Mapper 지정
			j.setCombinerClass(WCReducer.class);//Combine 단계는 자동진행이라 그냥 Reducer 지정
			j.setReducerClass(WCReducer.class);	//Reducer 지정
			
			//결과 형태 지정 - Reduce쪽 Out(KEYOUT, VALUEOUT) 과 맞춰주기
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			// HDFS 최상위에 있는 txt 파일을 분석
			FileInputFormat.addInputPath(j, new Path("/Tom_sawyer.txt"));
			
			// 분석해서 그 결과를 HDFS 최상위에 있는 지정한 파일에 담기
			FileOutputFormat.setOutputPath(j, new Path("/sResult"));
			
			//절대 빼먹으면 안되는 코드 **작업이 끝날 때 까지 대기하라는 코드**
			j.waitForCompletion(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
