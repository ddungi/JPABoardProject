//post를 입력하고 홈으로 이동하는 Ajax
let postObject = {

	init: function() {
		let _this = this;
		
		$("#btn-insert").on("click", () => {
			_this.insertPost();
		});
	},
	
	insertPost: function() {
		alert("1:1 문의 등록 요청됨");
		
		let post = {
			title : $("#title").val(),
			content : $("#content").val()
		}		

		$.ajax({
			type: "POST", //요청방식
			url: "/post", //요청url
			data: JSON.stringify(post), //객페를 JSON 타입으로 변환
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response);
			location = "/";
		});

	}
}
 
// postObject 객체의 init() 함수 호출. 
postObject.init();

