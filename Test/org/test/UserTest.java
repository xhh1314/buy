package org.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.dao.UserDao;
import buy.dao.imp.UserDaoImp;
import buy.dao.util.DaoUtil;
import buy.domain.Role;
import buy.domain.Source;
import buy.domain.User;
import buy.service.register.RegisterAction;

public class UserTest {
	@Test
	public void initialied(){
		Configuration cfg=new Configuration().configure();
		SchemaExport se=new SchemaExport(cfg);
		se.create(true, false);
	}
	
	@Test
	public void saveTest(){
		User user=new User();
		user.setUsername("lihao");
		user.setUuid("232FSDFAF31");
		user.setEmail("9034@qq.com");
		user.setPassword("ddddd22222");
		user.setTelephone("15901015121");
		UserDao ud=new UserDaoImp();
		System.out.println("开始保存数据");
		Role role1=new Role();
		role1.setName("book");
		role1.setUuid("10");
		Set<Source> set1=new HashSet<Source>();
		role1.setSources(set1);
		Session session=DaoUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(int i=0;i<5;i++)
		{
			Source source=new Source();
			source.setName("book"+(i+1));
			source.setUuid(""+(i*10+1));
			role1.getSources().add(source);
			ud.save(source,session);	
		}
		Role role2=new Role();
		role2.setName("map");
		role2.setUuid("20");
		Set<Source> set2=new HashSet<Source>();
		role2.setSources(set2);
		for(int i=0;i<5;i++)
		{
			Source source=new Source();
			source.setName("map"+(i+1));
			source.setUuid(""+(i*20+2));
			role2.getSources().add(source);
			ud.save(source,session);	
		}
		
		Set<Role> set3=new HashSet<Role>();
		user.setRoles(set3);
		ud.save(role1,session);//save role1
		ud.save(role2, session);//save role2
		user.getRoles().add(role1);
		user.getRoles().add(role2);
		ud.save(user,session);//save user
		session.getTransaction().commit();
		session.close();
	}
	@Test
	public void deleteTest(){
		UserDao ud=new UserDaoImp();
		Session session=DaoUtil.getSessionFactory().openSession();
		String hql="from User";
		session.beginTransaction();
		User user=(User) ud.findUser(hql, session);
		System.out.println(user);
		ud.delete(user, session);
		session.getTransaction().commit();
		
	}

}
