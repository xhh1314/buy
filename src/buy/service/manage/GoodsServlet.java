package buy.service.manage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;

import buy.dao.Dao;
import buy.domain.goods.Goods;
import buy.domain.goods.Subdivide;
import buy.util.HibernateUtil;
import buy.util.SpringUtil;
import buy.util.UUIDUtil;

public class GoodsServlet extends HttpServlet {
	Dao dao = (Dao) SpringUtil.getSpringBean("dao");

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
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

	private void beforAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// dao=(Dao) SpringUtil.getSpringBean("dao");
		Session session = HibernateUtil.getSessionFactory().openSession();
		request.setAttribute("subdivides",
				dao.findByHQL("from Subdivide", session));
		session.close();
		request.getRequestDispatcher("/jsp/manage/goods/AddGoods.jsp").forward(request, response);

	}

	/*private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// dao=(Dao) SpringUtil.getSpringBean("dao");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Subdivide sub = (Subdivide) dao.findObj("from Subdivide where uuid="
				+ "'" + request.getParameter("subdivide") + "'", session);
		Goods goods = new Goods();
		goods.setDescription(request.getParameter("description"));
		goods.setImage_location(request.getParameter("imageLocation"));
		goods.setName(request.getParameter("name"));
		goods.setSubdivide(sub);
		goods.setUuid(UUIDUtil.getUUID());
		fileUplod(request, response,goods);
		dao.addObj(goods, session);
		session.getTransaction().commit();
		session.close();
		findAll(request, response);

	}
*/
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// dao=(Dao) SpringUtil.getSpringBean("dao");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Subdivide sub = (Subdivide) dao.findObj("from Subdivide where uuid="
				+ "'" + request.getParameter("subdivide") + "'", session);
		Goods goods = new Goods();
		goods.setSubdivide(sub);
		goods.setUuid(UUIDUtil.getUUID());
		fileUplod(request, response,goods);
		dao.addObj(goods, session);
		session.getTransaction().commit();
		session.close();
		findAll(request, response);
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
		// dao=(Dao) SpringUtil.getSpringBean("dao");
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Goods> goods = (List<Goods>) dao.findByHQL("from Goods", session);
		session.close();
		request.setAttribute("goods", goods);
		request.getRequestDispatcher("/jsp/manage/goods/ListGoods.jsp")
				.forward(request, response);

	}
	
	private void fileUplod(HttpServletRequest request, HttpServletResponse response,Goods goods)
			throws ServletException, IOException {
		System.out.println("aaaa");
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//设置临时文件存放路径
		factory.setRepository(new File(this.getServletContext().getRealPath("")+"\\resource\\data"));
		ServletFileUpload upload=new ServletFileUpload(factory);
		//注册一个监听器  需要再web.xml文件里配置
		//upload.setProgressListener(new MyProgressListener(request));
		String path=this.getServletContext().getRealPath("")+"\\resource\\data"; 
		//upload.setFileSizeMax(1024);//设置文件上传最大值
		upload.setHeaderEncoding("utf-8");//解决上传文件中文乱码问题
		if(!upload.isMultipartContent(request)){
			System.out.println("不是上传文件");
			return;
		}
			try {
				List<FileItem> list=upload.parseRequest(request);
				for(FileItem e:list)
				{
					if(e.isFormField()){//如果是表单元素，则封装进bean
						String name=e.getFieldName();
						String value=e.getString("UTF-8");
						//String value=new String(e.getString().getBytes("iso8859-1"),"utf-8");
						try {
							if(!name.equals("subdivide"))
							BeanUtils.setProperty(goods, name, value);
						} catch (IllegalAccessException e1) {
							// TODO Auto-generated catch block
							throw new RuntimeException();
						} catch (InvocationTargetException e1) {
							// TODO Auto-generated catch block
							throw new RuntimeException();
						}
						System.out.println("name:"+name+"value:"+value);
								
					}
					else{
						String fileName=e.getName();
						//fileName=new String(fileName.getBytes("iso8859-1"),"utf-8"); 不能使用这种方式转码
						fileName=fileName.substring(fileName.lastIndexOf("\\")+1);//截取
						String realpath=makePath(fileName, path);//根据原始文件名经过hash算法生成路径
						String fileCurrentPath=makeCurrentPath(fileName);
						fileName=makeFilename(fileName);//转成随机名字
						
						fileCurrentPath="resource/data/"+fileCurrentPath+fileName;//生成存入数据库的路径+文件名称
						InputStream in=e.getInputStream();
						File file=new File(realpath);
						if(!file.exists())//如果路径不存在，则创建路径
							file.mkdirs();
						FileOutputStream out=new FileOutputStream(realpath+"\\"+fileName);
						System.out.println("读取到上传文件");
						byte[] temp=new byte[(int) e.getSize()];
						int len=0;
						while((len=in.read(temp))>0){
							out.write(temp,0,len);
							
						}
						in.close();
						out.close();
						e.delete();//删除缓存文件
						System.out.println("上传文件成功！");
						//设置goods image_location属性
						goods.setImage_location(fileCurrentPath);
					}
				}
			} 
			catch(FileSizeLimitExceededException e)//捕捉到文件大小太大的异常
			{
				request.setAttribute("fail", "你上传的文件大小超过"+upload.getFileSizeMax()+"kb");
				request.getRequestDispatcher("/jsp/manage/goods/AddGoods.jsp").forward(request, response);
				e.printStackTrace();
			}
			catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.setAttribute("fail", "上传文件不成功！");
				request.getRequestDispatcher("/jsp/manage/goods/AddGoods.jsp").forward(request, response);
			}

	}
	/**
	 * 得到一个文件存储目录
	 * @param filename
	 * @return
	 */
	private String makeFilename(String filename){
		
		
		return UUID.randomUUID().toString()+"_"+filename;//得到一个随机名字
	}
	
	/**
	 * 文件存储目录分散算法
	 * @param filename
	 * @param path
	 * @return
	 */
	private String makePath(String filename,String path){
		int hashcode=filename.hashCode();
		int dir1=hashcode&0xf;
		int dir2=(hashcode&0xf0)>>4;
		return path+"\\"+dir1+"\\"+dir2;
	}
	private String makeCurrentPath(String filename){
		int hashcode=filename.hashCode();
		int dir1=hashcode&0xf;
		int dir2=(hashcode&0xf0)>>4;
		return dir1+"/"+dir2+"/";
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
