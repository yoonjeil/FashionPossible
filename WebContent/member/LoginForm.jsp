<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../ShopHeader.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.body{
/* 	
	padding-right: 250px;
	 */
	}
   .Serbtn{
   background:#423e4a; color:#fff;width:290px;border:1px solidd #423e3a; text-align:center;
   border-radius:2px;margin:5px auto; padding:5px 10px; font-weight:800; font-size:12px;
   }
   
   .button {
   width: 290px;
   border-radius:2px;margin:5px auto; padding:5px 10px; font-weight:800; font-size:12px;
   }
</style>
</head>
<body class="body">

<article>
<div align = "center">
<p><br><p><br><p><br>
<h1 >LOGIN</h1>

<form action="/FashionPossible/ShopController?command=login" method="post">
      <input type="text" name= "id" value = "${id}" size= "40" placeholder="아이디" style="height:30px"><br>
      <input type="password" name = "pwd" size = "40" placeholder="비밀번호" style="height:30px"><br>

      <div class = "clear"></div>
      <div id="buttons">
      <input class = "Serbtn" type= "submit" value = "로그인" class= "submit"><br>
      <input class = "button" type="button" value="이메일 인증" onclick= "location='ShopController?command=gmail'"><br>
      <input class = "Serbtn" type="button" value="회원가입" class= "cancel" onclick= "location='ShopController?command=contract'">
      </div>
      <h4>아직도 회원이 아니세요?</h4>
      <p>
      지금 패션파서블의 회원이 되어 다양한 이벤트에 참여해보세요
      <p>
     회원만의 특별한 혜택을 가장 먼저 만나보세요
   </form>
   </div>
</article>
</body>
</html>

<%@ include file="../footer.jsp" %>