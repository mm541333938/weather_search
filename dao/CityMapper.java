package cn.jeson.Weather.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.jeson.Weather.model.City;

@Mapper
public interface CityMapper {
   
   
    int insert(City record);

   
    int insertSelective(City record);
    
    public List<City> findCity(City city);

   
}