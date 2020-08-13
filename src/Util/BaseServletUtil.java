package Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServletUtil extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String despath = null;
        //接收参数
        String action = req.getParameter("action");
        System.out.println(action);
//        if ("add".equals(action)){
//            //添加
//            despath=add(req,resp);
//        } else if ("del".equals(action)){
//                  //删除
//            despath=del(req,resp);
//        }else if ("update".equals(action)){
//                 //更新
//            despath=update(req,resp);
//        }

        try {
            //获得当前对象的字节码
            Class clazz = this.getClass();
            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            if (method != null) {
                //如果有就调用
                despath = (String) method.invoke(this, req, resp);
                //System.out.println("invoke" + despath);
                //转发
                if (despath != null) {
                    //System.out.println("path" + despath);
                    req.getRequestDispatcher("/" + despath).forward(req, resp);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("我可以所有反射调用异常,这次异常具体原因是>>"+e.getCause());
        }
//        转发
//        if (despath!=null){
//            req.getRequestDispatcher(despath).forward(req,resp);
//        }
    }
}

