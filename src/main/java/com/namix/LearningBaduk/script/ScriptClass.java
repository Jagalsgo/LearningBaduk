package com.namix.LearningBaduk.script;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScriptClass {

	public static void init(HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

	public static void alert(HttpServletResponse response, String alertText) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>alert('" + alertText + "');</script> ");
		out.flush();
	}

	public static void alertAndMove(HttpServletResponse response, String alertText, String location)
			throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + alertText + "')");
		out.println("location.href='" + location + "'");
		out.println("</script>");
	}

	public static void locationMove(HttpServletResponse response, String location) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>location.href='" + location + "'");
	}

	public static void historyBack(HttpServletResponse response) throws IOException {
		init(response);
		PrintWriter out = response.getWriter();
		out.println("<script>history.back()</script> ");
		out.flush();
	}
	
	public static void preventUrlApproach(HttpServletRequest request, HttpServletResponse response) throws IOException {
		init(response);
		if (request.getHeader("REFERER") == null) {
			ScriptClass.alert(response, "옳지 않은 접근입니다.");
			ScriptClass.historyBack(response);
		}
	}

}