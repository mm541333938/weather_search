package cn.jeson.Weather.util;

public class HttpUtilTest {

	public static void main(String[] args) {
		String reUrl = "http://www.baidu.com/";
		String content = HttpUtil.httpGet(reUrl);
		System.out.println(content);

	}

}
