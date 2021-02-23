<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ include file="../ShopHeader.jsp" %>   
<%-- <%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.html" %>  --%>  
  <article>
    <h2>Join Us</h2>
    <form id="join" action="ShopController?command=join" method="post" name="formm">
      <fieldset>
        <legend>Basic Info</legend>
        <label>User ID</label>
        <input type="text"      name="id"        size="12"  >
        <input type="hidden"    name="reid">
        <input type="button" style="color: black"   value="중복 체크"  class="dup" onclick="idcheck()"><br>
        <label>Password</label> 
        <input type="password"  name="pwd"><br> 
        <label>Retype Password</label> 
        <input type="password"  name="pwdCheck"><br> 
        <label>Name</label>
        <input type="text"      name="name"><br> 
        <label>E-Mail</label>
        <input type="text"      name="email"><br>        
      </fieldset>
      <fieldset>
        <legend>Optional</legend>        
        <label>Zip Code</label> 
        <input type="text"       name="zipNum"   size="12" >        
        <input type="button"  style="color: black"   value="주소 찾기" class="dup" onclick="post_zip()"><br>
        <label>Address</label> 
        <input type="text"        name="addr1"   size="28"><br>   
        <label>Detailed address</label> 
        <input type="text"        name="addr2"   size="40"> <br> 
        <label>Phone Number</label> 
        <input  type="text"       name="phone"><br>        
      </fieldset>
      <div class="clear"></div>
      <div id="buttons">
        <input type="button" style="color: black"   value="회원가입"   class="submit" onclick="go_save()"> 
        <input type="reset"  style="color: black"    value="취소"     class="cancel">
      </div>
    </form>
  </article>
<%@ include file="../footer.jsp" %>
  