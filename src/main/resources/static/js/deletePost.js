//포스트를 삭제하고 홈으로 이동하는 Ajax
let deletePost = {

	init: function() {
		let _this = this;
		
		$("#btn-deletePost").on("click", () => {
			_this.deletePost();
		});
	},
	
	deletePost: function() {
	
		var	id = $("#id").val()
		
		$.ajax({
			type: "DELETE", //요청방식
			url: "/post/"+id, //요청url
						
		}).done(function(response) {
			alert(response);
			location = "/";
		});

	}
}
 
deletePost.init();

