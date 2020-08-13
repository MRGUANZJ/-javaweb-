package Web;

import Service.CategoryService;
import Service.GoodsService;
import Util.BaseServletUtil;
import damain.Category;
import damain.Goods;
import damain.PageBean;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/GoodsServlet")
public class GoodsServlet extends BaseServletUtil {
    //更新的UI，通过获取id来确定商品
    public String updateUIGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        String id = req.getParameter("id");
        // System.out.println(id);
        try {
            //获取当前商品的id
            GoodsService goodsService = new GoodsService();
            Goods goodsID = goodsService.getGoodsID(id);
            req.setAttribute("goods", goodsID);
            //  System.out.println("1111"+goodsID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //分类
        try {
            CategoryService categoryService = new CategoryService();
            List<Category> category = null;
            category = categoryService.findCategory();
            req.setAttribute("allcategory", category);
            // System.out.println(category);
            return "admin/edit.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //增加商品
    public String addGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        //获取所有对象
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(parameterMap);
        Goods goods = new Goods();
        try {
            BeanUtils.populate(goods, parameterMap);
            //  System.out.println(goods);
            //调用服务层
            GoodsService goodsService = new GoodsService();
            goodsService.addGoods(goods);
            return "/GoodsServlet?action=getListGoods";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //更新商品
    public String updateGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        Map<String, String[]> parameterMap = req.getParameterMap();
        Goods goods = new Goods();

        try {
            BeanUtils.populate(goods, parameterMap);
            System.out.println(goods);
            GoodsService goodsService = new GoodsService();
            goodsService.updateGood(goods);
            //  System.out.println(goods);
            return "/GoodsServlet?action=getListGoods";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除商品
    public String delGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.getRequestDispatcher("/del.jsp").forward(req,resp);
        //接收参数id
        String id = req.getParameter("id");

        //调用服务层，让其删除商品
        GoodsService goodsService = new GoodsService();
        try {
            goodsService.deleteGoods(id);
            System.out.println("删除");
            return "/GoodsServlet?action=getListGoods";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取所有的方法
    public String getListGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        GoodsService goodsService = new GoodsService();
        List<Goods> allgoods;
        try {
            allgoods = goodsService.getAllGoods();
            //对集合反转
            Collections.reverse(allgoods);
            //  System.out.println(allgoods);
            req.setAttribute("allgoods", allgoods);
            //  req.getRequestDispatcher("admin/main.jsp").forward(req,resp);
            return "admin/main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取分页
    public String getPageDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setCharacterEncoding("utf-8");
            //获得当前的页码
            String currentPage = req.getParameter("currentPage");
            //把业码给业务层 根据页码给我一个pageBean
            GoodsService goodsService = new GoodsService();
            PageBean pageBean = null;
            pageBean = goodsService.getPageBean(Integer.parseInt(currentPage));
            //把pageBean写到域当中
            req.setAttribute("pageBean", pageBean);
            //转发
            return "admin/main.jsp";
        } catch (SQLException | UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("我可以所有反射调用异常>>" + e.getCause());
        }
        return null;
    }

}
