package com.kim.aug212.buscount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class BCReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	private static final IntWritable SUM = new IntWritable();
	
	@Override
	protected void reduce(Text arg0, 
			Iterable<IntWritable> arg1,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) 
					throws IOException, InterruptedException {
		int sum = 0;
		
		for (IntWritable i : arg1) {
			//sum은 int, i는 Hadoop의 IntWritable => 형 변환 필요함(.get() )
			sum += i.get();	// 1+1+1=3
		}
		SUM.set(sum);
		arg2.write(arg0, SUM);
	}
}
