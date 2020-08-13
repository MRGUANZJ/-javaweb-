package Dao;

import Util.DBCPUtil;
import damain.Admain;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class AdmainDao {
    public Admain checkAdmain(String name, String pwd) {
        QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select * from adminuser where username=? and password=?";
        Admain admain = null;
        try {
            admain = queryRunner.query(sql, new BeanHandler<Admain>(Admain.class), name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admain;


    }
}
