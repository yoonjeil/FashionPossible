<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="../ShopHeader.jsp" %> 
	
<%@ page import="dto.ProductVO"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">

	function delete0() {
		var count = 0;		
		if(document.formm.cseq.length == undefined){count++;
			if(!document.formm.cseq.checked) ;			
		}
		else
		for  (var i = 0; i <document.formm.cseq.length;i++){
			if(document.formm.cseq[i].checked == true){
				count++;
			}
		}
		if (count == 0 ){
			
		}else{
			document.formm.action = "ShopController?command=cart_delete";
			document.formm.submit();			
		}
	}
	function go_order_insert(){
	
	
			document.formm.action = "ShopController?command=order_add";
			document.formm.submit();
		
	}
</script>
<!DOCTYPE html>
<html>
<head>
<style>

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<article>
		<h2>Cart List</h2>
		<form name="formm" method="post">
			<c:choose>
				<c:when test="${cartList.size() == 0 }">
					<h3 style="colot:black; text-align: center;">장바구니가 비었습니다.</h3>
				</c:when>
				<c:otherwise>
					<table id="cartList">
						<tr>
							<th>이미지</th>
							<th>상품명</th>
							<th>수량</th>
							<th>가 격</th>
							<th>주문일</th>
							<th></th>
						</tr>
						<c:forEach items="${cartList}" var="cart">
							<tr>
								<td>
									<img style="width: 100px;" src="product/images/${cart.image}">
		
								</td>
								<td>
									<a href="ShopController?command=product_detail&pseq=${cart.pseq}" style="color:black">
										${cart.pname}
								</a></td>
								<td>${cart.quantity}</td>
								<td><fmt:formatNumber value="${cart.price2*cart.quantity}"
										type="currency" /></td>
								<td><fmt:formatDate value="${cart.indate}" type="date" /></td>
								<td><input type="checkbox" name="cseq"
									value="${cart.cseq}"></td>
							</tr>
						</c:forEach>

						<tr>
							<th colspan="2">총 액</th>
							<th colspan="2"><fmt:formatNumber value="${totalPrice}"
									type="currency" /><br></th>
							<th><a href="#" onclick="delete0()" style="color:black"> <h3>삭제하기</h3></a></th>
						</tr>

					</table>
				</c:otherwise>
			</c:choose>
			<div class="clear"></div>
			<div id="buttons" style="float: right">
				<input type="button" value="쇼핑 계속하기" class="cancle" onclick="location='ShopController?command=index'">
				<c:if test="${cartList.size()!=0}">
					<input type="button" value="주문하기" class="submit" style="color:black" onclick="go_order_insert()">
				</c:if>
				</div>
		</form>
	</article>
</body>
</html>
<%@ include file="../footer.jsp" %>