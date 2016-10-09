package buy.service.manage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import buy.dao.Dao;
import buy.dao.util.DaoUtil;
import buy.domain.User;
import buy.domain.goods.Manager;
import buy.util.HibernateUtil;
import buy.util.SpringUtil;

public class ManagerLoginServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Dao dao = (Dao) SpringUtil.getSpringBean("dao");
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		boolean flag = false;
		Manager manager = null;
		String HQL = "from Manager where name=" + "'" + name + "'";
		if (name != null){// 先判断用户名是否为空
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
		manager = (Manager) dao.findObj(HQL, session);
		session.getTransaction().commit();
		session.close();
		}
		if (manager == null) {
			request.setAttribute("fail", "用户名不存在！");
			request.getRequestDispatcher("/jsp/manage/Manager.jsp").forward(
					request, response);
			return;
		} else {
			if (manager.getPassword().equals(password))// 如果密码相等
			{
				request.getSession().setAttribute("manager", manager);
				response.sendRedirect("/buy/jsp/manage/ManageIndex.jsp");
			} else {
				request.setAttribute("fail", "密码不正确!");
				request.getRequestDispatcher("/jsp/manage/Manager.jsp")
						.forward(request, response);
			}
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
