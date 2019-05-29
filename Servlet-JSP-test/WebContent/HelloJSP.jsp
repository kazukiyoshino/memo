<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--  includeによってCounterServletの処理をしてからJSPを実施(dispatcher:include)と同じ動き-->
<%--<jsp:include page="/CounterServlet"/>--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSP</h2>
<p>%=→1+1=<%= 1+1 %></p>
<p>%　→1+1=<%
Integer count = 1+1;
out.println(count);
%></p>
<h4>変更確認</h4>
<FORM ACTION = "../Servlet-JSP-test/TestServlet">
<INPUT TYPE = "text" NAME="HelloJSP_text">
<input type = "SUBMIT">
</FORM>

<p>カウンタはCounterServletで作成</p>
<p>sessionVer→<%= session.getAttribute( "count" ) %> </p>
<p>applicationVer→<%= application.getAttribute( "count" ) %> </p>

<p>cookieVer→<%=request.getAttribute("counts")%></p>

<p>sessionカウンタをEL式で→${count}</p>
<p>※sessionとapplicationには同一の変数名で作成したが、<br>EL式では、狭い方から順に検索される</p>

<%--JSPのコメントアウト--%>
<p><a href="<%=request.getContextPath()%>/form.jsp">formへ</a></p>
<p><a href="<%=request.getContextPath()%>/ServiceServlet">session確認へ</a></p>
<p><a href="<%=request.getContextPath()%>/HelloServlet">HelloServletへ</a></p>

<%@include file="/test.jsp"%>
</body>
</html>