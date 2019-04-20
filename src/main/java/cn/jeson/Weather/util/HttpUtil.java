package cn.jeson.Weather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * 用于网络请求得工具类
 * 
 * @author loser
 *
 */
public class HttpUtil {
	private static int TIME_OUT = 10000;// 超时时间10s
	private static String GET = "GET";// 请求方式 GET

	public static String httpGet(String requestUrl) {
		URL url = null;
		HttpURLConnection conn = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		String content = null;
		try {
			url = new URL(requestUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(TIME_OUT);// setter over time
			conn.setUseCaches(false);// without using cache
			conn.setRequestMethod(GET);// set request method
			conn.setDoOutput(true);
			conn.setDoInput(true);

			conn.connect();// 设置完了,手动connect
			// 接受返回信息,stateCode 200 ?
			int stateCode = conn.getResponseCode();

			// 状态码是否异常
			if (stateCode != HttpURLConnection.HTTP_OK) {
				System.out.println("stateCode:" + stateCode);
				System.out.println(conn.getResponseMessage());
			}
			is = conn.getInputStream();// 流:一组byte字节(0101010110)的集合
			ir = new InputStreamReader(is, Charset.forName("utf-8"));// 从字节转字符
			br = new BufferedReader(ir);// 提高效率
			String line = null;
			StringBuffer sbf = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sbf.append(line);
			}
			content = sbf.toString();// 读取内容
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (ir != null) {
					ir.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			conn.disconnect();
		}
		return content;
	}
}
