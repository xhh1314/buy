package buy.dao.imp;

import java.util.HashSet;

import org.hibernate.Query;
import org.hibernate.Session;

import buy.dao.UserDao;
import buy.dao.util.DaoUtil;
import buy.domain.User;

public class UserDaoImp implements UserDao {

	public Object findUser(String hql,Session session) {
		// TODO Auto-generated method stub
		return session.createQuery(hql).uniqueResult();
		
	}

	
	public HashSet findUser() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(Object obj,Session session) {
		
		session.save(obj);
		
	}


	@Override
	public void delete(Object obj,Session session) {
		// TODO Auto-generated method stub
		session.delete(obj);
	}


	@Override
	public User findUserByName(String name,Session session) {
		// TODO Auto-generated method stub
	return 	(User)session.createQuery("from User where username=?").setString(0,name).uniqueResult();
		
	}

}
