<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>

<style>
.margin {height:100px;width:100%;}
.button_margin {height:20px;width:100%;}
.board {max-width:1200px;width:100%;margin:auto;background:white;}
/*목록*/


/* 각칸마다 비율*/
.board_list_wrap {width: 962px;}
.board_list {border-top: 2px solid black; width: 100%; text-align: center;}
.board_list tr {border-bottom: 1px solid #ccc;}
.board_list th, .board_list td {padding: 10px;font-size: 14px;}
.board_list td {text-align: center;}
/*text-overFlow*/
.button1{background:blue;color:white;border:none;padding:10px;border-radius:5px;}
.button2{background:red;color:white;border:none;padding:10px;border-radius:5px;}
/*버튼*/
img {width: 100px;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:if test="${!empty isResult }">
<c:set var="reviewList" value="${isResult }"/>
</c:if> 
<body>
<div>
	<h3>Review List</h3>
	<div class="board_list_wrap">
		<table class="board_list">
			<thead>
				<tr>
					<th>상품사진</th>
					<th>제목</th>
					<th>아이디</th>
					<th>등록일</th>
				</tr>
			</thead>
			
			<c:forEach items="${reviewList}" var="reviewList">
			<tbody>
				<tr>
					<td> <img src="product/images/${reviewList.image }"></td>
					<td><a href="ShopController?command=review_view&rno=${reviewList.rno}">${reviewList.subject}</a></td>
					<%-- <td>${reviewList.subject }</td> --%>
					<%-- <td>${reviewList.content }</td> --%>
					<td>${reviewList.id }</td>
 					<td><fmt:formatDate value ="${reviewList.indate }" type="date"/></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
		
				<div class="buttons">
					<button type="button" class="button1"  onclick="location.href='ShopController?command=review_write_form'">리뷰작성</button>
				<!-- <input type="submit" class="button1" value="리뷰작성"> -->
				</div>
		
		
		<!-- <form action="ShopController?command=review_write_form" method=post> -->


		<!-- </form> -->
	</div>
</body>
</html>