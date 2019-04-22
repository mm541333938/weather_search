package cn.jeson.Weather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpUtil {

	private static int TIME_OUT=10000;  //超时时间10秒
	private static String GET="GET";  //使用Get方法访问
	
	public static String httpGet(String requestUrl) throws IOException {
		
		URL url=new URL(requestUrl);
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();    //返回了connection对象
		conn.setConnectTimeout(TIME_OUT);
		conn.setUseCaches(false);
		conn.setRequestMethod(GET);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		
		conn.connect(); //手动connect一下     真的开始发送连接请求   注意和上面的区别
		//接受返回的信息   stateCode 200 
		int stateCode=conn.getResponseCode();
		if(stateCode!=HttpURLConnection.HTTP_OK) { //请求异常
			System.out.println("stateCode:"+stateCode);
			System.out.println(conn.getResponseMessage());
		}
		InputStream is=conn.getInputStream();  // 流，一组byte字节的集合
		InputStreamReader ir=new InputStreamReader(is,Charset.forName("utf-8")); //使用utf-8编码，从字节转为字符
		BufferedReader br=new BufferedReader(ir);  //提高效率 
		String line=null;
		StringBuffer sbf=new StringBuffer();
		while((line=br.readLine())!=null) {
			sbf.append(line);
		}
		String content=sbf.toString(); //读取的内容
		br.close();
		ir.close();
		is.close();
		conn.disconnect();  //断开连接
		
		return content; //返回内容
	}
	
	
	
}
