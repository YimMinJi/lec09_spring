<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="<c:url value='/resources/css/member/join.css' />" rel="stylesheet" type="text/css">
</head>
<body>	
	<jsp:include page="../include/header.jsp"/>
	<jsp:include page="../include/nav.jsp"/>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>회원가입</h3>
			</div><br>
			<div class="create_account_form">
				<form id="memberAddFrm">
					<input type="text" name="user_id" placeholder="아이디"> <br>
					<input type="password" name="user_pw" placeholder="비밀번호"> <br>
					<input type="password" name="user_pw_check" placeholder="비밀번호 확인"> <br>
					<input type="text" name="user_name" placeholder="이름"> <br>
					<input type="submit" value="회원가입"> 
				</form>
			</div>
			<div class="login">
				<a href="<c:url value='/loginPage' />">로그인</a>
			</div>
		</div>
	</section>
	<script>
		/* fetch 할거야. 어떤 fetch? 회원가입 fetch */
		const form = document.getElementById('memberAddFrm');
		// 데이터를 얹어서 보내야해. json타입이니까

		form.addEventListener('submit',function(event){
			event.preventDefault();
			let object = {};
			const payload = new FormData(form);
			
		payload.forEach(function(value,key){
			object[key] = value; // form데이터로 만들어진, 데이터는 온전치 않다.
		});
		
		
		
		const jsonData = JSON.stringify(object); // json데이터 타입으로 억지로 변환시켜줘야해
		
			console.log(jsonData);
			fetch('<%=request.getContextPath()%>/join',{
				method : 'POST',
				headers : {
					"Content-Type" : "application/json;charset=utf-8", 
					"Accept" : "application/json",
					"X-CSRF-TOKEN" : "${_csrf.token}"
				},
				body : jsonData
			})
			.then(response => response.json())
			.then(data =>{
				console.log(data);
			})
		});
	</script>	
</body>
</html>