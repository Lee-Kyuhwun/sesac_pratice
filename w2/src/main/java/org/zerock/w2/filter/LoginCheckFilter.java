package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

// "@WebFilter" 어노테이션을 이용하여, "/todo/*" 패턴의 URL에 대한 요청에 이 필터를 적용하도록 설정합니다.
// 즉, "/todo/"로 시작하는 모든 URL 요청에 이 필터가 작동하게 됩니다.
@WebFilter(urlPatterns ={"/todo/*"})

// "@Log4j2" 어노테이션을 이용하여, 이 클래스에서 Log4j2 로깅 라이브러리를 사용할 수 있도록 설정합니다.
@Log4j2

// Filter 인터페이스를 구현하여, 이 클래스가 필터 역할을 수행하도록 합니다.
public class LoginCheckFilter implements Filter {

    // doFilter 메소드를 오버라이드합니다.
    // 이 메소드는 요청이 필터를 통과할 때마다 호출되며, 실제 필터링 작업을 수행합니다.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 로그에 "Login check filter....." 문자열을 출력합니다.
        // 이는 필터가 작동하고 있다는 것을 로그에 남기는 역할을 합니다.
        log.info("Login check filter.....");

        // ServletRequest를 HttpServletRequest로 캐스팅하여 HttpServletRequest의 메소드를 사용할 수 있게 합니다.
        HttpServletRequest req = (HttpServletRequest) request;
        // ServletResponse를 HttpServletResponse로 캐스팅하여 HttpServletResponse의 메소드를 사용할 수 있게 합니다.
        HttpServletResponse resp = (HttpServletResponse) response;

        // req 객체로부터 HttpSession 객체를 가져옵니다.
        HttpSession session = req.getSession();

        // 세션에 "loginInfo"라는 이름으로 저장된 정보가 없다면 로그인이 되어있지 않은 상태로 판단합니다.
        if(session.getAttribute("loginInfo") == null){
            // 로그인이 되어있지 않은 상태라면 사용자를 "/login" URL로 리다이렉션하여 로그인 페이지로 이동하게 합니다.
            resp.sendRedirect("/login");
            // 필터 체인의 실행을 종료하고 메소드를 종료합니다.
            return;
        }

        // 사용자가 로그인 상태라면 FilterChain의 doFilter 메소드를 호출하여,
        // 필터의 작업이 끝났음을 알리고, 요청 및 응답을 다음 필터 또는 목적지로 전달합니다.
        chain.doFilter(request,response);
    }
}
