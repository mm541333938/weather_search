package cn.jeson.Weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.jeson.Weather.util.HttpUtil;

@RestController
public class WeatherController {
	@RequestMapping("requestInterface")
	public String requestInterface() {
		String requestUrl = "http://www.baidu.com/";
		String content = HttpUtil.httpGet(requestUrl);
		return content;
	}
}
