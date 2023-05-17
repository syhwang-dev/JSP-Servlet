<%
/* 한글이 없기 때문에 setCharacterEncoding 사용하지 않음. */
request.setCharacterEncoding("UTF-8");

String type = (String)request.getParameter("sel");
String val = request.getParameter("val");

/* String sel = new String(type); */
/* if (dan != null) val = Integer.parseInt(dan); */

if (type != null && type.equals("gugudanType1")) {
	// response.sendRedirect("gugudan1.jsp?num="+val);
	request.getRequestDispatcher("gugudan1.jsp?num="+val).forward(request, response);
} else {
	// response.sendRedirect("gugudan2.jsp?col="+val);
	request.getRequestDispatcher("gugudan2.jsp?col="+val).forward(request, response);
} 
// 호출이 되어 이동하는 기능은 같으나 갱신(새로고침, F5)을 누를 경우, 갱신 대상이 달라짐.
// 리다이렉트: gugudan1.jsp 페이지 갱신
// 포워드: gugudanMain.jsp 페이지 갱신
// 포워드로 갱신 시 안내창이 발생 - 결제 후 새로고침하면 다시 결제해야 하는 상황 발생;

// form 태그에서 name으로 선정되어 있는 것은 전부 파라미터로 넘겨
%>
