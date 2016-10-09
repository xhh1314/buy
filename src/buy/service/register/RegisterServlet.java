package buy.service.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.domain.User;
import buy.service.register.util.UserUtil;
import buy.util.GetBeanUtil;
import buy.util.SpringUtil;

public class RegisterServlet extends HttpServlet {
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RegisterService rs=(RegisterService) SpringUtil.getSpringBean("registerService");
		User user=null;
		try {
			user = GetBeanUtil.getUserBean(request, User.class);
			rs.saveUser(user);
			request.setAttribute("message", "注册成功！");
			request.setAttribute("user", user);
			request.getRequestDispatcher("/jsp/Message.jsp").forward(request, response);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "注册失败请重新注册！");
			request.getRequestDispatcher("/jsp/Message.jsp").forward(request, response);
			return;
		}
	
		

	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request,response);
	}

}
