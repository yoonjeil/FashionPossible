<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ include file="../ShopHeader.jsp" %>  
<%-- <%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.html" %>   --%> 
  <article>
    <h2>Join Us</h2>
    <form id="join" action="ShopController?command=join_form" method="post" name="formm">
		<br>
         제 3자에게 제공되지 않으며, 철저히 보호되고 있사오니 안심하고 이용하시기 바랍니다.
        <br><br>
       <textarea rows="15" cols="100">
			개인정보 수집•이용 동의서
'패션파서블'은 (이하 '회사'는) 
고객님의 개인정보를 중요시하며, "정보통신망 이용촉진 및 정보보호"에 관한 법률을 준수하고 있습니다.

회사는 개인정보취급방침을 통하여 고객님께서 제공하시는 개인정보가 어떠한 용도와 방식으로 이용되고 있으며,

개인정보보호를 위해 어떠한 조치가 취해지고 있는지 알려드립니다.



■ 수집하는 개인정보 항목

회사는 회원가입, 상담, 서비스 신청 등등을 위해 아래와 같은 개인정보를 수집하고 있습니다.

ο 수집항목 : 이름 , 생년월일 , 성별 , 로그인ID , 비밀번호 , 비밀번호 질문과 답변 , 자택 전화번호 , 자택 주소 , 휴대전화번호 , 이메일 , 직업 , 법정대리인정보 , 신용카드 정보 , 은행계좌 정보 , 서비스 이용기록 , 접속 로그 , 쿠키 , 접속 IP 정보 , 결제기록

■ 개인정보의 수집 및 이용목적

회사는 수집한 개인정보를 다음의 목적을 위해 활용합니다..

ο 서비스 제공에 관한 계약 이행 및 서비스 제공에 따른 요금정산
콘텐츠 제공 , 구매 및 요금 결제 , 물품배송 또는 청구지 등 발송 , 금융거래 본인 인증 및 금융 서비스
ο 회원 관리
회원제 서비스 이용에 따른 본인확인 , 개인 식별 , 불량회원의 부정 이용 방지와 비인가 사용 방지 , 가입 의사 확인 , 연령확인 , 만14세 미만 아동 개인정보 수집 시 법정 대리인 동의여부 확인 , 불만처리 등 민원처리 , 고지사항 전달
ο 마케팅 및 광고에 활용
접속 빈도 파악 또는 회원의 서비스 이용에 대한 통계


■ 개인정보의 보유 및 이용기간

회사는 개인정보 수집 및 이용목적이 달성된 후에는 예외 없이 해당 정보를 지체 없이 파기합니다.

       </textarea> 
      <br><br>
      <div style="text-align: center;">
      <input type="radio" name="okon1" checked> 동의함 &nbsp; &nbsp; &nbsp;
      <input type="radio" name="okon1" checked> 동의안함
      </div>
      <input type="button" value="Next"  class="submit"  onclick="go_next()" style="float: right;color: black;"> 
    </form>
  </article>
<%@ include file="../footer.jsp" %>  