package cn.jeson.Weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.jeson.Weather.model.City;
import cn.jeson.Weather.service.CityService;
import cn.jeson.Weather.vo.JsonResult;

@RestController
@RequestMapping("city")
public class CityController {

	@Autowired
	private CityService cityService;
	
	
	@RequestMapping("insertCity")
	public JsonResult insertCity(@RequestParam("id") int id,
								 @RequestParam("pid") int pid,
								 @RequestParam("cityCode") String cityCode,
								 @RequestParam("cityName") String cityName) {
		
		JsonResult jr=new JsonResult();
		City city=new City(id,pid,cityCode,cityName);
		try {
			this.cityService.insert(city);
			System.out.println(city.toString());
			jr.setCode(1);
			jr.setMessage("保存成功！");
		} catch (Exception e) {
			jr.setCode(0);
			jr.setMessage("保存异常！");
			e.printStackTrace();
		}
		
		return jr;
	}
	
}
