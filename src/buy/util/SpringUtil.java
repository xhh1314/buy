package buy.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	static ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	
	public static Object getSpringBean(String beanname){
		
		
		return context.getBean(beanname);
	}

}
