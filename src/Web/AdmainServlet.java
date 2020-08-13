package Web;

import Service.AdmainService;
import damain.Admain;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/AdminServlet")
public class AdmainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        //接收用户名和密码
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        //调用 登录业务
        AdmainService admainService = new AdmainService();

        try {
            Admain admain = admainService.longin(name, password);
            HttpSession session = req.getSession();
            System.out.println(admain);
            //1.把用户保存在session
            session.setAttribute("admain", admain);
            session.getAttribute("admain");
            System.out.println(session);
            //2.跳转到后台首页
            //重定向，让浏览器去跳转到指定的位置
            resp.sendRedirect(req.getContextPath() + "/admin/admin_index.jsp");
            //  resp.setHeader("refresh","2;url=/_war_exploded/admin/admin_index.jsp");
        } catch (Exception e) {

            if (e.getMessage().equals("用户名或者密码错误")) {
                System.out.println("登录失败");
                //跳转登录面页，回显错误信息
                req.setAttribute("err", e.getMessage());
                //转发,服务器内部的转发
                req.getRequestDispatcher("admin/admin_login.jsp").forward(req, resp);

            } else {
                e.printStackTrace();
            }
        }
//        req.setAttribute("admain",admains);
//        req.getRequestDispatcher("/admin/admin_login.jsp").forward(req,resp);
    }
}
