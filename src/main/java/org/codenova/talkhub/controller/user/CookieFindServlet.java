package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.codenova.talkhub.util.CookieUtil;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie-find")
public class CookieFindServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        /*
            이 서블릿이 작동 할때
            만약 TICKET 이라는 이름의 쿠키를 가지고 온 사용자라면
                위에꺼 println
            그게아니라면
                아래꺼 println
         */


        Cookie[] cookies = req.getCookies();
        boolean found = CookieUtil.findCookie(cookies, "TICKET");
//        for (int i = 0; i < cookies.length; i++) {
//            Cookie one = cookies[i];
//            String cookieName = one.getName();
//            if (cookieName.equals("TICKET")) {
//                found = true;
//            }
//        }

        if(found) {
            resp.sendRedirect(req.getContextPath() + "/index");
        }else {
            resp.sendRedirect(req.getContextPath() + "/index");
        }
    }
}
