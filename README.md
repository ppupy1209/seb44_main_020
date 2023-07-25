
![ㄹㅇ로고](https://github.com/codestates-seb/seb44_main_020/assets/64067205/dcfa15c6-273e-4cd5-9827-d433a4239699)
<b>안녕하세요. <br>

MoovDa는 영화에 대한 평가와 리뷰를 자유롭게 공유하는 곳입니다.  <br>다른 사용자들의 의견을 듣고, 자신만의 영화 리스트를 만들어보세요. <br><br>

MoovDa에서는 영화 제목, 감독, 배우, 장르 등 다양한 정보를 활용하여 원하는 
영화를 정확히 검색할 수 있습니다. <br> 이를 통해 당신이 가장 마음에 드는 작품을 발견할 수 있을 거예요!  <br> <br> 

다양한 영화들을 살펴보고, 다른 사용자들과 의견을 공유하여 영화에 대한 새로운 관점을 얻어보세요.  <br>
좋아하는 영화, 추천하고 싶은 작품, 특별한 감동을 준 영화 등 다양한 주제로 이야기를 나누면서 즐거운 시간 보내시기 바랍니다.</b> <br> <br> 

### [Go To MoovDa | Project Result](https://github.com/codestates-seb/seb44_main_020) <br>
### [Go To Wiki | Project Record](https://github.com/codestates-seb/seb44_main_020/wiki) <br><br><br>


## MoovDa Page View <br>

- <b>Main Page</b>

![ezgif com-video-to-gif (1)](https://github.com/codestates-seb/seb44_main_020/assets/64067205/2ff34663-0d0f-45c2-bbde-85c5a8efd630) <br>





- <b>Movie Search Page</b>
- <b>Movie Detail Page</b>
- <b>Member Detail Page</b>
- <b>Question Page</b>
- <b>Answer Page</b>

<br><br><br>

## Team MoovDa <br>

### Frontend <br>

- <b>전수빈</b> <br>
회고 및 소감 작성해주세요.

<details>
<summary><b>전수빈 Worklog📜</b></summary>


<br>

 <b>Position</b> : Frontend

 <b>Stack</b> : 

 <b>Works</b> : 

1. 



</details>

- <b>안현지</b> <br>
회고 및 소감 작성해주세요.
<details>
<summary><b>안현지 Worklog📜</b></summary>

<br>

 <b>Position</b> : Frontend

 <b>Stack</b> : 

 <b>Works</b> : 

1. 페이지 UI 구성 및 피그마 이용해 프로토타입 구현
    * 메인 페이지
    * 질문 리스트 페이지
    * 질문 상세 페이지 

2. MainPoster 컴포넌트
    * props를 전달하여 조건부 렌더링
      * default : 영화 포스터 + 제목
      * 본영화 섹션에서 사용될 때, 별점 노출
      * 볼영화 섹션에서 사용될 때, (마이페이지의 삭제 버튼을 누르면) 삭제 아이콘 노출
    * styled-components의 ThemeProvider 적용 
      *  컴포넌트의 크기를 유동적으로 조정하여 여러 페이지에서 재사용할 수 있도록 함
    * 볼영화 삭제 기능 구현
    * 이미지 lazy loading 구현

3. MainPage
    * 자동 재생되는 캐러셀 슬라이더 구현
      * react-slick 라이브러리 사용 (centermode 적용)
    * 영화 포스터 조회 기능 구현

4. MyPage
    * UI 디자인 재구성
    * 로그인한 본인의 마이페이지인 경우와 타 사용자의 프로필을 클릭하여 방문하는 경우를 구분하여 조건부 렌더링
       * 로그인한 사용자 본인의 페이지인 경우에만 본 영화의 편집 버튼을 노출 <br>
         -> 클릭하면 메인 포스터 컴포넌트의 삭제 아이콘 노출
       * 로그인한 사용자 본인의 페이지인 경우에만 계정 관리 영역 노출
    * 볼 영화, 본 영화 리스트
        * react-slick 사용하여 캐러셀 슬라이더 구현 
        * 캐러셀 드래그 시 클릭 이벤트(영화 상세페이지로 이동) 실행되는 것 방지
    * 회원 정보 조회, 회원 삭제 기능 구현

5. MovieDetail Page
    * UI 디자인 재구성
    * 이미지 lazy loading 구현
    * 별점・코멘트 모달 팝업
    * 개별 코멘트 컴포넌트
    * 코멘트 페이지 네이션 적용
    * 볼 영화 리스트 추가, 기능 구현
</details>

- <b>강예현</b> <br>
회고 및 소감 작성해주세요.

<details>
<summary><b>강예현 Worklog📜</b></summary>

<br>

 <b>Position</b> : Frontend

 <b>Stack</b> : 

 <b>Works</b> : 

1. 

</details>

<br>

### Backend <br>


- <b>김연우</b> <br>
회고 및 소감 작성해주세요.

<details>
<summary><b>김연우 Worklog📜</b></summary>

<br>

 <b>Position</b> : Backend

 <b>Stack</b> : Spring Boot, Spring Data JPA, EC2, RDS, MySQL, QueryDSL

 <b>Works</b> : 

1. Movie

    * OPEN API 이용하여 영화 데이터 DB 저장
    * 영화 데이터 이용하여 영화 상세 페이지 구현
    * 장르, 나라, 연령, 별점 필터를 이용한 영화 검색 기능 구현(QueryDSL)
    * 메인 페이지 구현, GET 요청시 랜덤으로 영화 10개 응답    

2. Comment

   * 코멘트와 별점 기능 구현
   * 토큰을 이용하여 인증된 멤버만 수정, 삭제 가능

3. Watch

   * 보고 싶은 영화 기능 구현
   * 코멘트 작성 시 본 영화에 추가
   * Mypage에서 볼 영화, 본 영화 리스트 기능 구현

4. Deployment

   * AWS EC2, RDS(MySQL) 세팅
   * 로드밸런서를 이용하여 Scale-out 적용 <[Go To Notion | Record](https://heathered-creek-b2a.notion.site/AWS-Load-Balancer-d1ae72550d6a4248971d141fe56e2a64?pvs=4)>

5. Documentation
   
    * Git Wiki 작성 <[Go To Wiki | Record](https://github.com/codestates-seb/seb44_main_020/wiki)>
    * README 작성

</details>

- <b>정민우</b> <br>
회고 및 소감 작성해주세요.

<details>
<summary><b>정민우 Worklog📜</b></summary>

<br>

 <b>Position</b> : Backend

 <b>Stack</b> : 

 <b>Works</b> : 

1. 

</details>

- <b>김민성</b> <br>
회고 및 소감 작성해주세요.

<details>
<summary><b>김민성 Worklog📜</b></summary>

<br>

 <b>Position</b> : Backend

 <b>Stack</b> : 

 <b>Works</b> : 

1. 

</details>
 
