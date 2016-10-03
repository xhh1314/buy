package buy.dao;

import java.util.HashSet;

import buy.domain.User;

public interface UserDao {
	public User findUser(String name);
	public HashSet<User> findUser(); 
	public void save(User user);

}
