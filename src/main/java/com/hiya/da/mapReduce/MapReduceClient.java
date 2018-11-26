package com.hiya.da.mapReduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser; 

public class MapReduceClient
{
	/**
	 * 1 运行“mvn package”命令产生jar包hadoopstudy-1.0-SNAPSHOT.jar，并将jar文件复制到hadoop安装目录下
	 * 
	 * 2 这里假定我们需要分析几个日志文件中的Event信息来统计各种Event个数，所以创建一下目录和文件
	 *      /tmp/input/event.log.1  
		    /tmp/input/event.log.2  
		    /tmp/input/event.log.3  
     * 
     * 3 然后把这些文件复制到HDFS上 
     * $ bin/hdfs dfs -put /tmp/input /user/fkong/input 
     * 
     * 4 运行mapreduce作业 
     * $ bin/hadoop jar hadoopstudy-1.0-SNAPSHOT.jar my.hadoopstudy.mapreduce.EventCount /user/fkong/input /user/fkong/output
     * 
     * 5 查看执行结果
     * $ bin/hdfs dfs -cat /user/fkong/output/part-r-00000  
     * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		    Configuration conf = new Configuration();  
	        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();  
	        if (otherArgs.length < 2) {  
	            System.err.println("Usage: EventCount <in> <out>");  
	            System.exit(2);  
	        }  
	        Job job = Job.getInstance(conf, "event count");  
	        job.setJarByClass(MapReduceClient.class);  
	        job.setMapperClass(HiyaMapper.class);  
	        job.setCombinerClass(HiyaReduce.class);  
	        job.setReducerClass(HiyaReduce.class);  
	        job.setOutputKeyClass(Text.class);  
	        job.setOutputValueClass(IntWritable.class);  
	        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));  
	        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));  
	        System.exit(job.waitForCompletion(true) ? 0 : 1);  
	}
}
