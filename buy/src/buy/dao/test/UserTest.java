package buy.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.dao.UserDao;
import buy.domain.User;
import buy.service.login.LoginAction;
import buy.service.register.RegisterAction;

public class UserTest {
	
	/*static{
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	}*/
	


	@Test
	public void SaveTest(){
		User user=new User();
		user.setUsername("lihao");
		user.setUuid("232FSDFAF31");
		user.setEmail("9034@qq.com");
		user.setPassword("ddddd22222");
		user.setTelephone("15901015121");
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		RegisterAction ra=(RegisterAction) context.getBean("registerAction");
		System.out.println("开始保存数据");
		
		
	}

	

}
