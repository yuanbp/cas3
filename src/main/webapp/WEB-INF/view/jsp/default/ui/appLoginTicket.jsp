<%@ page contentType="text/html; charset=UTF-8"%>
<%
	out.print("{\"lt\":\"");
%>${loginTicket}<%
	out.print("\",\"execution\":\"");
%>${flowExecutionKey}<%
	out.print("\"}");
%>