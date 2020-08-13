package Service;

import Dao.CategoryDao;
import damain.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * 查找分类信息
 */
public class CategoryService {
    public List<Category> findCategory() throws SQLException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> allCategory = categoryDao.findAllCategory();

        return allCategory;
    }
}
