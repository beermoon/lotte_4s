<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문내역</title>

    <link rel="stylesheet" href="/farmstory/css/_header.css">
    <link rel="stylesheet" href="/farmstory/css/_footer.css">

  <style>
    main {
        width: 100%;
        height: auto;/*수정*/
        margin: 0 auto;
    }

    main > .main_top {
        position: relative;
        width: 100%;
        height: 184px;
        background-image: url("/farmstory/images/myinfo/myinfo_top_bg.jpg");
    }

    main > .main_top > img {
        position: absolute;
        top: 137px;
        left: 10px;
    }

    main > .main_btm {
        width: 100%;
        height: 786px;
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
        right: 1px;
        width: 175px;
        height: 233px;
        background-image: url("/farmstory/images/sub_aside_bg_lnb.png");
    }

    main aside .list > a > img {
        width: 175px;
        height: 29px;
        margin-top: 5px;
    }

    main aside .list > a:nth-child(1) > img {margin-top: 26px;}

    main .list > a:nth-child(1) > img:hover {background-image:url("/farmstory/images/myinfo/myinfo_menu1_ov.png");}
    main .list > a:nth-child(2) > img:hover {background-image:url("/farmstory/images/myinfo/myinfo_menu2_ov.png");}
    main .list > a:nth-child(3) > img:hover {background-image:url("/farmstory/images/myinfo/myinfo_menu3_ov.png");}

    main > .main_btm > article {
        position: relative;
        width: 802px;
        height: auto;
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


    main > .main_btm .content {
        margin-top: 113px;
        margin-left: 40px;
    }

    main .content .setting, 
    main .content .modify {
        width: 762px;
        margin-top: 5px;
        border: 1px solid #111;
        border-top: 2px solid #111;
        border-spacing: 0;
        box-sizing: border-box;
    }

    main .content .setting { height: 187px; margin-bottom: 10px;}

    main .content .modify {height: 378px;}

    
    main .content .setting td,
    main .content .modify td {
        padding-left: 10px;
        border: 1px solid #E9E9E9;
    }

    main .content .setting td:nth-of-type(1),
    main .content .modify td:nth-of-type(1) {
        width: 105px;
        background-color: #F5F8F9;
        box-sizing: border-box;
    }

    main .content .modify button {
        display: block;
        width: 58px;
        height: 27px;
        background-color: #ED2F2F;
        color: #FFF;
        border: none;
    }

    main form > .buttons {
        margin: 10px 0px 0px 639px; 
        display: flex; 
        align-items: center;
    }

    main form > .buttons > .cancle, .u_modify {
        width: 42px;
        height: 35px;
        text-align: center;
        line-height: 35px;
        background-color: #fff;
        border: 1px solid #BEBEBE;
    }

    main form > .buttons > .u_modify {
        margin-left: 2px;
        width: 66px;
        height: 35px;
    }

  </style>
</head>
<body>
    <div id="wrapper">
        <header>
            <img src="/farmstory/images/head_top_line.png" alt="헤더 선">
            <a href="/farmstory/main/main.html"><img src="/farmstory/images/logo.png" class="header_logo" alt="로고사진"></a>
            <img src="/farmstory/images/head_txt_img.png" alt="무료배송">
            <span class="home">
                <a href="/farmstory/main/main.html">HOME</a>&thinsp;|&thinsp;
                <a href="/farmstory/users/login.html">로그인</a>&thinsp;|&thinsp;
                <a href="/farmstory/users/singup.html">회원가입</a>&thinsp;|&thinsp;
                <a href="/farmstory/profile/cart.html">나의정보</a>&thinsp;|&thinsp;
                <a href="/farmstory/main/main.html">로그아웃</a>&thinsp;|&thinsp;
                <a href="/farmstory/admin-dashboard/dashboard.html">관리자</a>&thinsp;|&thinsp;
                <a href="#">고객센터</a>&thinsp;
            </span>
            <nav class="menu">
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/home/greeting.html"><img src="/farmstory/images/head_menu1.png" alt="팜스토리 소개"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <img src="/farmstory/images/head_menu_badge.png" alt="30%">
                    <a href="/farmstory/shop/product-list.html"><img src="/farmstory/images/head_menu2.png" alt="장보기"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/stories/farm-stories.html"><img src="/farmstory/images/head_menu3.png" alt="농작물이야기"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/events/event-calendar.html"><img src="/farmstory/images/head_menu4.png" alt="이벤트"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/community/notices.html"><img src="/farmstory/images/head_menu5.png" alt="커뮤니티"></a>
                </div>
            </nav>
        </header>
        <main>
            <section class="main_top">
                <img src="/farmstory/images/myinfo/myinfo_top_tit.png" alt="my info">
            </section>
            <section class="main_btm">
                <aside>
                    <img src="/farmstory/images/myinfo//myinfo_menu_tit.png" alt="나의정보">
                    <img src="/farmstory/images/sub_aside_bg_line.png" alt="목록선">
                    <div class="list">
                        <a href="/farmstory/profile/cart.html"><img src="/farmstory/images/myinfo/myinfo_menu1.png" alt="장바구니"></a>
                        <a href="/farmstory/profile/order-history.html"><img src="/farmstory/images/myinfo/myinfo_menu2.png" alt="주문내역"></a>
                        <a href="/farmstory/profile/update-info.html"><img src="/farmstory/images/myinfo/myinfo_menu3.png" alt="정보수정"></a>
                    </div>
                </aside>
                <article>
                    <nav>
                        <img src="/farmstory/images/sub_nav_tit_cate2_tit1.png" alt="장보기">
                        <div class="nav_menu">
                            <img src="/farmstory/images/sub_page_nav_ico.gif" alt="#">
                            <p>HOME > 나의정보 > <span>정보수정</span></p>
                        </div>
                    </nav>
                    <div class="content">
                        <p>회원정보 설정</p>
                        <form action="#">
                            <table class="setting">
                                <tr>
                                    <td>아이디</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td>비밀번호</td>
                                    <td><label><input type="password" placeholder="비밀번호 입력" size="25;" style="height: 27px;"></label></td>
                                </tr>
                                <tr>
                                    <td>비밀번호 확인</td>
                                    <td><label><input type="password" placeholder="비밀번호 입력 확인" size="25;" style="height: 27px;"></label>
                                        <input type="image" img src="/farmstory/images/user/chk_post.gif" alt="비밀번호">
                                    </td>
                                </tr>
                                <tr>
                                    <td>회원가입날짜</td>
                                    <td>2022-01-01 12:45:12</td>
                                </tr>
                            </table>
                            <p>개인정보 수정</p>
                            <table class="modify">
                                <tr>
                                    <td>이름</td>
                                    <td><label><input type="text" placeholder="" size="25;" style="height: 25px;"></label></td>
                                </tr>
                                <tr>
                                    <td>별명</td>
                                    <td><p>공백없는 한글, 영문, 숫자 입력</p><br>
                                        <label><input type="text" placeholder="별명 입력" size="25;" style="height: 25px;"></label>
                                        <input type="image" img src="/farmstory/images/user/chk_id.gif" alt="중복확인">
                                    </td>
                                </tr>
                                <tr>
                                    <td>이메일</td>
                                    <td><label><input type="text" placeholder="이메일 입력" size="25;" style="height: 25px;"></label>
                                        <input type="image" img src="/farmstory/images/user/chk_auth.gif" alt="인증번호">
                                    </td>
                                </tr>
                                <tr>
                                    <td>휴대폰</td>
                                    <td><label><input type="tel"  placeholder="휴대폰 입력" size="25;" style="height: 25px;"></label></td>
                                </tr>
                                <tr>
                                    <td>주소</td>
                                    <td><label><input type="text" readonly placeholder="우편번호" size="25;" style="height: 25px;"></label>
                                        <input type="image" img src="/farmstory/images/user/chk_post.gif" alt="우편찾기"><br>
                                        
                                        <label><input type="text" readonly placeholder="주소 검색" size="25;" style="width: 400px; height: 25px;"></label><br>  
                                        <label><input type="text" placeholder="상세주소 입력" size="25;" style="width: 400px; height: 25px;"></label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>회원탈퇴</td>
                                    <td><button type="button">탈퇴하기</button></td>
                                </tr>
                            </table>
                            <div class="buttons">
                                <a href="#" class="cancle">취소</a>
                                <input type="button" class="u_modify" value="회원수정">
                            </div>
                        </form>
                    </div>
                 </article>   
            </section>
        </main>
        <footer>
            <img src="/farmstory/images/footer_top_line.png" alt="footer_line">
            <img src="/farmstory/images/footer_logo.png" alt="footer_logo">
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