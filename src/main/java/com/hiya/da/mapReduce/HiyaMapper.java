package com.hiya.da.mapReduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HiyaMapper extends Mapper<Object, Text, Text, IntWritable>
{
	private final static IntWritable one = new IntWritable(1);
	private Text event = new Text();

	public void map(Object key, Text value, Context context) throws IOException, InterruptedException
	{
		int idx = value.toString().indexOf(" ");
		if (idx > 0)
		{
			String e = value.toString().substring(0, idx);
			event.set(e);
			context.write(event, one);
		}
	}
}