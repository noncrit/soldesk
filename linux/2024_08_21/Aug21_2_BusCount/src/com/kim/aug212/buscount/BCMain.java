package com.kim.aug212.buscount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class BCMain {
	public static void main(String[] args) {
		
		try {
			Configuration c = new Configuration();
			
			Job j = Job.getInstance();
			
			j.setMapperClass(BCMapper.class);
			j.setCombinerClass(BCReducer.class);
			j.setReducerClass(BCReducer.class);
			
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			for(int i=1;i<=3;i++) {
				String fileName = String.format("/bus202%d.csv", i);
				Path filePath = new Path(fileName);
				FileInputFormat.addInputPath(j, filePath);
			}
			
			// 분석해서 그 결과를 HDFS 최상위에 있는 지정한 파일에 담기
			FileOutputFormat.setOutputPath(j, new Path("/sBusResult"));
			
			//절대 빼먹으면 안되는 코드 **작업이 끝날 때 까지 대기하라는 코드**
			j.waitForCompletion(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
