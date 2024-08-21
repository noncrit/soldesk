package com.kim.aug21.kwc;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class KWCMapper extends Mapper<Object, Text, Text, IntWritable> {
	
	private static final Text WORD = new Text();
	private static final IntWritable ONE = new IntWritable(1); 
	
	@Override
	protected void map(Object key,
			Text value,
			Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		
		StringTokenizer st = new StringTokenizer(line, " ");
		
		String [] target = {"조조","맹덕","유비","현덕","손권","중모"};
		String [] target1 = {"조조","맹덕"};
		String [] target2 = {"유비","현덕"};
		String [] target3 = {"손권","중모"};
		
		while(st.hasMoreTokens()) {
			
			String token = st.nextToken();
			
			for(String targetWord : target) {
				if(token.contains(targetWord)) {
					
					for(int i=0;i<2;i++) {
						if(token.contains(target1[i])) {
							WORD.set("조조");
							context.write(WORD, ONE);
						}
						else if(token.contains(target2[i])) {
							WORD.set("유비");
							context.write(WORD, ONE);
						}
						else if(token.contains(target3[i])) {
							WORD.set("손권");
							context.write(WORD, ONE);
						}
						
					}
					
				}
			}
			
		}
		
	}
	
}
