package buy.service.register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.dao.UserDao;
import buy.dao.util.DaoUtil;
import buy.domain.User;
import buy.service.register.util.UserUtil;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	RegisterService rs=(RegisterService) context.getBean("registerService");
	private static final long serialVersionUID = 1L;
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpServletResponse response=ServletActionContext.getResponse();
	
	public String register(){
		
		User user=UserUtil.getBean(request, User.class);
		rs.saveUser(user);
		request.setAttribute("message", "注册成功！");
		request.setAttribute("user", user);
		return SUCCESS;
		
		
	}
	

	
	

}
