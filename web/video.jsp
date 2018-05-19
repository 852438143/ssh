<%@ page contentType="text/html;charset=UTF-8" language="java" %>  
<!doctype html>
<html> 
<body> 

<button onclick="getCurTime()" type="button">获得当前时间的位置</button>
<button onclick="setCurTime()" type="button">把时间位置设置为 5 秒</button>
<br />
<br />
<div align="center">
<video id="video1" controls="controls">
  <source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4">
</video>
</div>
<script>

	myVid = document.getElementById("video1");
	function getCurTime() {
		alert(myVid.currentTime);
	}
	function setCurTime() {
		myVid.currentTime = 5;
	}
</script> 

</body> 
</html>
