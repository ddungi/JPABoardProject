<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container mt-3">
<form>
<input type="hidden" id="id" value="${post.id}" />
<div class="mb-3">
	<label for="title">Title:</label> 
	<input type="text" class="form-control" id="title" value="${post.title}">
</div>
<div class="mb-3">
	<label for="content">Content:</label> 
	<textarea class="form-control" rows="5" id="content" >${post.content}</textarea>
</div>
</form>

<button class="btn btn-secondary" onclick="history.back()">돌아가기</button>
<button id="btn-updatePost" class="btn text-black" style="background-color: yellow;">포스트수정</button>
</div>

<script>
$(document).ready(function () {
    $("#content").summernote({
        height: 300
    });
});
</script>

<script src="/js/updatePost.js"></script>

<%@ include file="../layout/footer.jsp"%>
