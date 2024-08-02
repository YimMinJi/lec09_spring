<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href="<c:url value='/resources/css/board/create.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../include/header.jsp"/>
	<jsp:include page="../include/nav.jsp"/>
	<section>
		<div id="section_wrap">
			<div class="word">
				<h3>게시글 등록</h3>
			</div><br>
			<div class="register_board_form">
				<form id="boardAddFrm">	
					<input type="text" name="board_title" placeholder="게시글 제목을 입력하세요."> <br>
					<input type="text" name="board_content" placeholder="게시글 내용을 입력하세요."> <br>
					<input type="file" name="file"><br>
					<input type="submit" value="등록"> 
				</form>
			</div>
		</div>
	</section>
	<script>
		const form = document.getElementById('boardAddFrm');
		form.addEventListener('submit',(e)=>{
			e.preventDefault();
		// 판단의 기준 ==> 첫째, 성공했을때 말고 ,실패했을때를 먼저 한 후 진행해야 수정이 쉽다.
			let vali_check = false;
			let vali_text = "";
			// 유효성 검사중인거야
			if(form.board_title.value == ""){
				vali_text += '제목을 입력하세요';
				form.board_title.focus();
			} else if(form.board_content.value == ""){
				vali_text += '내용을 입력하세요.';
				form.board_content.focus();
			} else if (form.file.value == ""){
				vali_text += '이미지 파일을 선택하세요.';
				form.file.focus();
				// 여기 밑에 부분은 이미지파일을 유효성검사 하는거야
			} else if(form.file.value){
				const val = form.file.value;
				const idx = val.lastIndexOf('.');
				const type = val.substring(idx+1,val.length);
				if(type == 'jpg' || type == 'jpeg' || type == 'png'){
					vali_check = true;
				} else {
					vali_text += '이미지 파일만 선택 할 수있습니다.';
					form.file.value = '';
				}
			}
			
			
			// 만약에 vali_check가 false와 같다면
			if(vali_check == false){
				alert(vali_text);
			}else{
				// fetch 작업을 해주면된다.
				// board라는 자원을 입력하려는거야, 첫번째 매개변수는 컨텍스트패스
				// 두번째는 , 찍고 {여기 벌려}
				// const payload = new FormData(form); ==> body : payload 헷갈리지말라고
				// 요청보내고 응답 제대로 받을때, 
				const payload = new FormData(form);
				fetch('<%=request.getContextPath()%>/board',{
					method : 'POST',
					body : payload
				})
				.then(response => response.json())
				.then(data => {
					alert(data);
				})
			}
		});
	</script>
</body>
</html>