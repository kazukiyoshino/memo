<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>様々な入力フォーム</h2>
<FORM ACTION = "../Servlet-JSP-test/TestServlet">

<p>
<INPUT TYPE = "text" NAME="test" value="valueで初期文字を入れられる">
</p>

<p>
<textarea  name="test2" >inputと書き方の違いに注意</textarea>
</p>

<p>
<input type = "radio" name="test3" value="左">左
<input type = "radio" name="test3" value="右">右
</p>

<p>
<input type = "checkbox" name="test4">その1
<input type = "checkbox" name="test5">その2
<input type = "checkbox" name="test6">その3
</p>

<p>
<select name="test7" size="3">
<option value="1">1
<option value="2">2
<option value="3">3
<option value="4">4
<option value="5">5
<option value="6">6
<option value="7">7
<option value="8">8
</select>
</p>


<input type = "SUBMIT">
<input type = "reset">

</FORM>

</body>
</html>