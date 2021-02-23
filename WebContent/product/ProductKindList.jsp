<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">
<title>상품 목록</title>
  
<jsp:include page="../ShopHeader.jsp" />
	<h2>Item</h2>
	<c:forEach items="${productKindList}" var="product">
		<div id="categoryitem">
		<a href="ShopController?command=product_detail&pseq=${product.pseq}" style="color: black">
			<img src="product/images/${product.image}" />
			<h3>${product.name}</h3>
			<p>${product.price2}</p>
		</a>
		</div>
	</c:forEach>
<%@ include file="../footer.jsp" %>    