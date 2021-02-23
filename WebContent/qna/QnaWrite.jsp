<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.board{width:90%;margin:auto;background:white;}
.buttons{width:90%;margin:auto;background:white;font-size:16px;padding-left: 10px;padding-right: 10px;}
.board_write{width:100%;table-layout:fixed;font-size:16px;color:black;}
.board_write tr td{height:100px;}
.board_write tr td div{padding-top:5px;padding-bottom:5px;}
.board_write tr .left{text-align:left;padding-left:10px;padding-right:10px;}
.text1{width:100%;height:35px;border-radius:5px;padding-left:10px;padding-right:10px;}
.ta1{width:100%;height:350px;border-radius:5px;}
.buttons{}
.button1{background:blue;color:white;border:none;padding:10px;border-radius:5px;}
.button2{background:red;color:white;border:none;padding:10px;border-radius:5px;}

</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%@ include file="../ShopHeader.jsp" %> 
	<div>
		<form action="ShopController?command=qna_write" method=post>
		<div class="board">
			<h5>QnA Write</h5>
			<table class="board_write">
			
				<tr>
					<td>
						<div>글제목</div>
						<div><input type="text" name="subject" class="text1"/></div>
					</td>
				</tr>
				<tr>
					<td >
						<div>내용</div>
						<div>
							<textarea name="content" rows="" cols="" class="ta1"></textarea>
						</div>
					</td>
				</tr>	
			</table>
		</div>
		<div class="buttons">
				<input type="submit" class="button1" value="작성완료">
				<input type="button" class="button2" value="취소"> <!-- 왜안되는거임?? -->
		</div>
		</form>
	</div>
<%@ include file="../footer.jsp" %>    