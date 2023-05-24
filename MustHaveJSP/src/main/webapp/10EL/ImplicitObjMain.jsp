<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("scopeValue", "페이지 영역");  // 맵의 형태로 저장되어 있다고 생각하기
request.setAttribute("scopeValue", "리퀘스트 영역");
session.setAttribute("scopeValue", "세션 영역");
application.setAttribute("scopeValue", "애플리케이션 영역");
%>    
    
<!DOCTYPE html>
<html>
<head><title>Insert title here</title></head>
<body>
	<h2>ImplicitObjMain 페이지</h2>
	<h3>각 영역에 저장된 속성 읽기</h3>
	<ul>
		<li>페이지 영역 : ${ pageScope.scopeValue }</li>
		<li>페이지 영역 : <%= pageContext.getAttribute("scopeValue")%></li>
		<%-- <li>페이지 영역 : <%= scopeValue %></li> --%> <!-- 영역 표시 없이 변수명만 넣으면 제일 작은 영역에 있는 정보를 가져옴. 만약 page가 없으면 request에서 가져옴. -->
		
		<li>리퀘스트 영역 : ${ requestScope.scopeValue }</li>
		<li>세션 영역 : ${ sessionScope.scopeValue }</li>
		<li>애플리케이션 영역 : ${ applicationScope.scopeValue }</li>
	</ul>
	
	<h3>영역 지정 없이 속성 읽기</h3>
	<ul>
		<li>${ scopeValue }</li>
	</ul>
	
	<%-- <jsp:forward page="ImplicitForwardResult.jsp" /> --%>

</body>
</html>