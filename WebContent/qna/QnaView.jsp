<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dto.ProductVO"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
.qnaview {display: block; margin: auto;}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table class="qnaview">
		<tr>
			<td>
				<table width="100%" cellpadding="0" cellspacing="0" border="0">
					<tr>
						<h2>1:1 고객 게시판</h2>
						<h3>고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
					</tr>
				</table>
				<table>
					<tr>
						<td align="center">제목</td>
						<td><input name="subject" size="50" maxlength="100">${qna.subject}</td>
					</tr>
					
					<tr>
						<td align="center">등록일</td>
						<td><input name="indate" size="50" maxlength="50">
						<fmt:formatDate value="${qna.indate}" type="date" /></td>
					</tr>
					
					<tr>
						<td align="center">질문내용</td>
						<td><textarea name="content" cols="52" rows="5">${qna.content }</textarea></td>
					</tr>
					
					<tr>
						<td align="center">답변내용</td>
						<td><textarea name="reply" cols="52" rows="5">${qna.reply}</textarea></td>
					</tr>


					<!--      <tr height="1" bgcolor="#dddddd"><td colspan="4"></td></tr>
     <tr height="1" bgcolor="#82B5DF"><td colspan="4"></td></tr>
     <tr align="center">
     </tr> -->


				</table>
				<div class="clear"></div>
				<div id="buttons" style="float: right">
					<input type="button" value="목록보기" class="submit"
						onclick="location.href='ShopContoller?command=qna_list'">
					<input type="button" value="쇼핑 계속하기" class="cancel"
						onclick="location.href='ShopController?command=index'">
				</div>
				</form>
				</article>
</body>
</html>