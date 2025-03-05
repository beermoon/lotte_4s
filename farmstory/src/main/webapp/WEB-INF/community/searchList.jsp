<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>커뮤니티-공지사항</title>

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
    main .list > a:nth-child(2) > img:hover {background-image:url("../images/sub_cate5_lnb2_ov.png");}
    main .list > a:nth-child(3) > img:hover {background-image:url("../images/sub_cate5_lnb3_ov.png");}
    main .list > a:nth-child(4) > img:hover {background-image:url("../images/sub_cate5_lnb4_ov.png");}
    main .list > a:nth-child(5) > img:hover {background-image:url("../images/sub_cate5_lnb5_ov.png");}
   
    main > .main_btm > article {
        position: relative;
        width: 802px;
        height: 700px;
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
    
    
    
    
    
    
    
    
    
    
    
    
    section.list {
    left: 40px;
    position: relative;
    width: 100%;
    height: auto;            
    margin: 85px auto;    
}

section.list > nav > form {
    float: right;
}

section.list > nav > form > input[name=keyword]{
    width: 200px;
    height: 26px;
    text-indent: 6px;
    border: 1px solid #d7d7d7;
}
section.list > nav >form > input[type=submit]{
    border: 1px solid #d7d7d7;
    background: #f2f2f2; 
    color: #111;
    padding: 6px;
}

section.list > table {
    width: 100%;
    height: auto;
    border-collapse: collapse;
    border-spacing: 0;
    border-top: 2px solid #111;
}
section.list > table tr {}
section.list > table > caption {
    text-align: left;
    margin-bottom: 6px;
}
section.list > table tr > th {
    width: auto;
    height: 40px;
    background: #e5ecef;
    border-bottom: 1px solid #d1dee2;
}
section.list > table tr > td {
    width: auto;
    height: 40px;
    border-bottom: 1px solid #e9e9e9;
    text-align: center;
}
section.list > table tr > td:nth-child(1) {}
section.list > table tr > td:nth-child(2) {text-align: left;}
section.list > table tr > td:nth-child(3) {}
section.list > table tr > td:nth-child(4) {}
section.list > table tr > td:nth-child(5) {}

section.list > .page {
    text-align: center;
    margin-top: 10px;
}
section.list > .page > a {
    display: inline-block;
    padding: 8px;
    border: 1px solid #d7d7d7;
    background: #f2f2f2;
}
section.list > .page > .prev {}
section.list > .page > .next {}
section.list > .page > .num {}
section.list > .page > .current {
    border: 1px solid #6d6d6d;
    background: #888;
    color: #fff;
}

.btn {
    display: inline-block;
    padding: 8px;    
    border: 1px solid #bebebe; 
    text-align: center;    
    cursor: pointer;
}

.btnRegister {}
.btnWrite {
    position: absolute;
    right: 0;
    bottom: 0;
    border: 1px solid #3b3c3f; 
    background: #4b545e; 
    color: #fff;
}

.btnComplete {
    border: 1px solid #3b3c3f; 
    background: #4b545e; 
    color: #fff;
}

.btnAuth, .btnConfirm {
    display: inline-block;
    padding: 4px;    
    border: 1px solid #bebebe; 
    text-align: center;
}


.btnUpdatePass {
    padding: 5px; background: #2e658a; color:#fff; border: 1px solid #bebebe; 
}
.btnWithdraw {
    padding: 5px; background: #ed2f2f; color:#fff;
}
    
    
    
  
   
  </style>
</head>
<body>
    <div id="wrapper">
        <header>
            <img src="../images/head_top_line.png" alt="헤더 선">
            <a href="../main/main.do"><img src="../images/logo.png" class="header_logo" alt="로고사진"></a>
            <img src="../images/head_txt_img.png" alt="무료배송">
            <span class="home">
                <a href="../main/main.do">HOME</a>&thinsp;|&thinsp;
                <a href="../user/login.do">로그인</a>&thinsp;|&thinsp;
                <a href="../user/register.do">회원가입</a>&thinsp;|&thinsp;
                <a href="../profile/cart.do">나의정보</a>&thinsp;|&thinsp;
                <a href="../main/main.do">로그아웃</a>&thinsp;|&thinsp;
                <a href="../admin-dashboard/dashboard.do">관리자</a>&thinsp;|&thinsp;
                <a href="#">고객센터</a>&thinsp;
            </span>
            <nav class="menu">
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../home/greeting.do"><img src="../images/head_menu1.png" alt="팜스토리 소개"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <img src="../images/head_menu_badge.png" alt="30%">
                    <a href="../shop/product-list.do"><img src="../images/head_menu2.png" alt="장보기"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../stories/farm-stories.do"><img src="../images/head_menu3.png" alt="농작물이야기"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../events/event-calendar.do"><img src="../images/head_menu4.png" alt="이벤트"></a>
                </div>
                <div>
                    <img src="../images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="../community/notices.do"><img src="../images/head_menu5.png" alt="커뮤니티"></a>
                </div>
            </nav>
        </header>
        <main>
            <div class="main_top">
                <img src="../images/sub_top_tit5.png" alt="community">
            </div>
            <section class="main_btm">
                <aside>
                    <img src="../images/sub_aside_cate5_tit.png" alt="커뮤니티">
                    <img src="../images/sub_aside_bg_line.png" alt="목록선">
                    <div class="list">
                    	<a href="../community/notices.do"><img src="../images/sub_cate5_lnb1_ov.png" alt="공지사항"></a>
                        <a href="../community/today-menu.do"><img src="../images/sub_cate5_lnb2.png" alt="오늘의식단"></a>
                        <a href="../community/recipesharing.do"><img src="../images/sub_cate5_lnb3.png" alt="나도요리사"></a>
                        <a href="../community/customerinquiry.do"><img src="../images/sub_cate5_lnb4.png" alt="1:1고객문의"></a>
                        <a href="../community/faq.do"><img src="../images/sub_cate5_lnb5.png" alt="자주묻는질문"></a>
                    </div>
                </aside>
                <article>
                    <nav>
                        <img src="../images/sub_nav_tit_cate5_tit1.png" alt="공지사항">
                        <div class="nav_menu">
                            <img src="../images/sub_page_nav_ico.gif" alt="#">
                            <p>HOME > 커뮤니티 > <span>공지사항</span></p> <!--수정-->
                        </div>
                    </nav>
                   	<section class="list">
		                <nav>
		                    <h1>
		                    	<a href="/farmstory/community/notices.do">글목록 전체</a>
		                    </h1>
		                    <form action="/farmstory/community/search.do">
		                    	<select name="searchType" style="padding: 6px;">
                    			<c:if test="${searchType eq 'title'}">                    	
	                    			<option value="title" selected>제목</option>
	                    			<option value="content">내용</option>
	                    			<option value="writer">글쓴이</option>
                    			</c:if>
                    			<c:if test="${searchType eq 'content'}">
	                    			<option value="title">제목</option>
                    				<option value="content" selected>내용</option>
	                    			<option value="writer">글쓴이</option>
                    			</c:if>
                    			<c:if test="${searchType eq 'writer'}">
	                    			<option value="title">제목</option>
                    				<option value="content">내용</option>
                    				<option value="writer" selected>글쓴이</option>
                    			</c:if>
                    			</select>
		                        <input type="text" name="keyword" placeholder="검색 키워드 입력">
		                        <input type="submit" value="검색">
		                    </form>
		                </nav>
	                                
	                <table border="0">                    
	                    <tr>
	                        <th>번호</th>
	                        <th>제목</th>
	                        <th>글쓴이</th>
	                        <th>날짜</th>
	                        <th>조회</th>
	                    </tr>
	                    <c:forEach var="community" items="${requestScope.communitys}">
		                    <tr>
		                        <td>${pageStartNum}</td>
		                        <td><a href="/farmstory/community/recipesharing.do?no=${community.no}">${community.title}[${community.comment}]</a></td>
		                        <td>${community.nick}</td>
		                        <td>${community.wdate}</td>
		                        <td>${community.hit}</td>
		                    </tr>
		                    <c:set var="pageStartNum" value="${pageStartNum - 1}" />
	                    </c:forEach>
	                </table>
	                <div class="page">
                	<c:if test="${pageGroupDTO.start > 1}">
                    	<a href="/farmstory/community/search.do?searchType=${searchType}&keyword=${keyword}&pg=${pageGroupDTO.start - 1}" class="prev">이전</a>
                    </c:if>
                    <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end}">
                    	<a href="/farmstory/community/search.do?searchType=${searchType}&keyword=${keyword}&pg=${num}" class="num ${currentPage == num ? 'current':''}">${num}</a>
                    </c:forEach>
                    <c:if test="${pageGroupDTO.end < lastPageNum}">
                    	<a href="/farmstory/community/search.do?searchType=${searchType}&keyword=${keyword}&pg=${pageGroupDTO.end + 1}" class="next">다음</a>
                    </c:if>
                </div>
               		<a href="/farmstory/community/today-menu.do" class="btn btnWrite">글쓰기</a>                
            	</section>
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