package com.hiya.da.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class HiyaHdfsUtil
{
	public enum SigleInstance
	{
		INSTANCE;
		public HiyaHdfsUtil instance;

		SigleInstance()
		{
			instance = new HiyaHdfsUtil();
		}

		public HiyaHdfsUtil getInstance()
		{
			return instance;
		}
	}

	private String HDFS_ADDR = "hdfs://10.10.51.77:9000";
	Configuration conf = new Configuration();
	FileSystem fs =null;
	{
		conf.set("fs.defaultFS", HDFS_ADDR);
		try
		{
			fs = FileSystem.get(conf);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	

	/**
	 * 上传文件到hdfs上
	 */
	public void upload(String source,String target) throws IOException
	{
		fs.copyFromLocalFile(new Path(source), new Path(target));
	}

	/**
	 * 将hdfs上文件下载到本地
	 */
	public void download(String source,String target) throws IOException
	{
		fs.copyToLocalFile(new Path(source), new Path(target));
	}

	/**
	 * 删除hdfs上的文件
	 * 
	 * @throws IOException
	 */
	public void removeFile() throws IOException
	{
		fs.delete(new Path("/demo/jdk1.8.tar.gz"), true);
	}

	/**
	 * 在hdfs更目录下面创建test1文件夹
	 * 
	 * @throws IOException
	 */
	public void mkdir(String path) throws IOException
	{
		fs.mkdirs(new Path(path));
	}

	public void listFiles() throws IOException
	{
		RemoteIterator<LocatedFileStatus> iterator = fs.listFiles(new Path("/"), true);
		while (iterator.hasNext())
		{
			LocatedFileStatus next = iterator.next();
			System.out.println(next.getPath());
		}
		System.out.println("----------------------------------------------------------");
		FileStatus[] fileStatuses = fs.listStatus(new Path("/"));
		for (int i = 0; i < fileStatuses.length; i++)
		{
			FileStatus fileStatus = fileStatuses[i];
			System.out.println(fileStatus.getPath());
		}
	}
}
