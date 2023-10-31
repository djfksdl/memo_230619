<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="d-flex justify-content-center">
	<div class="w-50 bg-info">
		<h1>글 목록</h1>
		<table class="table">
			<thead>
				<tr>
					<th>no.</th>
					<th>제목</th>
					<th>작성날짜</th>
					<th>수정날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${postList}" var="post">
				<tr>
					<td>${post.id}</td>
					<td>${post.subject}</td>
					<%--zonedDateTime -> Date -> String --%>
					
					<td><fmt:parseDate value="${post.createdAt}" var="parsedCreatedAt" pattern="yyyy-MM-dd'T'HH:mm:ss" />
					<fmt:parseDate value="${parsedCreatedAt}" pattern="yyyy년 M월 d일 HH:mm:dd" />
					</td>
					<td>
					<fmt:parseDate value="${post.updatedAt}" var="parsedUpdatedAt" pattern="yyyy-MM-dd'T'HH:mm:ss" />
					<fmt:parseDate value="${parsedUpdatedAt}" pattern="yyyy년 M월 d일 HH:mm:dd" />
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-flex justify-content-end">
			<a href="/post/post-create-view" class="btn btn-warnnig">글쓰기</a>
		</div>
	</div>
</div>