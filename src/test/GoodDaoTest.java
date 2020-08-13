package test;

import Dao.AdmainDao;
import Dao.GoodsDao;
import damain.Goods;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class GoodDaoTest {
  private   GoodsDao dao=new GoodsDao();
    @Test
    public void getAllGoods() throws SQLException {

        List<Goods> allGoods = dao.getAllGoods();

        System.out.println(allGoods);
    }
    @Test
    public void addgoods() throws SQLException {
        Goods goods=new Goods();
        goods.setName("my");
        goods.setPrice(35.5);
        goods.setImage("good_10.png");
     dao.addGoods(goods);
    }
    @Test
    public void dele() throws SQLException {
        dao.deleGoods(16);
    }

    @Test
    public void upate() throws SQLException {
        Goods goods=new Goods();
        goods.setId(15);
        goods.setName("me");
        goods.setPrice(41.6);
        goods.setImage("good_11.png");
        dao.upateGoods(goods);
    }
}
