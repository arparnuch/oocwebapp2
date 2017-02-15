package io.muic.ooc.Servlet;

import io.muic.ooc.MySQLJava;
import org.apache.commons.lang.StringUtils;

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
@WebServlet("/deleteusers")
public class DeleteServelet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u = req.getParameter("username");
        req.setAttribute("u", u);
        req.getSession().setAttribute("u", u);
        RequestDispatcher rd = req.getRequestDispatcher("jsp/delete.jsp");
        rd.include(req, resp);
//        req.getRequestDispatcher("jsp/delete.jsp").forward(req, resp);
        System.out.println("Enter Get in Delete");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter POST in deleteServlet");


        String selectedUser = (String) req.getSession().getAttribute("u"); //req.getParameter(paramName);



        if(!StringUtils.isBlank(req.getParameter("back"))){
            resp.sendRedirect("/userslists");
        }else if (!StringUtils.isBlank(req.getParameter("ok"))){

            System.out.println("target user : " + selectedUser);
            MySQLJava mySQLJava = new MySQLJava();
            mySQLJava.connectDatabase();
            mySQLJava.deleteData(selectedUser);

//            mySQLJava.close();
            req.getSession().removeAttribute("u");
            resp.sendRedirect("/userslists");


        }

    }
}
