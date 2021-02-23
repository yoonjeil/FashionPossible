<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.product_view { position: relative;padding: 0 0 0 395px; width: 962px; box-sizing: border-box;}
.product_view .img { position: absolute; left: 0; top: 0;}
.product_view .img > img { width: 368px; height: 450px; border:1px solid #e8e8e8; }
.product_view .img li:after { content: ""; display: block; clear: both;}
.product_view .img li { float: left; padding: 10px 10px 0 0;}
.product_view .img li.on img { border-color:#0a56a9;}
.product_view .img li img { width: 68px; height: 68px; border:1px solid #e8e8e8;}
.product_view h2 { margin: 0 0 15px; padding: 0 0 20px; border-bottom:2px solid #333; font-size:24px; color:#232323; line-height: 26px;}
.product_view table th,
.product_view table td { padding:14px 0; font-size: 15px; color:#444; text-align: left;}
.product_view table td.price { font-size: 22px;}
.product_view table td.total { font-size:19px; color:#0a56a9;}
.product_view table td.total b { font-size: 22px;}
.product_view table .length { position: relastive; width: 71px; height: 32px; border:1px solid #c6c6c6;}
.product_view table .length input { width:44px; height: 30px; border:none;border-right:1px solid #c6c6c6; text-align:center; }
.product_view table .length a { overflow: hidden;position: absolute; right: 0; width: 26px; height: 16px; color:transparent;}
.product_view table select { width:100%; border:1px solid #c6c6c6; box-sizing: border-box;  background: url("../images/ico_select.png") no-repeat right 11px center;appearance:none; -webkit-appearance:none; -moz-appearance:none;}
.product_view table select::-ms-expand { display: none;}
.product_view .btns { padding: 45px 0 0; text-align: center;}
.product_view .btns > a { display: inline-block; width: 136px; height: 42px;border-radius: 2px; font-size: 16px; color:#fff; line-height: 42px; }
.product_view .btns > input.btn1 { background: #666; display: inline-block; width: 136px; height: 42px;border-radius: 2px; font-size: 16px; color:#fff; line-height: 42px;}
.product_view .btns > a.btn2 { background: #0a56a9;}
.middlebar {width: 971px; height: 60px; background-color: black; text-align:center; display: block; margin-top: 50px; line-height:50px;}
.middlebar a {color: white; text-align:center; margin:50px; font-size: 20px; vertical-align: middle; }

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../ShopHeader.jsp" />
</head>
<c:set var="templatePath" value="ShopController?command=product_detail_info&pseq=${product1.pseq}&info=" />
<body>
<form method = "post" name="formm" action = "ShopController?command=cart_add">
	
	<div class="product_view">
		<h2>${product1.name}</h2>
		<h3>${product1.content }</h3>		
		<table>
			<colgroup>
			<col style="width:173px;">
			<col>
			</colgroup>
			<tbody>
			<tr>
				<th>판매가</th>
				<td class="price">${product1.price2 }</td>
			</tr>
			<tr>
				<th>구매수량</th>
				<td>
					<div class="length">
						<input type="number" min="1" value="1" name="quantity">						
					</div>
				</td>
			</tr>
			<tr>
				<th>Size</th>
				<td>
					<select>
					<option>Small</option>
					<option>Medium</option>
					<option>Large</option>
					<option>X-Large</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>Color</th>
				<td>
					<select>
					<option>Red</option>
					<option>Black</option>
					<option>Blue</option>
					<option>Beige</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>배송비</th>
				<td>무료배송</td>
			</tr>
			<tr>
				<th>결제금액</th>
				<td class="total"><b>${product1.price2 }</b>원</td>
				
			</tr>
			</tbody>
			
		</table>
		
		<div class="img">
			<img src="product/images/${product1.image }" alt="">
		</div>
		<input type="hidden" value="${product1.pseq}" name="pseq"/>
		<div class="btns">
			<input type="submit" class="btn1" value="장바구니">
			<a href="#" class="btn2" onclick="go_order_insert()">구매하기</a>			
		</div>
		
	</div>
		
	<div class="middlebar">
		<a href="${templatePath }detail_info">DETAIL</a>
<%-- 		<a href="${templatePath }qna">QnA</a> --%>
		<a href="${templatePath }review_list">REVIEW</a> 
		<!-- <a href="ShopController?command=review_list">review</a> -->
		<a href="${templatePath }kind_list&kind=${product1.kind}">관련상품</a>
		<!-- <a href="ShopController?command=RelatedProduct&kind=1">관련상품</a> -->
	</div>	
	
	<div>
 			<%-- <c:if test="${!empty isResult}"> --%>
				<jsp:include page="${actionPath }" flush="false"/>
	  		<%-- </c:if> --%>
	</div>
	
	
	</form>
<%@ include file="../footer.jsp" %>    