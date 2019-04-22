package cn.jeson.Weather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeson.Weather.dao.CityMapper;
import cn.jeson.Weather.model.City;

@Service
public class WeatherService {

	@Autowired
	private CityMapper cityMapper;
	
	public List<City> findCity(City city){
		return this.cityMapper.findCity(city);
	}
}
