<%@page import="java.util.ArrayList"%>
<%@page import="common.Person"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>application 영역의 공유</h2>
	<%
		Map<String, Person> maps = new HashMap<>();
		maps.put("actor1", new Person("이수일", 30));
		maps.put("actor2", new Person("심순애", 28));
		application.setAttribute("maps", maps);
		
		Map<String, Object> maps1 = new HashMap<>();
		
		// Page
		maps1.put("pageInteger", 1000);
		maps1.put("pageString", "페이지 영역의 문자열");
		maps1.put("pagePerson", new Person("한석봉", 99));
		
		// Request
		maps1.put("requestString", "request 영역의 문자열");
		maps1.put("requestPerson", new Person("안중근", 31));
		
		// Session
		ArrayList<String> lists = new ArrayList<>();
		lists.add("리스트");
		lists.add("컬렉션");
		maps1.put("lists", lists);
		
		application.setAttribute("maps1", maps1);
	%>
	application 영역에 속성이 저장되었습니다.
</body>
</html>