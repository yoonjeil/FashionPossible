<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ include file="../ShopHeader.jsp" %>
<script type="text/javascript" src="js/list.js"></script>
<script type="text/javascript">
var cnt = 0;
var data;  
window.onload = function() {	 
	  data = new Array();
	  <c:forEach items="${bob_images}" var="item">
	  data.push('${item}');
      </c:forEach>	
	  getImage("img1", data[0]);
	  getImage("img2", data[1]);
};
function bobTop(){
	const res = imgtemp.split('/');	
	document.getElementById('main_bob').innerHTML 
	  = "BestOfBest<img id='img1' src='" + imgtemp + "' width='200px' hight='200px' onclick=location.href='ShopController?command=product_detail&bob=" + res[res.length-1] + "'>";
}

</script>
 
  <!--메인 이미지 들어가는 곳 시작 --->
  <div class="clear"></div>
  <div id="main_img">
    <img src="image/index/main1.PNG" width="100%" hight="300px" ><br>
	    <div id="main_bob">
	<!--     <img src="image/index/main2.jpg" width="50%" hight="300px" ><img src="image/index/main3.jpg" width="50%" hight="300px" > -->
		    <img id="img1" src="image/index/main2.jpg" width="200px" hight="200px" onclick="choice1('${bob_images}')" ><img id="img2" src="image/index/main3.jpg" width="200px" hight="200px" onclick="choice2('${bob_images}')" >
		    
    	</div>       
  </div>   
  <!--메인 이미지 들어가는 곳 끝--->
<style>
  #img1{    
	  /* width: 45%; */
	  width: 50%;
	  height: 300px;
	  object-fit: cover;  
	  /* padding-right:10%; */    
  }     
   #img2{    
	  /* width: 45%; */ 
	  width: 50%;
	  height: 300px;    
	  object-fit: cover;
  }
</style>
  
  
  <div class="clear"></div>   

  <div id="front">   
    <h2> Best Item</h2>     
    <div id="bestProduct">         
      <c:forEach items="${best }"  var="product">
        <div id="item">
          <a href="ShopController?command=product_detail&pseq=${product.pseq}" style="color: black">
            <img src="product/images/${product.image}" />
            <h3> ${product.name} </h3>    
            <p>${product.price2} </p>
          </a>    
        </div>
      </c:forEach>      
    </div>
   <div class="clear"></div>
     
    <h2> New Item</h2>     
      <div id="bestProduct">         
        <c:forEach items="${news}"  var="product">
          <div id="item">
           <a href="ShopController?command=product_detail&pseq=${product.pseq}" style="color: black">
             <img src="product/images/${product.image}" />
           <h3> ${product.name} </h3>    
           <p>${product.price2} </p>
        </a>  
      </div>
    </c:forEach>      
  </div>
  <div class="clear"></div>
  </div>
<%@ include file="../footer.jsp" %>