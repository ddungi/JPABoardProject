# JPABoardProject

- JAVA : v17, Tomcat : v9.0, Spring Boot : v2.7.1, H2(DB) : v1.4.199
-  BootStrap : v5.1.3, JQuery : v3.6.0, Summernote : v0.8.10
- [프로젝트 회고록](https://ddungi.github.io/project/2022/08/01/jpaToyProject/)
 <a id='target'></a>

<br>

- JPA와 Spring Boot, Spring Security를 이용한 게시판 프로젝트입니다.
- 은행의 1:1 상담 게시판입니다.

<br>

![기본 웰컴페이지](https://user-images.githubusercontent.com/88040158/182083748-553c85e8-0379-47b9-a651-6d2afbd3bf8e.png)

- 첫 게시판 시작 화면입니다.
- 로그인하지 않으면 게시물을 확인할 수 없습니다.

<br>

![회원가입](https://user-images.githubusercontent.com/88040158/182084114-f467cce2-65c7-4a47-9df7-1eb5d4cfc47c.png)


![회원가입 성공](https://user-images.githubusercontent.com/88040158/182084126-e5c7ea91-a215-4d9d-befb-606ab077f15a.png)

- 회원가입에 성공하면 메세지를 띄어 다시 한 번 확인시켜 줍니다. 

<br>

![로그인 실패](https://user-images.githubusercontent.com/88040158/182084635-f05ae905-bbae-45a0-b0eb-9bf609552ccf.png)

- 로그인 페이지이며 관련 로직에는 Spring Security를 이용했습니다.
- 로그인에 실패할 경우 아래 발생한 오류에 따라 문구를 나타나게 했습니다
> - 아이디와 비밀번호에 관련한 예외는 같은 문구로 통일시켜 보안성을 좋게 했습니다. 

<br>

![로그인성공시 웰컴페이지](https://user-images.githubusercontent.com/88040158/182085000-14982be8-6bd9-4643-b2de-26b649e19e4c.png)

- 로그인에 성공시 메뉴 목록이 달라집니다.
- 회원 상세를 확인하거나, 1:1 글 문의를 남길 수 있습니다. 

<br>

![포스트등록 페이지](https://user-images.githubusercontent.com/88040158/182085267-d224fa27-5df5-4e73-a622-4c828c9c9e7a.png)

- 1:1 문의에서 글을 남길 수 있습니다.
- Summernote 라이브러리를 이용하여 다양한 작성 방법을 사용할 수 있게 했습니다.

<br>

![페이지 3개 이상이면 넘어감](https://user-images.githubusercontent.com/88040158/182085556-e48e6a11-4996-429d-b115-fc19074d4260.png)

- 포스트 3개씩 페이지에 표시하게 하였으며 3개 이전의 포스트는 페이지를 넘겨 확인할 수 있습니다. 

<br>

![작성자가 본 게시물](https://user-images.githubusercontent.com/88040158/182085743-b75c2e1d-ba30-4d02-97a5-118926a163c2.png)

- 포스트 작성자가 확인한 자신 포스트 상세보기 입니다. 
- 수정하기, 삭제하기가 가능합니다.
- 아래는 댓글 기능을 넣었으며 댓글 작성 당사자이면 삭제 버튼이 보이게 했습니다. 

![다른 사람이 본 게시물](https://user-images.githubusercontent.com/88040158/182085755-abd91d1c-319e-409a-b77a-415ed2799316.png)

- 포스트 작성자가 아닌 다른 사람이 본 포스트의 화면입니다.
- 다른 사람은 댓글만 작성할 수 있습니다. 

![자신 댓글 삭제](https://user-images.githubusercontent.com/88040158/182086190-89849d41-27b8-4b96-bcb0-5bdb71c4949b.png)

- 댓글을 삭제하면 메세지로 확인 후 삭제됩니다.

<br>

![포스트 수정](https://user-images.githubusercontent.com/88040158/182086380-2bb71b8f-bb6a-4d36-b135-e803de3a818f.png)

- 수정하기 화면입니다.

<br>

![회원 상세 페이지](https://user-images.githubusercontent.com/88040158/182086395-3569ab7a-ba95-4a3f-9d08-ae60029037e8.png)

- 회원 상세 페이지에서 자신이 작성한 포스트, 댓글 목록을 확인할 수 있으며 바로 이동할 수 있습니다. 

<br>

- DTO(User, Post, Reply)를 구현하여 Entity와 구분하여 사용하려 하였습니다. 
> - Controller, Service까지 DTO로 데이터를 전달하였고 Service 단에서 Entity로 변환하여 Repository에 전달하였습니다.
> - Entity는 DB에 저장되는 영속성 목적으로 사용되는 객체로 중요한 역할이므로 View, Controller와 Service 측에서 사용되는 것은 데이터 영속성 보존에 좋지 않다고 판단했습니다. 

<hr>

- Test Code 작성으로 코드를 검증하는 과정을 가졌습니다.
> - 전에는 서버를 직접 돌리거나 `System.out.print()` 메소드를 이용하여 코드를 검증했으나 직접 테스트 코드 작성을 통해 검증하려 했습니다.

<hr>

- 프로젝트 관련하여 더 많은 이야기는 프로젝트 회고록에 남기도록 하겠습니다.
- <a href="#target">궁금하다면 여기 클릭</a>

<br>

Reference : 
- 백엔드 개발자 양성 과정 _ 패스트 캠퍼스, 채규태 강사님 강의의 개인 프로젝트 결과물입니다. 