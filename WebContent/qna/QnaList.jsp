<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<script type="text/javascript">
function go_Qna_delete() {   
   var count = 0;
   for (var i = 0; i < document.formm.qseq.length; i++) {
      if (document.formm.qseq[i].checked == true) {
         count++;
      }
   }
   if (count == 0) {
      alert("삭제할 항목을 선택해 주세요.");
   }else {
      document.formm.action = "ShopController?command=qna_delete";
       document.formm.submit();
   }   
}

</script>
<html>
<head>

<style>
.margin {height:100px;width:100%;}
.button_margin {height:20px;width:100%;}
.board {max-width:1200px;width:100%;margin:auto;background:white;}
/*목록*/

.board_list_wrap {width: 962px;}
.board_list {border-top: 2px solid black; width: 100%; text-align: center;}
.board_list tr {border-bottom: 1px solid #ccc;}
.board_list th, .board_list td {padding: 10px;font-size: 14px;}
.board_list td {text-align: center;}
/*text-overFlow*/
.button1{background:blue;color:white;border:none;padding:10px;border-radius:5px;}
.button2{background:red;color:white;border:none;padding:10px;border-radius:5px;}
/*버튼*/

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../ShopHeader.jsp" %>
<c:if test="${!empty isResult }">
<c:set var="qnaList" value="${isResult }"/>
</c:if> 
<div>
<!-- 
	<h2>QnA List</h2>
	 -->
	 	<p>QnA List</p>
		<div class="board_list_wrap">
		<table class="board_list">
			
			<thead>
				<tr>
					<th><input type="checkbox" /></th>
					<th>번호</th>
					<th>제목</th>
					<th>등록일</th>
					<th>답변여부</th>
				</tr>
			</thead>
			<c:forEach items="${qnaList}" var="qnaList">
			<tbody>
				<tr>
					<td><input type="checkbox" /></td>
					<td> ${qnaList.qseq} </td>
					<td><a href="ShopController?command=qna_view&qseq=${qnaList.qseq}">${qnaList.subject}</a></td>
			<%-- 		<td>${qnaList.subject }</td> --%>
				<td> <fmt:formatDate value ="${qnaList.indate }" type="date"/></td>
				<td>
					<c:choose>
						<c:when test="${qnaList.rep==1 }">no</c:when>
						<c:when test="${qnaList.rep==2 }">yes</c:when>
					</c:choose>
				</td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
		<!-- <form action="ShopController?command=qna_write_form" method=post> -->
			<div class="buttons">
				<button type="button" class="button1"  onclick="location.href='ShopController?command=qna_write_form'">qna작성</button>
				<input type="button" class="button2" value="삭제" onclick="go_Qna_delete()">
			</div>
		<!-- </form> -->
	</div>
	</div> 