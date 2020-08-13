package Service;

import Dao.AdmainDao;
import damain.Admain;

public class AdmainService {

    public Admain longin(String name, String pwd) throws Exception {
        AdmainDao admainDao=new AdmainDao();
        Admain admain=admainDao.checkAdmain(name, pwd);
        if (admain!=null){
            return admain;
        }else {
            throw new Exception("用户名或者密码错误");
        }

    }
}
