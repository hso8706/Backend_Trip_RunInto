## 필수 요구 사항

1. 메인 페이지
   - login navbar를 통해 로그인, 로그아웃 할 수 있다.
   - 2.번과 5.번의 관광지 검색 페이지로 이동할 수 있다.
   - 우리나라의 고궁 추천 탭을 볼 수 있다.
   - 우리나라의 강산을 소개하는 이미지를 볼 수 있다.

2. 지역별 관광지 검색 기능
   - 시/도와 군/구를 선택하고 해당 지역의 관광 시설을 제목으로 검색할 수 있다.
     - `like %[content]%` sql로 키워드 포함 문자열 조회
   - 시/도 내부의 군/구를 사용자가 선택할 수 있게끔 보여준다.
     - component별로 내부 요소 생성
     - 비동기 요청 - `fetch`를 통해 서블릿으로 직접 구현한 api로 get 요청
     - 반환된 `json`으로 페이지 리로딩 없이 드롭다운을 생성
     - `onchange` 이벤트 처리로 매번 시/도 선택시마다 군/구의 드롭다운 삭제 및 재생성

3. 카테고리 별 관광지 검색 기능
   - 관광지 유형을 선택하여 유형별 관광지를 선택할 수 있다.
     - 사진, 명칭, 유형, 상세 주소, 자세히보기에 대한 정보를 표로 확인할 수 있음.
     - 한 페이지에 10개의 정보가 담기고, 페이지는 총 5개가 보이도록 출력. 이후 페이지는 `다음`버튼을 통해 이동.
     - 명칭, 혹은 자세히 보기를 클릭하면 해당 관광지에 대한 상세 정보를 출력.
   - 키워드 검색 기능
     - `like %[content]%` sql을 사용하여 특정 키워드가 포함된 관광지만 출력할 수 있음
  
4. 로그인, 로그아웃
   - 로그인
     - 로그인 정보가 쿠키에 등록되지 않았을 경우, 메인 화면(상단 navbar)에 로그인 버튼이 뜨도록 설정
     - 로그인 버튼 클릭 시, 로그인 입력 화면으로 이동
     - 사용자의 id, pw를 입력받고 해당 로그인 정보를 유지할 지에 대한 체크박스 기능
     - 세션에 등록된 정보와 입력받은 사용자 정보가 일치할 경우 로그인되도록 구현
   - 로그아웃
     - 로그인 정보가 쿠키에 등록되어 있을 경우, 메인 화면에 로그아웃 버튼이 뜨도록 설정
     - 로그아웃 버튼 클릭 시, 로그인 정보를 삭제하고 로그인 상태를 해제하도록 설정
   - 추가 기능: 비밀번호 찾기
     - 로그인 페이지에서 비밀번호 찾기 기능 구현
     - id를 입력 후, 해당 id를 DB에서 검색 후 일치하는 id가 있을 경우 해당 id의 pw를 alert창에 구현
5. 회원정보 등록, 수정, 삭제, 조회
   - 등록
     - 회원 이름, 이메일, 아이디, 비밀번호, 주소, 생일, 성별을 입력하도록 구현
     - 입력된 정보를 DB에 저장하는 `회원가입`버튼과 입력된 정보를 다시 쓸 수 있도록 모두 지우는 `초기화`버튼 구현
     - 성공적으로 회원 등록이 된 경우, 메인 페이지로 이동
     - 회원 등록에 실패한 경우, 회원가입 페이지로 이동
   - 조회
     - 로그인 된 상태일 경우, 메인 페이지에서 회원 정보를 조회할 수 있는 `마이페이지`버튼 구현
     - 회원 등록 시 입력한 정보를 모두 볼 수 있음.
     - 회원 정보 수정 버튼과 회원 정보 삭제(탈퇴) 버튼 구현
   - 수정
     - 마이페이지 내에서 회원 정보 수정이 가능하도록 구현
   - 삭제
     - 마이페이지 내에서 회원 정보 삭제, 즉 탈퇴가 가능하도록 구현
     - 쿠키에서 id 조회 후, 해당 id와 일치하는 DB를 삭제하도록 구현
     - 세션에서도 해당 유저 정보 제거
     - 삭제 완료 시 메인 페이지로 이동

## 비고사항
- 이미지 로드 에러
  - 문제 상황
    - 프로젝트 내 이미지 파일 및 DB, 그리고 API를 통해 출력하는 이미지가 뜨지 않는 에러 발생
    - 추가로 .js 파일 또한 include가 안됨을 확인
  - 문제 해결
    - tomcat 자체 설정을 변경
    - tomcat 파일(예. `apache-tomcat-9.0.73`)/conf/web.xml 설정 변경
    - <servlet-mapping></servlet-mapping> 내부 코드에 설정 추가
    - `<servlet-name>default</servlet-name>`와 `<url-pattern>/</url-pattern>`는 변경 없이 유지, 해당 코드 아랫줄부터 코드 추가
    - 추가될 코드 <url-pattern>*.확장자</url-pattern>
