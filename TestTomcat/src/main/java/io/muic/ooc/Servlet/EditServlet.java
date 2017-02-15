package io.muic.ooc.Servlet;

import io.muic.ooc.MySQLJava;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by arparnuch on 2/15/2017 AD.
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String u = req.getParameter("username"); // selected user to be removed
        String p = req.getParameter("password");
        String f = req.getParameter("firstname");
        String l = req.getParameter("lastname");
        String e = req.getParameter("email");



        if (req.getSession().getAttribute("currentUser") == null){
            resp.sendRedirect("/login"); // login page
        }
        req.setAttribute("u", u);
        req.setAttribute("p", p);
        req.setAttribute("f", f);
        req.setAttribute("l", l);
        req.setAttribute("e", e);

        req.getSession().setAttribute("u", u);
        RequestDispatcher rd = req.getRequestDispatcher("jsp/edit.jsp");
        rd.include(req, resp);

//        req.getRequestDispatcher("jsp/edit.jsp").forward(req, resp);
//        System.out.println("Enter Get in Login");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String u = req.getParameter("username");
        String newPass = req.getParameter("password");
        String newFirst = req.getParameter("firstname");
        System.out.println("new Firstname: " + newFirst);
        String newLast = req.getParameter("lastname");
        String newEmail = req.getParameter("email");

        MySQLJava database = new MySQLJava();
        database.connectDatabase();
        database.editData(u,newPass,newFirst,newLast,newEmail);
        resp.sendRedirect("/userslists");
    }
}
