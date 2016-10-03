package buy.service.register;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import buy.dao.UserDao;
import buy.dao.util.DaoUtil;
import buy.domain.User;

public class RegisterService {
	UserDao dao;
	public void saveUser(User user)
	{
		dao.save(user);
	}
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	

}
