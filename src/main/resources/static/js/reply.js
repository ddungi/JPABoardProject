//댓글 입력하고 해당 포스트로 다시 이동하는 Ajax
let replyObject = {
	
	init: function() {
		let _this = this;
		
		$("#btn-reply").on("click", () => {
			_this.insertReply();
		});
	},
	
	
	insertReply: function() {
		var id =$("#id").val();
		let reply = {
			content : $("#replyContent").val()
		}	
		$.ajax({
			type: "POST", //요청방식
			url: "/reply/"+id , //요청 url
			data: JSON.stringify(reply), //객페를 JSON 타입으로 변환
			contentType: "application/json; charset=utf-8",
		
		}).done(function(response) {
			alert(response);
			location="/posts/"+id;
		});

	}
}
 
replyObject.init();

