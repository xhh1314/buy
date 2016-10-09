package buy.service.manage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import buy.dao.Dao;
import buy.domain.goods.Category;
import buy.domain.goods.Subdivide;
import buy.util.GetBeanUtil;
import buy.util.HibernateUtil;
import buy.util.SpringUtil;

public class SubdivideServlet extends HttpServlet {
	private Dao dao;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("add")) {
			System.out.println("execute add method!");
			add(request, response);

		} else if (method.equals("beforAdd")) {

			beforAdd(request, response);
		} else if (method.equals("findAll")) {
			findAll(request, response);
		} else if (method.equals("findByName")) {
			findByName(request, response);
		} else if (method.equals("delete")) {
			delete(request, response);
		} else if (method.equals("update")) {
			update(request, response);
		} else if (method.equals("updateValue")) {
			updateValue(request, response);
		} else {

			request.setAttribute("mistake", "操作出错！");
			System.out.println("操作出错！");
			findAll(request, response);
		}
	}

	private void updateValue(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void findByName(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dao = (Dao) SpringUtil.getSpringBean("dao");
		Session session = HibernateUtil.getSessionFactory().openSession();
		request.setAttribute("subdivides",
				dao.findByHQL("from Subdivide", session));
		session.close();
		request.getRequestDispatcher("/jsp/manage/subdivide/ListSubdivide.jsp")
				.forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("name") != null) {// 名字不为空才进行下一步
			dao = (Dao) SpringUtil.getSpringBean("dao");
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			String HQL = "from Category where uuid=" + "'"
					+ request.getParameter("category") + "'";
			Category cat = (Category) dao.findObj(HQL, session);
			Subdivide sub = GetBeanUtil.getEmbeddedBean(request,
					Subdivide.class, "category");
			sub.setCategory(cat);
			dao.addObj(sub, session);
			session.getTransaction().commit();
			session.close();
			findAll(request, response);
		} else {
			request.setAttribute("fail", "商品名称不能为空!");
			request.getRequestDispatcher(
					"/jsp/manage/subdivide/AddSubdivide.jsp").forward(request,
					response);
		}
	}

	private void beforAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		dao = (Dao) SpringUtil.getSpringBean("dao");
		Session session = HibernateUtil.getSessionFactory().openSession();
		request.setAttribute("categorys",
				dao.findByHQL("from Category", session));
		request.getRequestDispatcher("/jsp/manage/subdivide/AddSubdivide.jsp")
				.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
