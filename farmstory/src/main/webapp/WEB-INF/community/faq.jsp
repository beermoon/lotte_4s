<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티-자주묻는질문</title>

    <link rel="stylesheet" href="../css/_header.css">
    <link rel="stylesheet" href="../css/_footer.css">

  <style>
    main {
        width: 100%;
        height: auto; /*수정*/
        margin: 0 auto;
    }

    main > .main_top {
        position: relative;
        width: 100%;
        height: 184px;
        background-image: url("../images/sub_top_bg.jpg");
    }

    main > .main_top > img {
        position: absolute;
        top: 137px;
        left: 10px;
    }

    main > .main_btm {
        width: 100%;
        height: auto;
        display: flex;
    }

    main > .main_btm > aside {
        position: relative;
        width: 176px;
        height: 650px;
    }

    main > .main_btm > aside > img:nth-child(1) {
        position: absolute;
        top: 16px;
        left: 16px;
    }

    main > .main_btm > aside > img:nth-child(2) {
        position: absolute;
        top: 40px;
        right: 0px;
    }

    main aside .list {
        position: absolute;
        top: 81px;
        right: 2px;
        width: 175px;
        height: 233px;
        background-image: url("../images/sub_aside_bg_lnb.png");
    }

    main aside .list > a > img {
        width: 175px;
        height: 29px;
        margin-top: 5px;
    }

    main aside .list > a:nth-child(1) > img {margin-top: 26px;}
    
    /*수정*/
    main .list > a:nth-child(1) > img:hover {background-image:url("../images/sub_cate5_lnb1_ov.png");}
    main .list > a:nth-child(2) > img:hover {background-image:url("../images/sub_cate5_lnb2_ov.png");}
    main .list > a:nth-child(3) > img:hover {background-image:url("../images/sub_cate5_lnb3_ov.png");}
    main .list > a:nth-child(4) > img:hover {background-image:url("../images/sub_cate5_lnb4_ov.png");}
   
    main > .main_btm > article {
        position: relative;
        width: 802px;
        height: 650px;
    }

    main > .main_btm > article > nav {
        position: absolute;
        left: 40px;
        width: 762px;
        height: 72px;
        border-bottom: 1px solid #C2C2C2;
        box-sizing: border-box;
        margin-bottom: 20px;
    }

    main > .main_btm nav > img {
        position: absolute;
        top: 41px;
    }

    main > .main_btm .nav_menu {
        position: absolute;
        right: 0px;
        top: 50px;
        display: flex;
    }

    main > .main_btm .nav_menu > img {width: 5px; height: 5px; margin: 6px;}
    main > .main_btm .nav_menu > p {color: #8c8c8c;}
    main > .main_btm .nav_menu span {color: #91BA15;}


    main > .main_btm > article > div {
        
        width: auto;
        height: 600px;
        box-sizing: border-box;
        margin-left: 30px;
        margin-top: 90px;
    }
    
    


    main > .main_btm > article > div > li{
        ;
    }

    main > .main_btm > article > div > ul:nth-child(1){
        width: auto;
        height: 50px;
        box-sizing: border-box;
       
    }

    main > .main_btm > article > div > ul:nth-child(1) > p{     
        padding-top: 27px;
        font-size:smaller;
        font-weight: 550;
        
        
    }
    main > .main_btm > article > div > ul:nth-child(1) > li{
        position: absolute;
        right: 0px;
        top:105px;
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(1) {
        width: auto;
        height: 60px;
        background-color: #eee9e9;
        box-sizing: border-box;
        
       
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(1) > li:nth-child(1) {
        float: left;
        width: 10%;
        height: 60px;
        
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(1) >li:nth-child(2) {
        float: left;
        width: 55%;
        height: 60px;
        
    }
    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(1) > li:nth-child(3) {
        float: left;
        width: 10%;
        height: 60px;
    
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(1) >li:nth-child(4) {
        float: left;
        width: 15%;
        height: 60px;
    }
    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(1) >li:nth-child(5) {
        float: left;
        width: 10%;
        height: 60px;
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol > li >p {
        margin-top: 17px;
        text-align: center;
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol > li >p:nth-child(7) {
        margin-top: 17px;
        
    }


    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(2) {
        width: auto;
        height: 60px;
        
    }
    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(2) > li:nth-child(1) {
        float: left;
        width: 10%;
        height: 60px;
        
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(2) >li:nth-child(2) {
        float: left;
        width: 55%;
        height: 60px;

        
    }
    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(2) > li:nth-child(3) {
        float: left;
        width: 10%;
        height: 60px;
        
    
    }

    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(2) >li:nth-child(4) {
        float: left;
        width: 15%;
        height: 60px;
    }
    main > .main_btm > article > div > ul:nth-child(2) > ol:nth-child(2) >li:nth-child(5) {
        float: left;
        width: 10%;
        height: 60px;
    }
    
    main > .main_btm > article > div > ul:nth-child(2){
        width: auto;
        height: 120px;
        box-sizing: border-box;
        border-top: 3px solid #585858;  
    }
   

    
    main > .main_btm > article > div > ul:nth-child(3){
        
        width: auto;
        height: 70px;
        box-sizing: border-box;      
        border-top:  2px solid #e0dfdf;
    }

    main > .main_btm > article > div > ul:nth-child(3) > li:nth-child(1){
        float: left;
        width: 70%;
        height: 70px;
        
    }
   
    main > .main_btm > article > div > ul:nth-child(3) > li:nth-child(1) > ol:nth-child(1){
        margin-top: 15px;
        margin-left: 350px;    
    }

    main > .main_btm > article > div > ul:nth-child(3) > li:nth-child(2){
        float: left; 
        width: 30%;
        height: 70px;     
    }
    
    main > .main_btm > article > div > ul:nth-child(3) > li:nth-child(2) > p {
           margin-top: 15px;
           margin-left: 180px;
    }
   

    main > .main_btm > article > nav > img {
        position: absolute;
        top: 41px;
        font-weight: 700;
        display: flex;
    }

   
   

    main > .main_btm  nav > div {
        position: absolute;
        display: flex;
        align-items: center;
        width: auto;
        top: 44px;
        right: 5px;
    }
    main > .main_btm  nav > div > ul {
       padding-right: 4px;
       padding-bottom: 7px;
    }
    main > .main_btm > article > nav a {
        font-size: 12px;
        font-weight: 400;
        color: #8C8C8C;
    }
    main > .main_btm > article > nav a:nth-child(4) {
        font-size: 12px;
        font-weight: 800;
        color: rgb(85, 133, 13);
        
    }

    
  </style>
</head>
<body>
    <div id="wrapper">
        <header>
            <img src="../images/head_top_line.png" alt="헤더 선">
            <a href="../main/main.html"><img src="../images/logo.png" class="header_logo" alt="로고사진"></a>
            <img src="../images/head_txt_img.png" alt="무료배송">
            <span class="home">
                <a href="../main/main.html">HOME</a>&thinsp;|&thinsp;
                <a href="../users/login.html">로그인</a>&thinsp;|&thinsp;
                <a href="../users/singup.html">회원가입</a>&thinsp;|&thinsp;
                <a href="../profile/cart.html">나의정보</a>&thinsp;|&thinsp;
                <a href="../main/main.html">로그아웃</a>&thinsp;|&thinsp;
                <a href="../admin-dashboard/dashboard.html">관리자</a>&thinsp;|&thinsp;
                <a href="#">고객센터</a>&thinsp;
            </span>
            <nav class="menu">
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../home/greeting.html"><img src="../images/head_menu1.png" alt="팜스토리 소개"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <img src="../images/head_menu_badge.png" alt="30%">
                    <a href="../shop/product-list.html"><img src="../images/head_menu2.png" alt="장보기"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../stories/farm-stories.html"><img src="../images/head_menu3.png" alt="농작물이야기"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../events/event-calendar.html"><img src="../images/head_menu4.png" alt="이벤트"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../community/notices.html"><img src="../images/head_menu5.png" alt="커뮤니티"></a>
                </div>
            </nav>
        </header>
        <main>
            <section class="main_top">
                <img src="../images/sub_top_tit5.png" alt="community">
            </section>
            <section class="main_btm">
                <aside>
                    <img src="../images/sub_aside_cate5_tit.png" alt="커뮤니티">
                    <img src="../images/sub_aside_bg_line.png" alt="목록선">
                    <div class="list"> <!--수정-->
                        <a href="../community/notices.do"><img src="../images/sub_cate5_lnb1.png" alt="공지사항"></a>
                        <a href="../community/today-menu.do"><img src="../images/sub_cate5_lnb2.png" alt="오늘의식단"></a>
                        <a href="../community/recipe-sharing.do"><img src="../images/sub_cate5_lnb3.png" alt="나도요리사"></a>
                        <a href="../community/customer-inquiry.do"><img src="../images/sub_cate5_lnb4.png" alt="1:1고객문의"></a>
                        <a href="../community/faq.do"><img src="../images/sub_cate5_lnb5_ov.png" alt="자주묻는질문"></a>
                    </div>
                </aside>
                <article>
                    <nav>
                        <img src="../images/sub_nav_tit_cate5_tit5.png" alt="자주묻는질문">
                        <div class="nav_menu">
                            <img src="../images/sub_page_nav_ico.gif" alt="#">
                            <p>HOME > 커뮤니티 > <span>자주묻는질문</span></p> <!--수정-->
                        </div>
                    </nav>
                    <div>
                        <ul>
                            <p>글목록</p>
                            <li>
                                <label> <input type="search" placeholder=" 제목 키워드, 글쓴이 검색" size="25;" style="height: 24px;"></label>
                                <input class="" type="button" value="검색" onclick="" style="width: 45px; height: 30px;">
                            </li>
                            
                        </ul>
                        <ul>
                            <ol>
                                <li>
                                    <p>번호</p>
                                </li>
                                <li>
                                    <p>제목</p>
                                </li>
                                <li> <p>글쓴이</p>
                                </li>
                                <li>
                                    <p>날짜</p>
                                </li>
                                <li>
                                    <p>조회</p>
                                </li>
                            </ol>
                            <ol>
                                <li>
                                    <p>1</p>
                                </li>
                                <li>
                                    <p>반품은 어떻게 해야하나요?</p>
                                </li>
                                <li> <p>관리자</p>
                                </li>
                                <li>
                                    <p>20-05-12</p>
                                </li>
                                <li>
                                    <p>12</p>
                                </li>
                            </ol>
                        </ul>
                        <ul>
                            <li>
                                <ol>
                                <input type="button" value="이전" onclick="" style="width: 44px; height: 40px;">
                                <input type="button" value="1" onclick="" style="width: 26px; height: 40px; background: #888888;">
                                <input type="button" value="2" onclick="" style="width: 26px; height: 40px;">
                                <input type="button" value="3" onclick="" style="width: 26px; height: 40px;">
                                <input type="button" value="다음" onclick="" style="width: 44px; height: 40px;">
                                </ol>
                            </li>
                            <li>
                                <p>
                                <input type="button" value="글쓰기" onclick="" style="width: 55px; height: 40px; color: aliceblue; background-color: #585858;" >
                                <p>    
                            </li>
                        </ul>
                   </div>
    
                    
                 </article>   
            </section>
        </main>
        <footer>
            <img src="../images/footer_top_line.png" alt="footer_line">
            <img src="../images/footer_logo.png" alt="footer_logo">
            <p class="paragraph">
                (주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제 2013-부산진구-123호 / 벤처기업확인 서울지방중소기업청 제 012345678-9-01234호</br>
                등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동</br>
                대표 : 김철학 / 이메일 : chhak0503@gmail.com / 전화 : 01) 234-5678 / 부산광역시 부산진구 부전동 123<br>
                <span class="copyright">김철학(개발에반하다) All rights reserved.</span> 
            </p>
            <p class="version">farmstory ver1.0.1</p>
        </footer>
    </div>
</body>
</html>