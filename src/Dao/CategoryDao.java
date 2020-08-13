package Dao;

import Util.DBCPUtil;
import damain.Category;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 查找数据库
 */
public class CategoryDao {
    public List<Category> findAllCategory() throws SQLException {

        QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select * from category";
        List<Category> allcategory = queryRunner.query(sql, new BeanListHandler<Category>(Category.class));
        return allcategory;
    }
}
