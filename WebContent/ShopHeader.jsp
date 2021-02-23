<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="dto.UserInfo"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript" src="mypage/mypage.js"></script>
<link href="css/shopping.css" rel="stylesheet">
<style type="text/css">
/*   
    .skydiv { position: fixed; top: 10px; left: 10px;  } 
    .skydiv { border: 1px solid #790000; padding: 10px; }   
*/ 
    .skydiv { 
/* 		    position: fixed; top: 10px; left: 250px; */        
		    position: fixed; top: 10px; right: 50px; left : 50px;   
		    /* border: 1px solid #790000; padding: 0px; */  
		    /* width:971px; */		
/* 		        
			background-color:#FFFFFF;
    */
		    }
    #catagory_menu {
    	/* position: fixed; top: 10px; right: 50px; left : 50px; */		    
		/* width:971px; */				     
    }
    #top_menu{
    	position: fixed; top: 50px; right: 10px; left : 10px;    
		    /* border: 1px solid #790000; padding: 0px; */  
		    /* width:971px; */		    
			/* background-color:#FFFFFF; */
			color: #F90FFF;  
			font-weight: bold;
    }
	    
    .topimage { background-image: url(index/head2.png);width: 971px; height: 150px; display:block; margin: auto; object-fit: cover; background-repeat: no-repeat;padding:0px;}
     
    
</style>
<div id="wrap">
<header class="topimage">
<%--
	  <div id="logo" style="background-color:#ffff99;    
		color:#000000;height:0px;padding: 0px;">    
<!-- Shop Header Page -->
		  <a href="ShopController?command=index">		
			   <img src="images/model.jpg" width="100" height="100" alt="shopping"> 
	      </a>
      </div>
--%> 
<!-- 
<div clas="topimage"></div>
 -->
<div class="skydiv">
	<nav id="catagory_menu">
     <ul>
       <li>         
	     <a href="ShopController?command=index" style="width:100px;"> HOME</a>  
	    </li>
       <c:choose>
       <c:when test="${empty sessionScope.loginUser}">
	    <li> 
         <a href="ShopController?command=login_form" style="width:110px;">LOGIN</a> 
	   </li>		       
       <!-- <li>/</li> -->
       <li><a href="ShopController?command=contract">JOIN</a></li>
       </c:when>
       <c:otherwise>
       <li style="color:orange">
         ${sessionScope.loginUser.name}(${sessionScope.loginUser.id})
       </li>
       <li><a href="ShopController?command=logout">LOGOUT</a></li>
       </c:otherwise>       
       </c:choose>
       <!-- <li>/</li> -->
       <li>
         <a href="ShopController?command=cart_list">CART</a>
       </li>
       <!-- <li>/</li> -->
       <li>
         <a href="ShopController?command=mypage">MY PAGE</a>
       </li>
       <!-- <li>/</li> -->
       <li>
<!--          <a href="ShopController?command=qna_list">Q&amp;A[1:1]</a> -->
         <a href="ShopController?command=qna_list">Q&amp;A</a>
       </li>
     </ul>
    </nav>
</div>
	<div class="background1"></div>
    <nav id="top_menu">
      <ul>
        <li>
          <a href="ShopController?command=catagory&kind=1">TOP</a>    
        </li>  
        <li>
          <a href="ShopController?command=catagory&kind=2">BOTTOM</a>
        </li>  
        <li>
          <a href="ShopController?command=catagory&kind=3">ACC</a>
        </li> 
        <li>
          <a href="ShopController?command=catagory&kind=4">SHOES</a>
        </li> 
        <li>
          <a href="ShopController?command=catagory&kind=5">ETC</a>
        </li>  
      </ul>
    </nav>  
   
 		
    <!-- <hr> --> 
  </header>