```
<!--추가 코드-->
<url-pattern>*.js</url-pattern>
<url-pattern>*.css</url-pattern>
<url-pattern>*.png</url-pattern>
<url-pattern>*.ico</url-pattern>
<url-pattern>*.jfif</url-pattern>
<url-pattern>*.jpg</url-pattern>
```
  - 참고 링크; [https://rok93.tistory.com/entry/Tomcat%EC%84%9C%EB%B2%84-%EA%B5%AC%EB%8F%99%EC%8B%9C-jsp%EC%97%90%EC%84%9C-%EC%99%B8%EB%B6%80-css-js-%ED%8C%8C%EC%9D%BC%EC%9D%84-%EC%9D%B8%EC%8B%9D%ED%95%98%EC%A7%80-%EB%AA%BB%ED%95%98%EB%8A%94-%ED%98%84%EC%83%81]

## 애플리케이션 구성
1. 메인 페이지
  [Run Into.pdf](https://github.com/hso8706/SAF_PRACTICE/files/11090424/Run.Into.pdf)
2. 지역별 관광지 검색 기능
   - `Navbar` 및 `관광지 정보 검색하기`섹션에 `지역`버튼 클릭
    ![지역 버튼](https://user-images.githubusercontent.com/103169947/228268073-321dc6f4-2ec1-4491-8b80-61aedded0fdc.PNG)
   - 지역 초기 화면
    ![지역 초기](https://user-images.githubusercontent.com/103169947/228268147-f8db46c0-4c28-481f-83d6-09257857a579.PNG)
   - 지역만 검색
    ![지역 서울](https://user-images.githubusercontent.com/103169947/228268161-55fa6cf0-2e59-4d31-a6a3-aa02ffd2a99b.png)
   - 지역 및 키워드 검색
    ![지역 키워드](https://user-images.githubusercontent.com/103169947/228268171-8b6e811b-ceb0-42a4-b81f-5d8aa9fbf53d.PNG)
3. 카테고리 별 관광지 검색 기능
   - `Navbar` 및 `관광지 정보 검색하기`섹션에 `유형`버튼 클릭
    ![지역 버튼](https://user-images.githubusercontent.com/103169947/228268073-321dc6f4-2ec1-4491-8b80-61aedded0fdc.PNG)
   - 유형 초기 화면
    ![유형 초기](https://user-images.githubusercontent.com/103169947/228268823-4a60a18e-db01-430f-9ad3-fb79b66272ff.PNG)
   - 유형만 검색
    ![유형 키워드](https://user-images.githubusercontent.com/103169947/228268826-eec169dc-d95f-45c1-aac2-ad928f236199.PNG)
   - 유형 및 키워드 검색  
    ![유형 관광지](https://user-images.githubusercontent.com/103169947/228268828-97ecbaf0-8590-41e3-870e-2b82b53c7716.PNG)
4. 로그인
   - 로그인 버튼  
      <img width="386" alt="메인 로그인 버튼" src="https://user-images.githubusercontent.com/103169947/228278054-491023a1-ccea-48bc-a070-b30fd30e4ee4.png">
   - 로그인 페이지  
      <img width="1187" alt="로그인 입력 페이지" src="https://user-images.githubusercontent.com/103169947/228278429-44866f00-1b86-4665-9015-10fe86d45488.png">
5. 로그아웃
   - 로그아웃 버튼  
      <img width="910" alt="로그아웃 버튼" src="https://user-images.githubusercontent.com/103169947/228278804-e8e9120a-f637-4c53-ad73-fc2bfaaf74e3.png">
6. 비밀 번호 찾기
   - 비밀 번호 찾기 버튼  
      <img width="1187" alt="로그인 입력 페이지" src="https://user-images.githubusercontent.com/103169947/228278942-71ea4866-7a70-46ef-b14c-114364d192ce.png">
   - 비밀 번호 찾기 페이지  
      <img width="915" alt="비밀번호 찾기 페이지" src="https://user-images.githubusercontent.com/103169947/228279034-73265025-b16b-4e95-8d34-6a1093d55ab7.png">
   - 비밀 번호 alert  
      <img width="451" alt="비밀번호 alert" src="https://user-images.githubusercontent.com/103169947/228279085-4efb70eb-f3ab-48d3-8d5b-79d6a58c0923.png">
7. 회원 정보 등록
   - 회원 가입 버튼  
      <img width="386" alt="메인 로그인 버튼" src="https://user-images.githubusercontent.com/103169947/228279380-2f5a0104-4df8-4ab7-8d2d-88c4828de61c.png">
   - 회원 가입 페이지  
      <img width="926" alt="Untitled 2" src="https://user-images.githubusercontent.com/103169947/228279505-d389b7ec-cd41-4b09-8343-45bc0342f7c7.png">
8. 회원 정보 조회
   - 마이 페이지  
      <img width="734" alt="회원 정보 조회" src="https://user-images.githubusercontent.com/103169947/228280284-2b8d033b-971b-4b12-ae7f-a9d745ba7440.png">
9.  회원 정보 수정
    - 회원 정보 수정 버튼  
      <img width="731" alt="회원 정보 수정" src="https://user-images.githubusercontent.com/103169947/228280473-97dd6647-2989-407e-a4d7-478a5669540f.png">
1.  회원 정보 삭제
    - 회원 정보 삭제 버튼  
      <img width="772" alt="회원 정보 삭제" src="https://user-images.githubusercontent.com/103169947/228280730-0d460430-a32f-4739-9b0b-2f4eca8f810b.png">
