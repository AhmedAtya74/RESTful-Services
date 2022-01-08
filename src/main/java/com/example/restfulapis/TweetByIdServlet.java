package com.example.restfulapis;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TweetByIdServlet", value = "/TweetByIdServlet")
public class TweetByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tweetId = request.getParameter("tweetId");
        if(tweetId.equals(""))
            response.sendRedirect("index.jsp");
        else
            response.sendRedirect(request.getContextPath()+"api/tweets/getTweetById/"+tweetId);
    }
}
