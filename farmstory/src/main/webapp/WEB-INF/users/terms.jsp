<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>이용약관</title>
    <style>
        * {
    margin: 0;
    padding: 0;
    font-family: 'Inter' sans-serif;
    font-size: 12px;
    font-weight: 400;
}
ul, ol {list-style: none;}
a {text-decoration: none; color: #111;}

#wrapper{
    width: 980px;
    height: auto;
    margin: 0px auto;
}

header {
    position: relative;
    width: 100%;
    height: 142px;
}

header .header_logo{
    position: absolute;
    top: 20px;
    left: 395px;
}

header > img:nth-of-type(2) {
    position: absolute;
    top: 59px;
    left: 751px;
}

header > .menu {
    position: absolute;
    width: 100%;
    height: 50px;
    top: 92px;
    display: flex;
}

header > .menu .line {
    display: block;
    margin-top: -3px;
}

header > .menu div {
    position: relative;
}

.menu div img[alt="30%"] {
    position: absolute;
    top: -15px;
    left: 55%;
}

header > .home {
    position: absolute;
    top: 17px;
    right: 5px;

}


#user > .terms {
    width: 600px;
    height: auto;            
    margin: 60px auto;
    overflow: hidden;
}
#user > .terms > h2 {
    margin-top: 10px;
    margin-bottom: 6px;
}
#user > .terms > table {
    width: 100%;
    height: auto;
    border-collapse: collapse;
    border-spacing: 0;
    border-top: 2px solid #111;
}
#user > .terms > table > caption {
    text-align: left;
    font-weight: bold;
    padding: 10px 0;
    box-sizing: border-box;
}
#user > .terms > table tr {}
#user > .terms > table tr > td {
    padding: 6px;
    border: 1px solid #e9e9e9;
    box-sizing: border-box;
}
#user > .terms > table tr > td > textarea {
    width: 100%;
    height: 200px;
    resize: none;
    background: #f7f7f7;
    border: 1px solid #e4eaec;
    padding: 2px;
    box-sizing: border-box;
}
#user > .terms > table tr > td > label {float: right;}
#user > .terms > table tr > td > label > input[type=checkbox] {}

#user > .terms > div {
    float: right;
    margin-top: 10px;
}

#user > .terms > div >  .btnCancel {
    width: 45px;
    height: 35px;
    border: 1px solid #BEBEBE;
    background-color: white;
}

#user > .terms > div >  .btnNext {
    width: 45px;
    height: 35px;
    border: 1px solid #BEBEBE;
    background-color: white;
}

footer {
    position: relative;
    width: 100%;
    height: 120px;
}

footer > img:nth-of-type(1) {
    position: absolute;
    top: 0px;
    margin-top: -2px;
}


footer > .paragraph {
    position: absolute;
    top: 27px;
    left: 254.52px;
    font-size: 10.31px;
    color: #585858;
    line-height: 18px;
}

footer .copyright {
    font-size: 11.06px;
    color: #888;
    line-height: 13.39px;
}

footer > .version {
    position: absolute;
    right: 20px;
    bottom: 15px;
    font-size: 10.69px;
    color: #888;
}
    </style>
  </head>
  <body>
    <div id="wrapper">
        <header>
            <img src="/farmstory/images/head_top_line.png" alt="헤더 선">
            <a href="/farmstory/main/main.do"><img src="/farmstory/images/logo.png" class="header_logo" alt="로고사진"></a>
            <img src="/farmstory/images/head_txt_img.png" alt="무료배송">
            <span class="home">
                <a href="/farmstory/main/main.do">HOME</a>&thinsp;|&thinsp;
                <a href="/farmstory/users/login.do">로그인</a>&thinsp;|&thinsp;
                <a href="/farmstory/users/singup.do">회원가입</a>&thinsp;|&thinsp;
                <a href="/farmstory/profile/cart.do">나의정보</a>&thinsp;|&thinsp;
                <a href="/farmstory/main/main.do">로그아웃</a>&thinsp;|&thinsp;
                <a href="/farmstory/admin-dashboard/dashboard.do">관리자</a>&thinsp;|&thinsp;
                <a href="#">고객센터</a>&thinsp;
            </span>
            <nav class="menu">
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/home/greeting.do"><img src="/farmstory/images/head_menu1.png" alt="팜스토리 소개"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <img src="/farmstory/images/head_menu_badge.png" alt="30%">
                    <a href="/farmstory/shop/product-list.do"><img src="/farmstory/images/head_menu2.png" alt="장보기"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/stories/farm-stories.do"><img src="/farmstory/images/head_menu3.png" alt="농작물이야기"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/events/event-calendar.do"><img src="/farmstory/images/head_menu4.png" alt="이벤트"></a>
                </div>
                <div>
                    <img src="/farmstory/images/head_menu_line.png" class="line" alt="메뉴 선">
                    <a href="/farmstory/community/notices.do"><img src="/farmstory/images/head_menu5.png" alt="커뮤니티"></a>
                </div>
            </nav>
        </header>
        
        <script>
        	document.addEventListener("DOMContentLoaded", function() {
        		
        		const btnNext = document.getElementsByClassName('btnNext')[0];
        		const check1 = document.getElementsByTagName('input')[0];
        		const check2 = document.getElementsByTagName('input')[1];
        		
        		btnNext.onclick = function(e) {
        			
        			if(check1.checked && check2.checked) {
        				return true;
        			}else {
        				alert('동의체크를 해야 합니다.');
        				return false;
        			}
        		}
        	});
        
        </script>

        <main id="user">
            <section class="terms">
                <h2 class="tit">사이트 이용약관</h2>
                <table border="1">                    
                    <tr>
                        <td>
                            <textarea name="terms">${dto.terms}</textarea>
                            <label><input type="checkbox" class="terms">&nbsp;동의합니다.</label>
                        </td>
                    </tr>
                </table>
        
                <h2 class="tit">개인정보 취급방침</h2>
                <table border="1">                    
                    <tr>
                        <td>
                            <textarea name="privacy">${dto.privacy}</textarea>
                            <label><input type="checkbox" class="privacy">&nbsp;동의합니다.</label>
                        </td>
                    </tr>
                </table>
                
                <div>
                    <button class="btnCancel"><a href="/farmstory/user/login.do">취소</a></button>
                    <button class="btnNext"><a href="/farmstory/user/register.do">다음</a></button>
                </div>
        
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
    </main>
  </body>
</html>
