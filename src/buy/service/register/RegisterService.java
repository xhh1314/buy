package buy.service.register;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import buy.dao.UserDao;
import buy.dao.util.DaoUtil;
import buy.domain.User;

public class RegisterService {
	UserDao dao;
	Session session=DaoUtil.getSessionFactory().openSession();
	public void saveUser(User user)
	{
		session.beginTransaction();
		dao.save(user,session);
		session.getTransaction().commit();
		session.close();
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	

}
