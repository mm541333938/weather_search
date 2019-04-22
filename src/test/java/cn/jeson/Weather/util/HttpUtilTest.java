package cn.jeson.Weather.util;

import java.io.IOException;

public class HttpUtilTest {

	
	public static void main(String[] args) {
		String requestUrl="https://www.iqiyi.com/";
		try {
			String content=HttpUtil.httpGet(requestUrl);
			System.out.println("content:"+content);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
