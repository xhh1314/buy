package buy.dao;

import java.util.HashSet;

import org.hibernate.Session;

import buy.domain.User;

public interface UserDao {
	public Object findUser(String hql,Session session);
	public HashSet findUser(); 
	public void save(Object obj,Session session);
	public void delete(Object obj,Session session);
	public User findUserByName(String name,Session session);

}
