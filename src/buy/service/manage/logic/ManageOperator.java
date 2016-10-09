package buy.service.manage.logic;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import buy.dao.Dao;
import buy.domain.goods.Goods;
import buy.service.register.util.UserUtil;
import buy.util.GetBeanUtil;
import buy.util.HibernateUtil;

public class ManageOperator {
	Dao dao;
	Session session=HibernateUtil.getSessionFactory().openSession();
	public boolean saveGoods(HttpServletRequest request){
		boolean flag=true;
		try {
			session.beginTransaction();
			Goods goods = GetBeanUtil.getBean(request, Goods.class);
			dao.addObj(goods, session);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			flag=false;
			throw new RuntimeException();
		}
		return flag;
	}
	
	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public ManageOperator() {
		
	}
	
	
	

	

}
