package cn.jeson.Weather.model;

public class City {

   
    private Integer id;

   
    private Integer pid;

   
    private String cityCode;

   
    private String cityName;

   
    
    
    public City() {
	}


	public City(Integer id, Integer pid, String cityCode, String cityName) {
		this.id = id;
		this.pid = pid;
		this.cityCode = cityCode;
		this.cityName = cityName;
	}


	public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

   
    public Integer getPid() {
        return pid;
    }

    
    public void setPid(Integer pid) {
        this.pid = pid;
    }

   
    public String getCityCode() {
        return cityCode;
    }

   
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    
    public String getCityName() {
        return cityName;
    }

   
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }


	@Override
	public String toString() {
		return "City [id=" + id + ", pid=" + pid + ", cityCode=" + cityCode + ", cityName=" + cityName + "]";
	}
    
    
    
}