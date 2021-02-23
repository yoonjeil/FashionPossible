<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.detailimage {text-align:center; width: 971px; box-sizing: border-box;}
img {width: 971px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="detail" value="${isResult }"/>
<body>
   <table class="detailimage">
      <tr><td>${detail.content }</td></tr>
      <tr><td><img src="product/images/${detail.image }" alt=""></td></tr>
      <tr><td>${detail.content2 }</td></tr>
      <tr><td><img src="product/images/${detail.image2 }" alt=""></td></tr> 
      <tr><td><img src="product/images/${detail.image3 }" alt=""></td></tr>
      <tr><td><img src="product/images/${detail.image4 }" alt=""></td></tr>
      <tr><td><img src="product/images/${detail.image5 }" alt=""></td></tr>
   </table>
</body>
</html>