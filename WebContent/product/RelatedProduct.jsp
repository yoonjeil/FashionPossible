<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<style>
* {margin: 0;padding: 0;}
table {border-collapse: collapse;}
caption {display: none;}
a {text-decoration: none;color: inherit;}
.board_list_wrap {width: 962px;}
.board_list {border-top: 2px solid black; width: 100%; text-align: center;}
.board_list tr {border-bottom: 1px solid #ccc;}
.board_list th, .board_list td {padding: 10px;font-size: 14px;}
.board_list td {text-align: center;}
img {width: 60px; height: 100px;}
</style>
<head>
<title>관련 상품</title>
</head>
<c:if test="${!empty isResult }">
<c:set var="relatedProduct" value="${isResult }"/>
</c:if> 
<!-- <body> -->
	<div class="board_list_wrap">
		<table class="board_list">
			<thead>
				<tr>
					<th>상품사진</th>
					<th>상품명</th>
					<th>가격</th>
					<th>옵션</th>
					<th>수량</th>
				</tr>
			</thead>
		
			<tbody>
			<c:forEach items="${relatedProduct}" var="product">
				<tr>
					<td><img src="product/images/${product.image }" alt=""></td>
					<td>${product.name}</td>
					<td>${product.price2 }</td>
					<td>
						<select>
							<option>Small</option>
							<option>Medium</option>
							<option>Large</option>
							<option>X-Large</option>
						</select>
					</td>
					<td>
						<select>
							<option>Red</option>
							<option>Black</option>
							<option>Blue</option>
							<option>Beige</option>
						</select>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>