package Service;

import Dao.GoodsDao;
import damain.Goods;
import damain.PageBean;

import java.sql.SQLException;
import java.util.List;

public class GoodsService {

    //获取所有的数据
    public List<Goods> getAllGoods() throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        List<Goods> goodsAll = goodsDao.getAllGoods();
        return goodsAll;
    }

    //删除数据
    public void deleteGoods(String id) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        //转换成int类型
        goodsDao.deleGoods(Integer.parseInt(id));
    }

    //增加数据
    public void addGoods(Goods goods) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        goodsDao.addGoods(goods);

    }

    //更新数据
    public void updateGood(Goods goods) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        goodsDao.upateGoods(goods);
    }

    //查找id
    public Goods getGoodsID(String id) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();
        Goods goodsId = goodsDao.getGoodsId(id);
        return goodsId;

    }

    //查找页码
    public PageBean getPageBean(Integer currentPage) throws SQLException {
        GoodsDao goodsDao = new GoodsDao();

        PageBean pageBean = new PageBean();
        //设置当前页
        pageBean.setCurrentPage(currentPage);
        //从数据库查询
        Long count = goodsDao.getCount();
        //获取当前有多少给记录
        pageBean.setTotalCount(count.intValue());
        //一页展示多少条(从多少开始)
        Integer pageCount = 0;
        //一次需要多少条
        Integer needshow = 5;
        //总页数
        double totaPage = Math.ceil(1.0 * pageBean.getTotalCount() / needshow);
        pageBean.setTotalPage((int) totaPage);

        //需要                  当前是哪一页
        // Integer show=(pageBean.getCurrentPage()*needshow);
        //计算数据
        Integer count1 = (pageBean.getCurrentPage() * needshow);
        List<Goods> list = goodsDao.getPageDate(needshow, pageCount, (count1 - needshow));
        pageBean.setGoodsList(list);

        return pageBean;
    }
}
