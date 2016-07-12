package edu.bjtu.servlet;

import edu.bjtu.dao.PayeeDao;
import edu.bjtu.dao.RegisterDao;
import edu.bjtu.daoimpl.PayeeDaoImpl;
import edu.bjtu.model.Payee;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxuan on 2016/7/10.
 */
@WebServlet(name = "PayeeServlet")
public class PayeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String method=request.getParameter("method");
         PayeeDao dao=new PayeeDaoImpl();
         if("addPayee".equals(method)){
             this.add(request,response,dao);
         }else if("toUpdate".equals(method)){
              this.toUpdate(request,response,dao);
         } else if("updatePayee".equals(method)){
              this.update(request,response,dao);
         }else if("queryPayee".equals(method)){
              this.query(request,response,dao);
         }else if("deletePayee".equals(method)){
              this.delete(request,response,dao);
         }else if("noAccount".equals(method)){
             this.checkNoAccount(request,response,dao);
         }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doPost(request,response);
    }

    protected void add(HttpServletRequest request, HttpServletResponse response, PayeeDao dao) throws ServletException, IOException{
        Map params=request.getParameterMap();
        Payee payee=new Payee();
        try {
            BeanUtils.populate(payee,params);
            String userName=(String) request.getSession().getAttribute("userName");
            boolean falg=dao.addPayee(payee,"123");
            if(falg){
                this.query(request,response,dao);
            }else {
                request.getRequestDispatcher("./payee/addPayee.jsp").forward(request,response);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void toUpdate(HttpServletRequest request, HttpServletResponse response, PayeeDao dao) throws ServletException, IOException{
           Payee payee;
           String userName=request.getParameter("userName");
           String account=request.getParameter("account");
           payee=dao.getSelectPayee("123",account);
           request.setAttribute("payee",payee);
           request.setAttribute("oldAccount",payee.getAccount());
           request.getRequestDispatcher("./payee/updatePayee.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response, PayeeDao dao) throws ServletException, IOException{
        Map params=request.getParameterMap();
        Payee payee=new Payee();
        String oldAccount=request.getParameter("oldAccount");
        try {
            BeanUtils.populate(payee,params);
            String userName=(String)request.getSession().getAttribute("userName");
            boolean flag=dao.updatePayee(payee,"123",oldAccount);
            if(flag){
                request.getRequestDispatcher("./payee/payeeList.jsp").forward(request,response);
            }else{
                System.out.println("更新失败");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void query(HttpServletRequest request, HttpServletResponse response, PayeeDao dao) throws ServletException, IOException{
        List<Payee> payees=dao.queryPayee("123");
        request.setAttribute("payees",payees);
        request.getRequestDispatcher("./payee/payeeList.jsp").forward(request,response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response, PayeeDao dao) throws ServletException, IOException{
          String accounts=request.getParameter("accounts");
        System.out.println("进入delete servlet");
          dao.deletePayee(accounts,"123");
        request.getRequestDispatcher("./payee/payeeList.jsp").forward(request,response);
    }

    private void checkNoAccount(HttpServletRequest request, HttpServletResponse response,PayeeDao dao) throws ServletException, IOException{
        boolean flag=false;
        String account=request.getParameter("account");
        flag=dao.checkNoAccount("123",account);
        PrintWriter out=response.getWriter();
        if(flag){
            out.print("true");
        }else{
            out.print("false");
        }
    }


}
