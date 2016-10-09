package buy.dao;

import java.util.List;

import org.hibernate.Session;

public interface Dao {
	public void addObj(Object obj,Session session);
	public void updateObj(Object obj,Session session);
	public void deleteObj(Object obj,Session session);
	
	/**
	 * 传入一个对象全称比如User，再传入需要查找的属性名称
	 * @param obj 要查找的对象名称
	 * @param arg 根据某一个属性查找
	 * @param session 
	 * @return
	 */
	public Object findByString(String obj,String arg,Session session);
	
	/**
	 * 根据HQL语句查询出一个对象
	 * @param HQL
	 * @param session
	 * @return
	 */
	public Object findObj(String HQL,Session session);
	
	/**根据HQL语句查询出一个Set集合
	 * @param HQL
	 * @param session
	 * @return
	 */
	public List<?> findByHQL(String HQL,Session session);
	
	
	

}
