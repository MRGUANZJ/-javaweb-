package Web;


import Service.CategoryService;
import damain.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * 新增商品
 */
@WebServlet(urlPatterns = "/GoodsAddUIServlet")
public class GoodsAddUIServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.取出所有分类
        CategoryService categoryService = new CategoryService();
        try {
            List<Category> category = categoryService.findCategory();
          //  System.out.println(category);

            //2.把分类存域当中
            req.setAttribute("allcategory", category);

            //3.转发add。jsp
            req.getRequestDispatcher("admin/add.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
