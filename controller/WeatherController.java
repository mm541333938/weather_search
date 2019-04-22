package cn.jeson.Weather.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jeson.Weather.model.City;
import cn.jeson.Weather.service.WeatherService;
import cn.jeson.Weather.util.HttpUtil;
import cn.jeson.Weather.vo.JsonResult;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("requestInterface")
	public String requestInterface() {
		String requestUrl="http://www.baidu.com/";
		String content="";
		try {
			content=HttpUtil.httpGet(requestUrl);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	
	
	//天气接口
	@RequestMapping("queryWeather")
	public JsonResult queryWeather(@RequestParam("cityName") String cityName) {
		JsonResult jr=new JsonResult();
		City city=new City();
		city.setCityName(cityName);
		String weatherApi="http://t.weather.sojson.com/api/weather/city/";
		try {
			List<City> listCity=this.weatherService.findCity(city);
			if(listCity!=null && listCity.size()>0) {
				if(listCity.size()>1) {
					jr.setCode(0);
					jr.setMessage("查询到多个地区，请输入更准确名称");
				}else {
					String cityCode=listCity.get(0).getCityCode();
					weatherApi+=cityCode;
					String content=HttpUtil.httpGet(weatherApi);
					jr.setCode(1);
					jr.setData(content);
				}
			}else {
				jr.setCode(0);
				jr.setMessage("没有查询到相关地区");
			}
			
		} catch (Exception e) {
			jr.setCode(0);
			jr.setMessage("内部错误！");
			e.printStackTrace();
		}
		return jr;
	}
	
	
	
	
}
