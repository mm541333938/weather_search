package cn.jeson.Weather.vo;

/**
 * 作为接口返回前端的容器
 * @author Jeson
 *
 */
public class JsonResult {

	private int code;
	
	private String message;
	
	private Object data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}
