<%@ page import="com.tytarenko.beans.AuthorList, com.tytarenko.beans.GenreList, com.tytarenko.beans.BookList" %>
<%@ page import="com.tytarenko.beans.Author, com.tytarenko.beans.Genre, com.tytarenko.beans.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
	
		<div class="sidebar">
		<h1>Список авторів</h1>
			<ul class="nav1">
				<% AuthorList authorList = new AuthorList();
					for(Author author : authorList.getAuthorList()) {
				%>
				<li><a href="#"><%=author.getName()%></a></li>
				<%}%>
			</ul>
			
		<h1>Список жанрів</h1>
			<ul class="nav2">
				<% GenreList genreList = new GenreList();
					for(Genre genre : genreList.getGenreList()) {
				%>
				<li><a href="#"><%=genre.getName()%></a></li>
				<%}%>
			</ul>
			
		<h1>Список книг</h1>
			<ul class="nav3">
				<% BookList bookList = new BookList();
					for(Book book : bookList.getBookList()) {
				%>
				<li><a href="#"><%=book.getName()%></a></li>
				<%}%>
			</ul>
		</div> 
		
	</body>
</html>