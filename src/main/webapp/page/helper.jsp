<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>helper page</title>
<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
</head>
<body>


<script type="text/javascript">
	$.get('/json/city.json',function(data){
		console.log(data);
		if(data){
			for(var i=0;i<data.length;i++){
				var id=data[i].id;
				var pid=data[i].pid;
				var cityCode=data[i].city_code;
				var cityName=data[i].city_name;
				$.post('/city/insertCity',{id:id,pid:pid,cityCode:cityCode,cityName:cityName},function(d){
					console.log(d);
				})
			}
		}
		
		
	})


</script>
</body>
</html>