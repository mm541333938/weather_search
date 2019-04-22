<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>天气查询</title>
<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
<style type="text/css">
	body{
		background:#FFF0F5;
	}
	.infobox{
		width:130px;
		float:left;
		margin-top:20px;
		margin-left:20px;
		padding:10px;
		border:1px solid #f08;
	}
	
	#box2{
		background:#0ff;
	}
	
	.infobox .date{
		color:#3366ff;
		font-weight:700;
		margin-bottom:10px;
	}
	
	.infobox .aqi{
		background:#79b800;
		width:80px;
		margin-left:20px;
		height:30px;
		text-align:center;
		
		display:table-cell;
		vertical-align:middle;
		color:#fff;
		font-size:16px;
	}
	
	.infobox .temp{
		margin-top:10px;
	}
	
	.infobox .type{
		margin-top:10px;
	}
	
	.infobox .type img{
		width:80px;
		height:80px;
	}
	
	.infobox .type div{
		width:80px;
		text-align:center;
	}
	
	.infobox .sun{
		margin-top:10px;
	}
	
	.infobox .wind{
		margin-top:10px;
	}
	
</style>

</head>
<body>
	<di style="text-align:center">
		<div style="margin-top:80px;">
			<label for="inputBox" style="font-size:18px;">县市名称：</label>
			<input type="text" id="inputBox" name="inputBox" placeholder="请输入县市名称" style="height:22px;font-size:18px;">
			<button id="btnQuery" style="height:24px;">查询</button>
		</div>
		<div id="showCase" style="text-align:left;text-line:30px;margin:50px auto;width:1100px;display:none;">
			<div id="box1" class="infobox">
				<div class="date"></div>
				<div class="aqi"></div>
				<div class="temp"></div>
				<div class="type">
					<img src=""/>
					<div></div>
				</div>
				<div class="sun"></div>
				<div class="wind"></div>
			</div>
			<div id="box2" class="infobox">
				<div class="date"></div>
				<div class="aqi"></div>
				<div class="temp"></div>
				<div class="type">
					<img src=""/>
					<div></div>
				</div>
				<div class="sun"></div>
				<div class="wind"></div>
			</div>
			<div id="box3" class="infobox">
				<div class="date"></div>
				<div class="aqi"></div>
				<div class="temp"></div>
				<div class="type">
					<img src=""/>
					<div></div>
				</div>
				<div class="sun"></div>
				<div class="wind"></div>
			</div>
			<div id="box4" class="infobox">
				<div class="date"></div>
				<div class="aqi"></div>
				<div class="temp"></div>
				<div class="type">
					<img src=""/>
					<div></div>
				</div>
				<div class="sun"></div>
				<div class="wind"></div>
			</div>
			<div id="box5" class="infobox">
				<div class="date"></div>
				<div class="aqi"></div>
				<div class="temp"></div>
				<div class="type">
					<img src=""/>
					<div></div>
				</div>
				<div class="sun"></div>
				<div class="wind"></div>
			</div>
			<div id="box6" class="infobox">
				<div class="date"></div>
				<div class="aqi"></div>
				<div class="temp"></div>
				<div class="type">
					<img src=""/>
					<div></div>
				</div>
				<div class="sun"></div>
				<div class="wind"></div>
			</div>
		</div>
	</di>
	<script type="text/javascript">
	
		$('#btnQuery').click(function(){
			var cityName=$('#inputBox').val();
			if(cityName==undefined || cityName==null || cityName==''){
				alert('请先输入县市名');
				return false;
			}
			
			$('#showCase').hide();
			$.get('/queryWeather',{cityName:cityName},function(data){
				if(data){
					if(data.code==0){
						alert(data.message);
					}else if(data.code==1){
							var json=JSON.parse(data.data);
							console.log(json);
							$('#showCase').show();
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
				var box=$('#'+selector);
				box.find(".date").html(json.date);
				box.find(".aqi").html(aqiToLevel(json.aqi));
				box.find(".temp").html(tempToOne(json.low,json.high));
				box.find(".type img").attr("src",typeToUrl(json.type));
				box.find(".type div").html(json.type);
				box.find(".sun").html(sunToOne(json.sunrise,json.sunset));
				box.find(".wind").html(windToOne(json.fx,json.fl));
			}
			
			//aqi指数转化为提示文字
			function aqiToLevel(aqi){
				if(aqi>=0 && aqi<=50){
					return "优";
				}
				if(aqi>=51 && aqi<=100){
					return "良";
				}
				if(aqi>=101 && aqi<=150){
					return "轻度污染";
				}
				if(aqi>=151 && aqi<=200){
					return "中度污染";
				}
				if(aqi>=201 && aqi<=300){
					return "重度污染";
				}
				if(aqi>=301){
					return "严重污染";
				}
			}
			
			//处理温度
			function tempToOne(low,high){
				var temp="";
				temp+=low.substring(3);
				temp+=" ~ ";
				temp+='<span style="color:red">'+high.substring(3)+'</span>';
				return temp;
			}
			
			//处理天气
			function typeToUrl(type){
				if(type){
					if(type=="多云"){
						return "/images/多云.png";
					}
					if(type=="晴"){
						return "/images/晴.png";
					}
					if(type=="小雨"){
						return "/images/小雨.png";
					}
					if(type=="阴"){
						return "/images/阴.png";
					}
				}
				return "";
			}
			
			//处理日出日落时间
			function sunToOne(sunrise,sunset){
				var sun="";
				sun+="↑ "+sunrise;	
				sun+=" ~ ";
				sun+="↓ "+sunset;
				return sun;
			}
			
			function windToOne(fx,fl){
				var wind="";
				wind+=fx;
				wind+=" ";
				wind+=fl;
				return wind;
			}
			
		});
		
	</script>
</body>
</html>