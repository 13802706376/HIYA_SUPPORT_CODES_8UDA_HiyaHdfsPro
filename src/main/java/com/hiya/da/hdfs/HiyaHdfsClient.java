package com.hiya.da.hdfs;

public class HiyaHdfsClient
{
	public static void main(String[] args) throws Exception
	{
	  HiyaHdfsUtil hhs = HiyaHdfsUtil.SigleInstance.INSTANCE.getInstance();
		
		//创建文件夹
		//hhs.mkdir("/hiya");
		
		//上传文件
		hhs.upload("C://Users/zjq/Desktop/hadoop/dept","/hiya");
		hhs.upload("C://Users/zjq/Desktop/hadoop/emp","/hiya");
		
		//下载文件
		hhs.download("/hiya","C://Users/zjq/Desktop/hadoop/");
		
		//迭代文件 
		hhs.listFiles();
		
		//删除文件(夹)
		//hhs.removeFile();
		
		
		System.out.println(say(139.0,311.0));
	}
	
	private static String say(double before,double after)
	{
		String val = 139.0/311.0*100+"%";
	    val = val.substring(0, (val.indexOf(".")+3))+"%";
        return val;
	}
}
