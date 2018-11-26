package com.hiya.da.gdp;


public class CityYear
{
      private Double shanghai = 0.0;
      private Double beijing = 0.0;
      private Double shenzhen = 0.0;
      private Double guangzhou = 0.0;
      private CityYear[] citys ;
      
    public CityYear(Integer shanghai, Integer beijing, Integer shenzhen, Integer guangzhou)
  	{
  		super();
  		this.shanghai = Double.valueOf(shanghai);
  		this.beijing = Double.valueOf(beijing);
  		this.shenzhen = Double.valueOf(shenzhen);
  		this.guangzhou = Double.valueOf(guangzhou);
  	}
	
	public CityYear[] getCitys()
	{
		return citys;
	}

	public void setCitys(CityYear[] citys)
	{
		this.citys = citys;
	}

	public Double getShanghai()
	{
		return shanghai;
	}
	public void setShanghai(Double shanghai)
	{
		this.shanghai = shanghai;
	}
	public Double getBeijing()
	{
		return beijing;
	}
	public void setBeijing(Double beijing)
	{
		this.beijing = beijing;
	}
	public Double getShenzhen()
	{
		return shenzhen;
	}
	public void setShenzhen(Double shenzhen)
	{
		this.shenzhen = shenzhen;
	}
	public Double getGuangzhou()
	{
		return guangzhou;
	}
	public void setGuangzhou(Double guangzhou)
	{
		this.guangzhou = guangzhou;
	}
      
      
      
}
