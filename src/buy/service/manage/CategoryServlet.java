package buy.service.manage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import buy.dao.Dao;
import buy.domain.goods.Category;
import buy.util.GetBeanUtil;
import buy.util.HibernateUtil;
import buy.util.SpringUtil;

public class CategoryServlet extends HttpServlet {
	private Dao dao=(Dao) SpringUtil.getSpringBean("dao");
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("add"))
		{
			System.out.println("execute add method!");
			add(request, response);
			
		}
		else if(method.equals("findAll"))
		{
			findAll(request, response);
		}
		else if(method.equals("findByName"))
		{
			findByName(request, response);
		}
		else if(method.equals("delete"))
		{
			delete(request, response);
		}
		else if(method.equals("update"))
		{
			update(request, response);
		}
		else if(method.equals("updateValue"))
		{
			updateValue(request, response);
		}
		else{
			
			request.setAttribute("mistake", "操作出错！");
			System.out.println("操作出错！");
			findAll(request, response);
		}
	}
	
	private void updateValue(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Category ct=GetBeanUtil.getUpdateBean(request, Category.class);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		dao.updateObj(ct, session);
		session.getTransaction().commit();
		session.close();
		findAll(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String HQL="from Category where uuid="+"'"+request.getParameter("uuid")+"'";
		Category cat=(Category) dao.findObj(HQL, session);
		session.getTransaction().commit();
		session.close();
		request.setAttribute("category", cat);
		request.getRequestDispatcher("/jsp/manage/category/UpdateCategory.jsp").forward(request, response);
	}
	
	

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String HQL="from Category where uuid="+"'"+request.getParameter("uuid")+"'";
		Category cat=(Category) dao.findObj(HQL, session);
		dao.deleteObj(cat, session);
		session.getTransaction().commit();
		session.close();
		findAll(request, response);
	}

	private void findByName(HttpServletRequest request,
			HttpServletResponse response) {
		String name=request.getParameter("name");
		Category category=null;
		if(name!=null){
			Session session=HibernateUtil.getSessionFactory().openSession();
			String HQL="from Category where name="+"'"+name+"'";
			category=(Category) dao.findObj(HQL, session);
			session.close();
		}
		
		
	}

	private void findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Session session=HibernateUtil.getSessionFactory().openSession();
		Session session=HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String HQL="from Category";
		List<Category> categorys=(List<Category>) dao.findByHQL(HQL, session);
		session.getTransaction().commit();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("/jsp/manage/category/ListCategory.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("name")!=null)
		{
		Category category=GetBeanUtil.getBean(request, Category.class);
		Session session=HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		dao.addObj(category, session);
		session.getTransaction().commit();
		session.close();
		findAll(request, response);
		}
		
		
		
	}
	


	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	
	}

}
