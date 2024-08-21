package com.kim.aug21.kwc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.kim.aug21.kwc.KWCMapper;
import com.kim.aug21.kwc.KWCReducer;

public class KWCMain {
	public static void main(String[] args) {
		try {
			Configuration c = new Configuration();
			
			// Hadoop 작업을 하겠다고 선언할 수 있는 job
			Job j = Job.getInstance(c);
			
			// 각 단계별 담당할 클래스 지정
			j.setMapperClass(KWCMapper.class);	//Mapper 지정
			j.setCombinerClass(KWCReducer.class);//Combine 단계는 자동진행이라 그냥 Reducer 지정
			j.setReducerClass(KWCReducer.class);	//Reducer 지정
			
			//결과 형태 지정 - Reduce쪽 Out(KEYOUT, VALUEOUT) 과 맞춰주기
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			// HDFS 최상위에 있는 txt 파일을 분석
			for (int i = 1; i <=10; i++) {
			    String fileName = String.format("/ThreeKingdoms%02d.txt", i);
			    Path filePath = new Path(fileName);
			    FileInputFormat.addInputPath(j, filePath);
			}
			
			// 분석해서 그 결과를 HDFS 최상위에 있는 지정한 파일에 담기
			FileOutputFormat.setOutputPath(j, new Path("/sThreeKingdomsResult"));
			
			//절대 빼먹으면 안되는 코드 **작업이 끝날 때 까지 대기하라는 코드**
			j.waitForCompletion(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
