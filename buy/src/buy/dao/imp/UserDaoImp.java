package buy.dao.imp;

import java.util.HashSet;

import org.hibernate.Session;

import buy.dao.UserDao;
import buy.dao.util.DaoUtil;
import buy.domain.User;

public class UserDaoImp implements UserDao {

	public User findUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public HashSet<User> findUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(User user) {
		Session session=DaoUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
	}

}
