package edu.bjtu.servlet;

import edu.bjtu.dao.RegisterDao;
import edu.bjtu.daoimpl.RegisterDaoimpl;
import edu.bjtu.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Created by zhangxuan on 2016/7/8.
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RegisterDao dao=new RegisterDaoimpl();
        String method=request.getParameter("method");
        if("checkNotUserName".equals(method)){
            this.checkNoUserName(dao,request,response);
        }else if("checkNotCardID".equals(method)){
            this.checkNoCardID(dao,request,response);
        }else if("register".equals(method)){
            this.register(dao,request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }

    private void checkNoUserName(RegisterDao dao,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String userName=request.getParameter("userName");
         boolean flag=dao.notExistUserName(userName);
        PrintWriter out = response.getWriter();
         if(flag){
             out.write("true");
         }else{
             out.write("false");
         }

    }

    private void checkNoCardID(RegisterDao dao,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String cardID=request.getParameter("cardID");
         boolean flag=dao.notExistCardID(cardID);
         PrintWriter out=response.getWriter();
        if(flag){
            out.write("true");
        }else{
            out.write("false");
        }
    }

    private void register(RegisterDao dao,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         User user=new User();
         String custID= UUID.randomUUID().toString();
         custID.replace("-","");
        custID=custID.substring(0,11);
        user.setCustID(custID);
        user.setName(request.getParameter("name"));
        user.setUserName(request.getParameter("userName"));
        user.setUserPwd(request.getParameter("password"));
        user.setCardID(request.getParameter("cardID"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        user.setAddress(request.getParameter("address"));
        user.setRegisterDate(new Date(System.currentTimeMillis()));
        user.setRecentDate(new Date(System.currentTimeMillis()));
        System.out.println(new Date(System.currentTimeMillis()));
        boolean flag=dao.register(user);
        if(flag){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
