//회원가입 연결 Ajax
let userObject = {

	init: function() {
		let _this = this;
		
		$("#btn-insert").on("click", () => {
			_this.insertUser();
		});
	},
	
	insertUser: function() {
		alert("회원 가입 요청됨");
		
		let user = {
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		}		

		$.ajax({
			type: "POST", // 요청 방식
			url: "/auth/user", // 요청 path
			data: JSON.stringify(user), //객페를 JSON 타입으로 변환
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
			alert(response);
			location = "/";
		});

	}
}
 
// userObject 객체의 init() 함수 호출. 
userObject.init();

