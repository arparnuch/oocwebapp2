package io.muic.ooc.Servlet;

import io.muic.ooc.MySQLJava;
import io.muic.ooc.User;
import org.apache.commons.lang.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Created by arparnuch on 2/13/2017 AD.
 */
@WebServlet("/userslists")
public class UserListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ///GET USER FROM SESSION --> GET USERNAME

        if (req.getSession().getAttribute("currentUser") == null){
            resp.sendRedirect("/login"); // login page
        }


        System.out.println("Enter Get in User List");

        MySQLJava DB = new MySQLJava();
        ArrayList<User> userArrayList = new ArrayList<User>();
        DB.connectDatabase();
        try {
            DB.queryData("SELECT * FROM ooc_webapp.accessTable");
            userArrayList = DB.getListOfUsers();
//            for (User u:userArrayList) {
//             userArrayList.add(u);
//            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB FAIL");
        }finally {

            req.setAttribute("notallowuser", req.getSession().getAttribute("currentUser"));
            req.setAttribute("users", userArrayList);
            RequestDispatcher rd = req.getRequestDispatcher("jsp/listUsers.jsp");
            rd.include(req, resp);
            DB.close();
            System.out.println("Finish of user table");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Enter Post");
        if (!StringUtils.isBlank(req.getParameter("logout"))){
            req.getSession().invalidate();
            resp.sendRedirect("/login");
            System.out.println("Logout");
        }

        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            System.out.println("param name: " + paramName);
            if (paramName.equals("add")){
                resp.sendRedirect("/register"); // login page
            }else if (paramName.equals("Delaction")){

                resp.sendRedirect("/delete");
            }

        }

//        req.getParameter("result");

    }



}
