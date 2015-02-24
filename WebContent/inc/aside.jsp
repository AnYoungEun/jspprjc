<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctxName" value="${pageContext.request.servletContext.contextPath }" /><!-- 루트디렉토리를 동적으로 얻어낼수있다 -->

<aside class="aside-menu-group">
				<h1 class="aside-menu-group-title">고객센터</h1>

				<nav class="aside-main-menu">
					<h1 class="hidden">고객센터 메뉴</h1>
					<ul>
						<li class="aside-menu-item"><a href="">공지사항</a></li>
						<li class="aside-menu-item"><a href="">1:1고객문의</a></li>
						<li class="aside-menu-item"><a href="">학습안내</a></li>
					</ul>
				</nav>

				<nav class="aside-menu">
					<h1>추천사이트</h1>
					<ul class="aside-menu-list">
						<li><img src="../images/answeris.png" alt="앤서이즈" /></li>
						<li><img src="../images/w3c.png" alt="W3C" /></li>
						<li><img src="../images/microsoft.png" alt="마이크로소프트" /></li>
					</ul>
				</nav>

			</aside>