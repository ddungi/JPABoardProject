<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
	<div class="mt-5 ">
		<h2>${post.title }</h2>
	</div>
	<div class="mt-3">

		<h4>${post.content }</h4>

	</div>
	<div class="mt-5 ">
		<p>
			포스트 번호 : <i>${post.id }</i><br> 작성자 : ${post.user.username }
		</p>
	</div>

	<button class="btn btn-secondary" onclick="location.href='/'">돌아가기</button>
	<c:if test="${principal.getUsername() eq post.user.username}">
		<a href="/post/${post.id}" class="btn text-black" style="background-color: yellow;">수정하기</a>
		<form style='display: inline;'>
			<input type="hidden" id="id" value="${post.id}" />
			<button type="button" id="btn-deletePost" class="btn btn-danger">삭제하기</button>
		</form>
		
	</c:if>

	<c:set var="contains" value="false" />
	<c:forEach var="reply" items="${replyList}">
		<c:if test="${principal.getUsername() eq reply.user.username}">
			<c:set var="contains" value="true" />
		</c:if>
	</c:forEach>

	<div class="mt-5">
		<table class="table" style="table-layout: fixed">
			<c:set var="replyList" value="${replyList}" />
			<c:if test="${!empty replyList}">
				<thead>
				<tr>
					<th width="80%">내용</th>
					<th >작성자</th>
					<th ><c:if test="${contains}">
							삭제
						</c:if></th>
				</tr>
				</thead>
			</c:if>
			<tbody>
			<c:forEach var="reply" items="${replyList}">
				<tr>
					<td width="80%"> ${reply.content }</td>
					<td> ${reply.user.username}</td>
					<td>
					<c:if test="${principal.getUsername() eq reply.user.username}">
							<form>
								<input type="hidden" id="id" value="${post.id}" />
								<button type="button" class="btn btn-secondary" name="btn-deleteReply" value="${reply.seq}">삭제</button>
							</form> 
					</c:if>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div class="mb-3">
			<textarea class="form-control" rows="2" id="replyContent"></textarea>
		</div>

		<div class=" text-lg-end">
			<form>
				<input type="hidden" id="id" value="${post.id}" />
				<button type="button" id="btn-reply" class="btn btn-secondary">댓글등록</button>
			</form>
				
		</div>

	</div>
</div>

<script src="/js/deletePost.js"></script>
<script src="/js/deleteReply.js"></script>
<script src="/js/reply.js"></script>

<%@ include file="../layout/footer.jsp"%>