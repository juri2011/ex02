# ex02_2
Spring Framework 기반으로 국비지원 수업 때 진행된 게시판 CRUD 실습 예제 프로젝트입니다.

## :computer: 개발 환경
* `JAVA11`
* `javascript`
* `STS3`
* `MySql`
* `Spring` `MyBatis`

## :memo: 요구사항
### 게시글 등록
|주요기능(함수)|설명|SQL
|---|---|---|
|`saveForm()`|save.jsp 화면으로 이동|
|`save()`|사용자로부터 입력을 받아 게시글을 등록|insert|
### 게시글 리스트 조회
|주요기능(함수)|설명|SQL
|---|---|---|
|`findAll()`|사용자로부터 입력을 받아 게시글을 등록|select(selectList)|
### 상세 페이지 조회
|주요기능(함수)|설명|SQL
|---|---|---|
|`findById()`|아이디로 특정 게시 정보를 얻음|select(selectOne)|
|`updateHits()`|조회수 증가|update|
### 삭제
|주요기능(함수)|설명|SQL
|---|---|---|
|`deleteForm()`|상세페이지로부터 id값을 받아서 해당 게시물 삭제|delete|
### 수정
|주요기능(함수)|설명|SQL
|---|---|---|
|`updateForm()`|update.jsp로 이동|
|`update()`|사용자로부터 입력한 값을 받아서 게시글 수정|update|
|`findById()`|update() 실행 이후의 최신 정보를 가져옴|select(selectOne)|
|`onclick=updateReqFn()`|비밀번호 확인 : 맞는 경우만 수정|update|
### 페이지 리스트
|주요기능(함수)|설명|SQL
|---|---|---|
|`paging()`|paging.jsp로 이동|
|`pagingList()`|현재 페이지에 출력될 게시물 리스트를 받아옴|select(selectList)|
|`pagingParam()`|BoardService에서 현재 페이지의 정보를 PageDTO에 담아서 Controller에 전달|
|`boardCount()`|BoardRepository에서 DB로부터 전체 게시글 수를 받아옴|select(selectOne)|
## :open_file_folder: 구조
### 클래스
* HomeController
* BoardController
* ModelDTO
* PageDTO
* BoardService
* BoardRepository
### views
* index.jsp
* save.jsp
* list.jsp
* detail.jsp
* update.jsp
* paging.jsp
## :wrench: 개선사항

## :bulb: 알게 된 점
* Controller에서 jsp파일의 이름을 return값으로 전달하는 것과 redirerct: URL을 return값으로 전달하는 것이 어떻게 다른지 알 수 있었다.
* SQL문의 limit 구절을 이용해서 어떻게 게시글을 페이지별로 출력 하는지 확인해 볼 수 있었다.
* 표시될 페이지의 수와 게시글의 수를 구하는 방법을 코드로 작성하면서 다른 방식으로도 처리할 수 있겠다는 생각이 들었다.
