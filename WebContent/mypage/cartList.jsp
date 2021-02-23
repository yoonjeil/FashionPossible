<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ include file="../ShopHeader.jsp" %>  
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %> 

<script type="text/javascript">
function go_cart_delete() {	
	var count = 0;
	for (var i = 0; i < document.formm.cseq.length; i++) {
		if (document.formm.cseq[i].checked == true) {
			count++;
		}
	}
	if (count == 0) {
		alert("삭제할 항목을 선택해 주세요.");
	}else {
		document.formm.action = "ShopController?command=cart_delete";
	    document.formm.submit();
	}	
}
</script>
  <article>
    <h2> Cart List </h2>
    <form name="formm" method="post">
	    <c:choose>
	    <c:when test= "${cartList.size() == 0}">
	      <h3 style="color: red;text-align: center;"> 장바구니가 비었습니다. </h3> 
	    </c:when>
	    <c:otherwise>
			<table id="cartList">
		        <tr>
		          <th>상품명</th><th>수 량</th><th>가 격</th><th>주문일</th><th>삭 제</th>    
		        </tr>
		        <c:forEach items="${cartList}"  var="cart">
		        <tr>      
		          <td>
		            <a href="ShopController?command=product_detail&pseq=${cart.pseq}">
		              <h3> ${cart.pname} </h3>              
		            </a>    
		          </td>
		          <td> ${cart.quantity} </td>
		          <td> 
		            <fmt:formatNumber value="${cart.price2*cart.quantity}" 
		                              type="currency"/> 
		          </td>      
		          <td> <fmt:formatDate value="${cart.indate}" type="date"/></td>      
		          <td> <input type="checkbox" name="cseq" value= "${cart.cseq}"></td>
		        </tr>
		        </c:forEach>		         
		        <tr>        
		          <th colspan="2"> 총 액 </th>
		          <th colspan="2"> 
		            <fmt:formatNumber value="${totalPrice}" type="currency"/><br>
		          </th> 
		          <th><a href="#" onclick="go_cart_delete()"><h3>삭제하기</h3></a></th>                       
		        </tr> 
		      </table> 
      </c:otherwise>  
    </c:choose>     
    <div class="clear"></div>     
    <div id="buttons" style="float: right">
      <input type="button" value="쇼핑 계속하기" 
      				class="cancel" onclick="location.href='ShopController?command=index'">    
      <c:if test= "${cartList.size() != 0}">
     	 <input type="button" value="주문하기"  class="submit" onclick="go_order_insert()">
      </c:if>
     </div>
    </form>
  </article>
  
  
  
  
  
  
  
<%@ include file="../footer.jsp" %>


