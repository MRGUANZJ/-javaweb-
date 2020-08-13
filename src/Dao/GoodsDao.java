package Dao;

import Util.DBCPUtil;
import damain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class GoodsDao {
    //1.查询数据库
    private QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());

    //1.从数据库中查询当前所有商品
    public List<Goods> getAllGoods() throws SQLException {

        String sql = "select * from goods";
        List<Goods> allgoods = null;
        allgoods = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class));
        return allgoods;
    }


    //2.添加商品到数据库
    public void addGoods(Goods goods) throws SQLException {
        String sql = "insert into goods(name,price,image,demc,ishot,cid) values(?,?,?,?,?,?)";
        queryRunner.update(sql, goods.getName(), goods.getPrice(), goods.getImage(), goods.getDemc(), goods.getIshot(), goods.getCid());
    }

    //3.根据id删除商品

    public void deleGoods(int id) throws SQLException {
        String sql = "delete from goods where id=?";
        queryRunner.update(sql, id);
    }

    //4.更新商品
    public void upateGoods(Goods goods) throws SQLException {
        String sql = "update goods set name=?,price=?,image=?,demc=?,ishot=?,cid=? where id=?";
        queryRunner.update(sql, goods.getName(), goods.getPrice(), goods.getImage() , goods.getDemc(), goods.getIshot(),goods.getCid(), goods.getId());
    }
    //查询id
    public Goods getGoodsId(String id) throws SQLException {
        String sql="select * from goods where id=?";
        Goods goods = queryRunner.query(sql, new BeanHandler<Goods>(Goods.class), Integer.parseInt(id));
        return goods;
    }
//查询总记录条数
    public Long getCount() throws SQLException {
        String sql="select count(*) from goods";
        Long count = Long.parseLong(queryRunner.query(sql, new ScalarHandler()).toString());
        return count;
    }

    public List<Goods> getPageDate(Integer needshow, Integer pageCount,Integer count) throws SQLException {
        String sql="select top (?) * from goods where id not in (select top (?+"+count+") id from goods)";
        List<Goods> pagegoods = null;
        pagegoods = queryRunner.query(sql, new BeanListHandler<Goods>(Goods.class),needshow,pageCount);
        return pagegoods;
    }
}
