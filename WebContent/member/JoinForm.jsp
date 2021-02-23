<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../ShopHeader.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
<script type="text/javascript">
	function zipSearch(){
		url="zipSearch.jsp?search=n";
		window.open(url,"zipCodeSearch","width=500,height=350,scrollbars=yes");		
	}
</script>
</head>
<body>
<%-- <jsp:include page= "ShopHeader.jsp"/> --%>
<form action="/FashionPossible/ShopController?command=join" method="post">
		<table>
			<tr>
				<th align="center">ID</th>
				<td align="center">
				<input type="text" name= "id" size= "50" placeholder="아이디" style="height:30px; border: 1px solid gray;border-radius: 3px;" >
				</td>
			</tr>
			<tr>
				<th align="center">PASSWORD</th>
				<td align="center">
				<input type="text" name= "pwd" size= "50" placeholder="비밀번호" style="height:30px; border: 1px solid gray;border-radius: 3px;" >
				</td>
			</tr>
			<tr>
				<th align="center">NAME</th>
				<td align="center">
				<input type="text" name= "name" size= "50" placeholder="이름" style="height:30px;border: 1px solid gray;border-radius: 3px;" >
				</td>
			</tr>
			<tr>
				<th align="center">E-MAIL</th>
				<td align="center">
				<input type="text" name= "email" size= "50" placeholder="이메일" style="height:30px; border: 1px solid gray;border-radius: 3px;" >
				</td>
			</tr>
			<tr>
				<th align="center">ZIPNUM</th>
				<td align="center">
				<input type="text" name= "zip_num" size= "50" placeholder="우편번호" style="height:30px;border: 1px solid gray;border-radius: 3px;" >
				</td>
				<td><input name = "zipcode" size = "5"readonly>
				<input type = "button" value= "우편번호찾기" onclick="zipSearch()">
				</td>
			</tr>
			<tr>
				<th align="center">ADDRESS</th>
				<td align="center"><input type="text" name= "address" size= "50" placeholder="주소" style="height:30px;border: 1px solid gray;border-radius: 3px;" >
				</td>
			</tr>
			<tr>
				<th align="center">PHONE</th>
				<td align="center">
				<input type="text" name= "pn" size= "50" placeholder="전화번호" style="height:30px; border: 1px solid gray;border-radius: 3px;" >
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit"value="확인">
					<input type="reset" value="초기화">
				</td>
			</tr>
		</table>		
		</form>

</body>
</html>
<%@ include file="../footer.jsp" %>