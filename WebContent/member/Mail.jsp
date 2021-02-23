<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ include file="../ShopHeader.jsp" %> 
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 인증</title>
<style>
.button {
   width: 100px;
   border-radius:2px;margin:5px auto; padding:5px 10px; font-weight:800; font-size:12px;
   }
</style>
</head>
<body>
<h2 >이메일 인증</h2>
<form action="/FashionPossible/ShopController?command=gmail" method="post">
      
      
      <c:choose>
      	<c:when test="${empty mailtitle }">
			<input type="text" name= "mail" size= "40" placeholder="e-mail" style="height:30px"><br>	
		</c:when>
		<c:otherwise>
			<input type="text" name= "result" size= "40" placeholder="${mailtitle }" style="height:30px"><br>			
		</c:otherwise>
	</c:choose>
			<input class="button" type="submit" value="보내기"><br>
<!-- 	<input class="button" type="submit" value="인증번호 보내기"><br> -->
	<%-- <input type="hidden" name="result" value="${mailtitle }"> --%> 
</form>
</body>
</html>
<%@ include file="../footer.jsp" %>