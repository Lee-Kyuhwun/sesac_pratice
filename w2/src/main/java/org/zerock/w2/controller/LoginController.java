package org.zerock.w2.controller;


import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login get...........");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
// HTTP POST 메소드를 오버라이딩합니다. 이 메소드는 클라이언트로부터 POST 요청이 들어올 때 호출됩니다.
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 로그에 "login post........" 문자열을 출력합니다. 이는 로그인 POST 요청이 들어왔음을 알리는 메시지입니다.
        log.info("login post........");

        // HttpServletRequest 객체인 req로부터 "mid" 파라미터 값을 가져옵니다.
        // 이 값은 사용자가 폼에 입력한 ID가 됩니다.
        String mid = req.getParameter("mid");

        // HttpServletRequest 객체인 req로부터 "mpw" 파라미터 값을 가져옵니다.
        // 이 값은 사용자가 폼에 입력한 비밀번호가 됩니다.
        String mpw = req.getParameter("mpw");

        // 사용자의 ID와 비밀번호를 합친 문자열을 생성합니다.
        String str = mid + mpw;

        // req 객체로부터 HttpSession 객체를 가져옵니다.
        HttpSession session = req.getSession();

        // 생성한 문자열(str)을 세션에 "loginInfo"라는 이름으로 저장합니다.
        // 이 세션은 사용자가 로그인한 정보를 유지하는데 사용됩니다.
        session.setAttribute("loginInfo",str);

        // "/tod\o/list" URL로 리다이렉션합니다.
        // 이는 로그인이 성공적으로 처리된 후에 사용자를 해당 URL로 이동시키는 역할을 합니다.
        resp.sendRedirect("/todo/list");
    }
}
