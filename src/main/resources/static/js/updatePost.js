//포스트를 수정하고 홈으로 이동하는 Ajax
let updatePost = {

	init: function() {
		let _this = this;
		$("#btn-updatePost").on("click", () => {
			_this.updatePost();
		});
	},
	
	updatePost: function() {
		
		let post = {
			id : $("#id").val(),
			title : $("#title").val(),
			content : $("#content").val()
		}		
		$.ajax({
			type: "PUT", // 요청 방식
			url: "/post", // 요청 path
			data: JSON.stringify(post), //객페를 JSON 타입으로 변환
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response);
			location = "/";
		});

	}
}
 
updatePost.init();

