package org.codenova.talkhub.controller.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.codenova.talkhub.model.dao.UserDAO;
import org.codenova.talkhub.model.vo.User;

import java.io.IOException;

@WebServlet("/user/login-proceed")
public class LoginProceedServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAO();
        User found = userDAO.findById(id);

        if (found == null){
            req.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
            req.setAttribute("id", id);
            req.getRequestDispatcher("/WEB-INF/views/user/login-fail.jsp").forward(req, resp);
        }else {
            if(found.getPassword().equals(password)){
                HttpSession session = req.getSession();
                session.setAttribute("user", found);
                resp.sendRedirect(req.getContextPath()+"/index");
            }else{
                req.setAttribute("error", "아이디 또는 비밀번호가 잘못되었습니다.");
                req.setAttribute("id", id);
                req.getRequestDispatcher("/WEB-INF/views/user/login-fail.jsp").forward(req, resp);
            }
        }
    }
}
