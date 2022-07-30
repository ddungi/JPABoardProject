//댓글 삭제하고 해당 포스트로 다시 이동하는 Ajax
let deleteReply = {
	init: function() {
		let _this = this;
		$("button[name=btn-deleteReply]").on("click", function() {   
			_this.deleteReply(this.value); 
		});
	},
	deleteReply: function(seq) {
		var id =  $("#id").val(); 
		$.ajax({ 
			type: "DELETE", //요청 방식
			url: "/reply/"+seq //요청 url
		}).done(function(response) {
			alert(response);
			location = "/posts/"+id;
		});
	}
}
deleteReply.init();
