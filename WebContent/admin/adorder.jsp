<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
</head>
<body>
	<h1>주문관리</h1>
<c:forEach items="${orderList}"  var="order">
	<table border="1">
	<tr>
        <th>상세주문번호</th> <th>주문번호</th><th>사용자id</th><th>날짜</th><th>상품번호</th><th>사용자이름</th><th>우편번호</th><th>주소</th><th>연락처</th>
        <th>상품명</th> <th>결제 금액</th> <th>주문 상세</th>   
      </tr>
       <tr>  
        <td> </td>
        <td> </td>    
        <td> </td>
        <td> </td>
        <td> </td>
        <td> </td>
        <td> </td>    
        <td> </td>
        <td> </td>
        <td> </td>
        <td> </td>
        <td> </td>
      </tr>
      </table>
      </c:forEach>
</body>
</html>