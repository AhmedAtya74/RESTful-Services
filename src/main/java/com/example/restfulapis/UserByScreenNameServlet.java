package com.example.restfulapis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserByScreenNameServlet", value = "/UserByScreenNameServlet")
public class UserByScreenNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String screenName = request.getParameter("screen-name");
        if(screenName.equals(""))
            response.sendRedirect("index.jsp");
        else
            response.sendRedirect(request.getContextPath()+"api/users/getUserByScreenName/"+screenName);
    }

}
