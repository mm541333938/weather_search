<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天气查询</title>
<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
<style type="text/css">
	.infobox{
		width:250px;
		float:left;
		margin-top:20px;
		margin-left:20px;
		padding:10px;
		border:1px solid #f08;
	}
	
	#box2{
		background:#0ff;
	}
</style>

</head>
<body>
	<di style="text-align:center">
		<div>
			<input type="text" id="inputBox" placeholder="请输入县市名称">
			<button id="btnQuery">查询</button>
		</div>
		<div style="text-align:left;text-line:30px;margin:20px auto;width:900px;">
			<div id="box1" class="infobox"></div>
			<div id="box2" class="infobox"></div>
			<div id="box3" class="infobox"></div>
			<div id="box4" class="infobox"></div>
			<div id="box5" class="infobox"></div>
			<div id="box6" class="infobox"></div>
		</div>
	</di>
	<script type="text/javascript">
	
		$('#btnQuery').click(function(){
			var cityName=$('#inputBox').val();
			if(cityName==undefined || cityName==null || cityName==''){
				alert('请先输入县市名');
				return false;
			}
			
			$.get('/queryWeather',{cityName:cityName},function(data){
				if(data){
					if(data.code==0){
						alert(data.message);
					}else if(data.code==1){
							var json=JSON.parse(data.data);
							console.log(json);
							showWeather(json);
					}
				}
			});
			
			function showWeather(json){
				if(json){
					var yesterday=json.data.yesterday;
					fillWeatherJson(yesterday,'box1');
					var forecaset=json.data.forecast;
					fillWeatherJson(forecaset[0],'box2');
					fillWeatherJson(forecaset[1],'box3');
					fillWeatherJson(forecaset[2],'box4');
					fillWeatherJson(forecaset[3],'box5');
					fillWeatherJson(forecaset[4],'box6');
				}
			}
			
			
			function fillWeatherJson(json,selector){
				var t="";
				t+="AQI："+json.aqi;
				t+="<br/>日期："+json.date;
				t+="<br/>风力："+json.fl;
				t+="<br/>风向："+json.fx;
				t+="<br/>最高温："+json.high;
				t+="<br/>最低温："+json.low;
				t+="<br/>提示："+json.notice;
				t+="<br/>日出时间："+json.sunrise;
				t+="<br/>日落时间："+json.sunset;
				t+="<br/>天气："+json.type;
				$('#'+selector).html(t);
			}
		});
		
	</script>
</body>
</html>