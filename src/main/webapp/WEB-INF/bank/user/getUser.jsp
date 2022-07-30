<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
<c:set var="year" value="${user.createDate.year+1900}"/>
<c:set var="month" value="${user.createDate.month+1}"/>
<c:set var="day" value="${user.createDate.date}"/>
<br>
<div class="container-fluid mt-3">
		<div class="m-3">
			<p><b>ID :</b> ${user.username}</p> 
		</div>
		<div class="m-3">
			<p><b>Email :</b> ${user.email}</p> 
		</div>	
		<div class="m-3">
			<p><b>계정 생성 날짜 :</b> ${year} 년 ${month} 월 ${day} 일</p> 
		</div>	
		
		<div class="m-3">
			<p><b>작성하신 포스트 목록 : </b> </p> 
		
		<table >
			<c:forEach var="post" items="${user.posts}">
			<tr >
				<td >
					<h4>${post.title}</h4>
					<a href="/posts/${post.id}" class="btn btn-outline-primary">상세 보기</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</div>
		
		<div class="m-3 pt-3">
			<p><b>작성하신 댓글 목록 : </b> </p> 
	
		<table>
		<c:forEach var="reply" items="${user.replies}">
			<tr><td>댓글 내용 : ${reply.content}</td></tr>
			<tr><td><a href="/posts/${reply.post.id}" class="btn btn-outline-primary">해당 게시물로 이동</a></td></tr>
		</c:forEach>
		</table>
		</div>	
		
		<div class="m-3">
		<a href="/" class="btn btn-warning"> 돌아가기</a>			
		</div>
</div>


<%@ include file="../layout/footer.jsp"%>








