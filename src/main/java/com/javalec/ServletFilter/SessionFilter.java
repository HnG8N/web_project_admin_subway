package com.javalec.ServletFilter;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화 작업
        // 필요한 경우에만 구현
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	// 요청 가로채기 및 전처리 작업
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession session = httpRequest.getSession(); // 세션 가져오기

        String requestUrl = httpRequest.getRequestURL().toString(); // 요청된 URL 가져오기
        long startTime = System.currentTimeMillis(); // 요청 시작 시간 기록
        
		String scheme = httpRequest.getScheme(); // "http" 또는 "https" 반환
		String serverName = httpRequest.getServerName(); // "localhost" 또는 호스트명 반환
		int serverPort = httpRequest.getServerPort(); // 포트 번호 반환
		String contextPath = httpRequest.getContextPath();	// /admin 반환
		String localhostURL = scheme + "://" + serverName + ":" + serverPort + contextPath;
		String com = requestUrl.substring(localhostURL.length());

        // 요청 정보 로깅
        System.out.println("Request URL: " + requestUrl); // 요청된 URL 출력
        System.out.println("Localhost URL: " + localhostURL);
        System.out.println(com);
        System.out.println("Request received at: " + startTime); // 요청을 받은 시간 출력
        
        // 시간이 지나면 session값을 remove
        Timer sessionTimer = new Timer();
        sessionTimer.schedule(new TimerTask() {
        	@Override
        	public void run() {
        		session.removeAttribute("Logged_in_ID");
        	}
        }, 5 * 60 * 1000); // 분, 초, 밀리초
        
        // 세션에서 로그인 정보를 확인하고 로그인되지 않았고 login.do가 아니면 로그인 페이지로 리디렉션
        // && !com.equals("/login.do") 이 조건이 없으면 /login.do일 때 무한 redirect 됨
        if (httpRequest.getSession().getAttribute("Logged_in_ID") == null && !com.equals("/login.do")) {
            httpResponse.sendRedirect("login.do");
            return; // 필터를 종료
        }


        // 다음 필터로 요청 전달
        chain.doFilter(request, response); // 다음 필터로 요청과 응답 전달

        // 응답 후처리 작업
        long endTime = System.currentTimeMillis(); // 요청 처리 완료 시간 기록
        // 처리 시간 로깅
        System.out.println("Request processed in " + (endTime - startTime) + " milliseconds"); // 처리 시간 출력
    }

    @Override
    public void destroy() {
        // 필터 종료 작업
        // 필요한 경우에만 구현
    }
}
