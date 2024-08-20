package com.kim.aug201.wc;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/*
Hadoop의 두번째 단계 Combine : 알아서 처리 됨
같은 value 끼리는 합침 
I<1,1> (I가 두 번 등장한 경우)
boy<1,1,1> (boy가 3번 등장한 경우)

Hadoop의 세번째 단계 Reduce : 
	in : sleepy<1,1,1> 같은 앞 과정에서 넘어온 값들(KEYIN, VALUEIN) 앞부터 두자리 
	out : sleepy 3 (KEYOUT, VALUEOUT) 나머지 두자리
	
	앞의 두 자리는 Mapper 측 뒤의 두 자리와 같아야함
 */

public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	//Hadoop 자료형 처리를 위한 메소드
	private static final IntWritable SUM = new IntWritable();
	
	//sleepy <1,1,1> 한 세트를 만날 때마다 호출할 메소드
	@Override
	protected void reduce(Text arg0,	// Map 단계에서 보내줄 key value
			Iterable<IntWritable> arg1,	// list 비스무리한 <1,1,1>
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) //결과 처리용
					throws IOException, InterruptedException {
		int sum = 0;
		// <1,1,1> 을 뽑아서 합쳐줘야함
		for (IntWritable i : arg1) {
			//sum은 int, i는 Hadoop의 IntWritable => 형 변환 필요함(.get() )
			sum += i.get();	// 1+1+1=3
		}
		SUM.set(sum);
		arg2.write(arg0, SUM);
		
	}
}
