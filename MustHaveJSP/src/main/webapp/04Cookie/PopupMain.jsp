<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on";

Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for (Cookie c : cookies) {
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if (cookieName.equals("PopupClose")) {
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키를 이용한 팝업 관리</title>
<style>
	div#popup {
		position: absolute; top:100px; left:50px; color:yellow;
		width:270px; height:100px; background-color:gray;
	}
	div#popup>div {
		position:relative; background-color: #ffffff; top:0px;
		border:1px solid gray; padding:10px; color:black;
	}
</style>
<!-- 제이쿼리 불러오기 / 요즘은 리액트 사용 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
	$('#closeBtn').click(function () {
		$('#popup').hide();
		var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();
		console.log("chkVal", chkVal);
		if (chkVal != undefined) {  // undefined가 아니면 아래의 ajax 실행
			// ajax: 비동기통신을 위한 방식 / 요즘은 엑시오스 사용
			$.ajax({
				url : './PopupCookie.jsp',
				type : 'get',
				data : {inactiveToday : chkVal},
				dataType : "text",
				success : function(resData) {
					if (resData != '') location.reload();  // 현재 보고 있는 페이지를 재로딩
				}
			});	
		}
	});
});
</script>
</head>
<body>
	<h2>팝업 메인 페이지(ver 0.1)</h2>
	<%
		for (int i=1; i<=10; i++) {
			out.print("현재 팝업창은 " + popupMode + "상태입니다.<br/>");
		}
	
		if (popupMode.equals("on")) {
	%>
		<div id="popup">
			<h2 align="center">공지사항 팝업입니다.</h2>
			<div align="right">
				<form name="popFrm">
				<input type="checkbox" id="inactiveToday" value="1" />
				하루 동안 열지 않음 
				<input type="button" id="closeBtn" value="닫기" />
				</form>
			</div>
		</div>
	<%
		}
	%>








</body>
</html>