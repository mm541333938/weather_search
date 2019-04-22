package cn.jeson.Weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jeson.Weather.dao.CityMapper;
import cn.jeson.Weather.model.City;

@Service
public class CityService {

	@Autowired
	private CityMapper cityMapper;
	
	public int insert(City record) {
		return this.cityMapper.insert(record);
	}
	
}
