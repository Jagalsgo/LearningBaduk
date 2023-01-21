# Learning Baduk

## 연락처
- 메일 : ehdwns6781@naver.com

## 개요
1. 인원 : 1명
2. 기간 : Apr 25 ~ Aug/10 2022 (~ 유지보수, 기능추가)
3. 소개 : 스프링 부트를 사용한 게시판 기능 구현
4. 사이트 : https://learningbaduk.cf

## 기술 및 환경
- OS : windows
- DB : MySQL 8.0.23
- Server : AWS tomcat8
- Framework : spring boot 2.6.7, myBatis 2.2.2, bootstrap
- language : java8
- Tool : eclipse, mysqlWorkBench

## 주요 기능
- 스프링 시큐리티를 이용한 로그인
- 게시글 좋아요, 신고 기능
- 유저 신고, 쪽지 보내기 기능
- 내 게시글에 댓글, 쪽지를 받았을 시 알림 기능
- 관리자 기능 (게시글, 댓글 삭제, 신고당한 게시글, 유저 관리)

## 프로젝트 진행 중 겪은 어려움
- 스프링 시큐리티 비밀번호 암호화를 이용한 로그인, DB를 통한 회원 정보 관리
- 로컬에서 작동하지만 배포할 때 작동하지 않는 어려움
- ec2에서 war를 배포하고 db, elb, dns 등을 연동하는 환경 설정

## 사이트 설명
<br/>
### 테스트 아이디 : idman6, 비밀번호 : manman1!
<br/>
![index 페이지](https://user-images.githubusercontent.com/66861741/208291845-859aa0fa-92c2-413f-bdd8-1be53b3ff7b1.PNG)
### ✏️ 기본 index 화면입니다. 각 카테고리에 있는 최신 글들을 간략하게 보여줍니다.
<br/><br/><br/><br/><br/>
![로그인](https://user-images.githubusercontent.com/66861741/208292022-34804f7e-1426-44c8-944d-6e2717081ba4.PNG)
### ✏️ 로그인 화면입니다.
<br/><br/><br/><br/><br/>
![회원가입](https://user-images.githubusercontent.com/66861741/208292044-89bfc7d2-873b-4021-b253-c2e17b3d7408.PNG)
### ✏️ 회원가입 화면입니다. 아이디, 닉네임, 이메일 중복 검사를 해야 하고 이메일 인증 후 로그인이 가능합니다.
<br/><br/><br/><br/><br/>
![아이디, 비밀번호 찾기](https://user-images.githubusercontent.com/66861741/208292198-e006e487-c718-4afc-ba12-c926309f8b78.PNG)
### ✏️ 아이디, 비밀번호를 찾는 화면입니다. 아이디는 이메일과 매칭되는 아이디를 알려주고 비밀번호는 해당 이메일로 임시 비밀번호를 전송합니다.
<br/><br/><br/><br/><br/>
![회원 정보 수정](https://user-images.githubusercontent.com/66861741/208292339-ae4da742-8724-464b-867e-bdc219596ea4.PNG)
### ✏️ 회원 정보 수정 화면입니다. 프로필 사진 삽입, 수정 등 회원 정보 수정이 가능하고 수정 시 기존 비밀번호 입력이 필요합니다.
<br/><br/><br/><br/><br/>
![게시판 board](https://user-images.githubusercontent.com/66861741/208292243-6814744d-5e77-47a2-a2a9-a8e5855746ff.PNG)
### ✏️ 게시판 화면입니다. 검색이 가능하고 로그인 시 글 작성이 가능합니다.
<br/><br/><br/><br/><br/>
![글 detail](https://user-images.githubusercontent.com/66861741/208292268-3d7d6066-0f98-4317-a3ac-c710c5e22487.PNG)
### ✏️ 게시판 글 상세뷰 화면입니다. 좋아요, 싫어요 기능과 신고 기능이 있으며 글쓴이나 관리자는 해당 글을 삭제할 수 있습니다.
<br/><br/><br/><br/><br/>
![글 detail 댓글](https://user-images.githubusercontent.com/66861741/208292312-db65d85a-f3c3-4e3c-a28b-16ee0b86bfb1.PNG)
### ✏️ 상세뷰 댓글 화면입니다. 로그인 시 대댓글 작성이 가능하고 대댓글이 달려있는 원댓글이 삭제될 경우 (삭제된 댓글입니다) 라고 표시합니다.
<br/><br/><br/><br/><br/>
![쪽지](https://user-images.githubusercontent.com/66861741/208292375-7e15703d-2129-4a7f-895d-240adf04c82e.PNG)   
### ✏️ 쪽지함 화면입니다. 주고 받은 쪽지를 확인하고 쪽지를 보낼 수 있습니다.
<br/><br/><br/><br/><br/>
![회원 신고](https://user-images.githubusercontent.com/66861741/208292387-ad856f2c-2114-48f5-a4c3-4a9a14d54cd0.PNG)   
### ✏️ 회원 신고 화면입니다. 사유를 함께 작성할 수 있습니다.
<br/><br/><br/><br/><br/>
![나만의 게시판](https://user-images.githubusercontent.com/66861741/208292404-3ad14400-afb4-4c22-bab7-5dc4a8f24d32.PNG)
### ✏️ 나만의 게시판 화면입니다. 이곳에서 글 작성 연습이나 메모장으로 이용 등 자신만 확인할 수 있는 글 작성이 가능합니다.
<br/><br/><br/><br/><br/>
![내가 쓴 글](https://user-images.githubusercontent.com/66861741/208292399-c8225153-e268-4a8b-b25f-b9c731a22038.PNG)
### ✏️ 내가 쓴 글들을 보여주는 화면입니다. 나만의 게시판에 작성한 글을 제외한 내가 여러 게시판에서 작성한 글 리스트를 보여줍니다.
<br/><br/><br/><br/><br/>
![admin page](https://user-images.githubusercontent.com/66861741/208292434-3a022973-9312-4e4a-91e6-a66e4382c760.PNG)
### ✏️ 관리자 화면입니다. 이곳에서 신고당한 내역을 확인할 수 있고 회원 관리도 가능합니다.
<br/><br/><br/><br/><br/><br/><br/>

## ERD
![learningbaduk erd](https://user-images.githubusercontent.com/66861741/213089523-2e5e0ffc-a6c5-4f6d-9fbe-a85841d88af4.png)
