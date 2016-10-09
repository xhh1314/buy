package buy.dao.imp;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import buy.dao.Dao;

public class DaoImp implements Dao {

	@Override
	public void addObj(Object obj, Session session) {
		// TODO Auto-generated method stub
		session.save(obj);

	}

	@Override
	public void updateObj(Object obj, Session session) {
		// TODO Auto-generated method stub
		session.update(obj);

	}

	@Override
	public void deleteObj(Object obj, Session session) {
		// TODO Auto-generated method stub
		session.delete(obj);

	}

	@Override
	public Object findByString(String obj, String arg, Session session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findObj(String HQL, Session session) {
		// TODO Auto-generated method stub
		return session.createQuery(HQL).uniqueResult();
	}

	@Override
	public List<?> findByHQL(String HQL, Session session) {
		// TODO Auto-generated method stub
		return session.createQuery(HQL).list();
	}

}
