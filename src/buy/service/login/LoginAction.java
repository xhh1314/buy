package buy.service.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.dao.Dao;
import buy.dao.util.DaoUtil;
import buy.domain.User;
import buy.util.SpringUtil;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 4026424488095817936L;
	Dao dao=(Dao) SpringUtil.getSpringBean("dao");
	HttpServletRequest request=ServletActionContext.getRequest();
	public String login(){
	String name=request.getParameter("username");
	String password=request.getParameter("password");
	Session session=DaoUtil.getSessionFactory().openSession();
	String HQL="from User where username="+name;
	User user=(User) dao.findObj(HQL, session);
	if(user==null || !user.getPassword().equals(password)) //如果用户为空或者密码不匹配都登录失败
		return "fail";
	else return  SUCCESS; 
	}
	
	
}
