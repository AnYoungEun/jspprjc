<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="ctxName" value="${pageContext.request.servletContext.contextPath }"/> <!-- 루트디렉토리를 동적으로 얻어낼수있다 -->
<header id="header">
        <div class="content-wrapper">
            <h1 id="logo"><a href="../index.html"><img src="${ctxName}/images/logo.png" alt="뉴렉처 온라인" /></a></h1>
            <section class="header-item-container">
                <h1 class="hidden">머리말</h1>
                <nav id="main-menu">
                    <h1 class="hidden">메인메뉴</h1>
                    <ul class="clearfix">
                        <li class="main-menu-item"><a class="main-menu-item-text" href="">학습가이드</a></li>
                        <li class="main-menu-item"><a class="main-menu-item-text" href="">뉴렉과정</a></li>
                        <li class="main-menu-item"><a class="main-menu-item-text" href="">강좌선택</a></li>
                    </ul>
                </nav>

                <div id="lecture-search-form">
                    <h3 class="hidden">강좌검색 폼</h3>
                    <form>
                        <fieldset>
                            <legend class="hidden">검색필드</legend>
                            <label id="lecture-search-input-label" for="subject">과정검색</label>
                            <input id="lecture-search-input" class="g1" type="text" name="subject" />
                            <input id="lecture-search-button" type="submit" value="검색" />
                        </fieldset>
                    </form>
                </div>

                <nav id="member-menu">
                    <h1 class="hidden">회원메뉴</h1>
                    <ul class="clearfix">
                        <li class="member-menu-item"><a class="member-menu-item-text" href="${ctxName}/index.jsp">홈</a></li>
                        <c:if test="${uid == null }">
                        <li class="member-menu-item"><a class="member-menu-item-text" href="${ctxName}/joinus/login.jsp">로그인</a></li>
                        </c:if>
                        
                        <c:if test="${uid != null }">
                        <li class="member-menu-item"><a class="member-menu-item-text" href="${ctxName}/joinus/login.jsp">로그아웃</a></li>
                        </c:if>
                        <li class="member-menu-item"><a class="member-menu-item-text" href="${ctxName}/joinus/join.html">회원가입</a></li>
                    </ul>
                </nav>

                <nav id="my-menu">
                    <h1 class="hidden">고객센터메뉴</h1>
                    <ul class="clearfix">
                        <li class="my-menu-item"><a class="my-menu-item-text" href=""><img src="${ctxName}/images/txt-mypage.png" alt="마이페이지" /></a></li>
                        <li class="my-menu-item"><a class="my-menu-item-text" href="${ctxName}/customer/notice.html"><img src="${ctxName}/images/txt-customer.png" alt="고객센터" /></a></li>
                    </ul>
                </nav>
            </section>
        </div>
    </header>