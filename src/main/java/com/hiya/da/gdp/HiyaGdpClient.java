package com.hiya.da.gdp;

public class HiyaGdpClient
{

	public static void main(String[] args)
	{
		CityYear[] ss = {
		//new CityYear(311,139	,3	,57),
		//new CityYear(466	,257	,39,	124),
		new CityYear(756,	500,	171	,319),
		new CityYear(2462,	1394,	795,	1243),
		new CityYear(4551,	2479,	1665,	2376),
		new CityYear(9125,	6814,	4926,	5115),
		new CityYear(16872	,13777,	9510,	10604),
		new CityYear(20101	,17801,	12950	,13501),
		new CityYear(23560	,21330	,16007	,16706),
		new CityYear(25123	,23014,	17502,	18100),
		new CityYear(27466	,24899	,19492,	19610),
		new CityYear(30133	,28000	,22438	,21503),
		new CityYear(23656	,21511	,17530,	16708)
		};
		
		System.out.println(
		"北京/上海    "+
		"深圳/上海    "+
		"深圳/北京    "+
		"广州/上海    "+
		"广州/北京    "+
		"广州/深圳    ");

		for(CityYear s :ss)
		{
			System.out.println(
					        say(s.getBeijing(),s.getShanghai())+
					"    "+say(s.getShenzhen(),s.getShanghai())+
					"    "+say(s.getShenzhen(),s.getBeijing())+
					"    "+say(s.getGuangzhou(),s.getShanghai())+
					"    "+say(s.getGuangzhou(),s.getBeijing())+
					"    "+say(s.getGuangzhou(),s.getShenzhen()));
		}
		
		
	}
	
	
	private static String say(double before,double after)
	{
		String val = before/after*100+"%";
	    val = val.substring(0, (val.indexOf(".")+3))+"%";
        return val;
	}
}
