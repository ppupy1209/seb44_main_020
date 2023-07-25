
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
`직접 해보니 알겠다.` 기획부터 API 명세서, ERD, 개발 그리고 배포까지 모든 과정을 처음부터 끝까지 팀과 직접 했습니다. 이전에는 어느 정도 가이드가 있었거나,
텍스트로만 받아들이던 것들을 직접 해보니 "아 이렇게 하는 것이 이래서 중요하구나!" 를 몸소 깨달았습니다. 프로젝트를 시작하면 기능 구현 즉, 코드만 주구장창 작성할 줄 알았습니다.
현실은 그렇지 않았습니다. 초기에 기획 단계에서 왜 충분히 시간을 투자해야 하는지, 프로젝트 처음부터 끝까지 문서화가 왜 중요한지 깨달았습니다. 개발자에 대해 얘기할 때 소통이라는 키워드가
빠지지 않는데, 이전에는 크게 와닿지 않았으나 프로젝트를 진행하면서 프론트엔드 팀원들과 백엔드 팀원들 모두 소통할 일이 정말 많았고 의견 차이도 종종 있어서 서로 소통하며 해결한 경우도 있습니다.
아쉬운 점이 있다면, 코드 리뷰입니다. 내가 원하는 기능은 동작하는데 이 코드가 좋은 코드인지에 대한 고민이 항상 있었고 마땅히 물어볼 사람이나 여유가 없었습니다. 이 부분에 있어서 공부가 필요할 것 같습니다.
짧다면 짧고, 길다면 긴 기간동안 좋은 팀원들과 함께 프로젝트를 진행하여 정말 많은 것을 배웠습니다.
 

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
`협업의 중요성` 살아오면서 이렇게 다른 사람들과 제대로 협업을 했다고 느낀 것은 처음이었던 것 같습니다. 대학생 때도 프로젝트를 진행했었지만 그 때는 github를 이용하지 않아 개발자로 협업을 한다는 느낌이 많이 없었습니다. 하지만 코드스테이츠에서 여러 기술과 스택을 배우고, 좋은 팀원분들을 만나 좋은 협업 경험이 되었습니다. 
아쉬운 점은 제가 다른 팀원들에 비해 부족함이 많아서 팀원분들과 멘토분에게 이것 저것 많이 물어보고 구글링하며 작업을 해서 제가 만든 기능이 많지 않다는 것입니다.
그래도 session인증도 이해도 버거웠던 제가 oauth와 jwt 로그인 기능을 어느정도 완성했다는 것에 많이 보람을 느끼며 다음에 또 이런 기회가 찾아온다면 더 잘 코딩할 자신이 생겼습니다.  

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
 
