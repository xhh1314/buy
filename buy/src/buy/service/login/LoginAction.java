package buy.service.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.domain.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	static {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	}
	private static final long serialVersionUID = 4026424488095817936L;
	private Login login;
	HttpServletRequest request=ServletActionContext.getRequest();
	public String login(){
	String name=request.getParameter("username");
	String password=request.getParameter("password");
	User user=login.findUser(name);
	if(user==null || !user.getPassword().equals(password)) //如果用户为空或者密码不匹配都登录失败
		return "fail";
	else return  SUCCESS; 
	}
	
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	
}
