package buy.service.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import buy.dao.Dao;
import buy.dao.util.DaoUtil;
import buy.domain.User;
import buy.util.GetBeanUtil;
import buy.util.SpringUtil;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao dao = (Dao) SpringUtil.getSpringBean("dao");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if(password!=null){//如果密码不为空才进行加密
		try {//使用MD5算法加密一下password
			password=GetBeanUtil.getMd5(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		}
		User user = null;
		if (name != null) {// 姓名不为空才进行查询
			Session session = DaoUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String HQL = "from User where username=" + "'"+name+"'";
			user = (User) dao.findObj(HQL, session);
			session.getTransaction().commit();
			session.close();
		}
		
		if (user == null) {// 如果用户为空
			request.setAttribute("fali", "用户名不存在！");
			request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
					response);
		} else {

			if (user.getPassword().equals(password)) {// 如果密码匹配成功
				request.getSession().setAttribute("user", user);
				response.sendRedirect("/buy/jsp/buy/Main.jsp");
			} else {
				request.setAttribute("fail", "用户名或者密码不正确");
				request.getRequestDispatcher("/jsp/Login.jsp").forward(request,
						response);
			}
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/*
	 * public LoginServlet(Login login) { this.login = login; }
	 * 
	 * public LoginServlet() { // TODO Auto-generated constructor stub }
	 */
}
