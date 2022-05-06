<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Macgyver</title>
    </head>
    <body>
    <h1>index.jsp</h1>
        <c:if test="${userName ne null}">
            현재 로그인한 사용자는 ${userName} 입니다.
            <a href="/logout" role="button">로그아웃</a>
            <br/>
            <a href="/user/mypage" role="button">마이페이지</a>
        </c:if>
        <c:if test="${userName eq null}">
            <a href="/oauth2/authorization/naver" role="button">네이버로그인</a>
        </c:if>

        <!--단순 테스트 삭제 예정-->

        <br/><br/><br/>
        <a href="/all" role="button">로그인 안해도 접근 가능</a><br/>
        <a href="/useronly" role="button">로그인 회원 접근 가능</a><br/>
        <a href="/admin" role="button">관리자 접근 가능</a><br/>
    </body>
</html>