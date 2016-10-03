package buy.service.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.domain.User;

public class LoginServlet extends HttpServlet {
	static private ApplicationContext context;
	static {
		context=new ClassPathXmlApplicationContext("beans.xml");
	}
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
		
		Login login=(Login) context.getBean("login");
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		User user=login.findUser(name);
		if(user!=null && user.getPassword().equals(password)){//如果用户为空或者密码不匹配都登录失败
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
		response.sendRedirect("/buy/jsp/buy/Main.jsp");
		}
		else
		{
			request.getRequestDispatcher("/jsp/Login.jsp").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/*public LoginServlet(Login login) {
		this.login = login;
	}

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	*/
}
