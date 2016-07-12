package edu.bjtu.servlet;

import edu.bjtu.dao.LoginDao;
import edu.bjtu.daoimpl.LoginDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhangxuan on 2016/7/10.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LoginDao loginDao=new LoginDaoImpl();
        String method=request.getParameter("method");
        if("loginByUserName".equals(method)){
            this.loginByUserName(request,response,loginDao);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void loginByUserName(HttpServletRequest request, HttpServletResponse response,LoginDao dao) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String password=request.getParameter("userPwd");
        boolean flag=dao.userNameLogin(userName,password);
        PrintWriter out=response.getWriter();
        if(flag){
            request.getSession().setAttribute("userName",userName);
            out.print("success");
        }else{
            out.print("fail");
        }
    }
}
