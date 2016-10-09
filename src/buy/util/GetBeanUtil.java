package buy.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.ServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import sun.misc.BASE64Encoder;

public class GetBeanUtil {
	public static <T> T getBean(ServletRequest request, Class<T> bean) {
		Enumeration<String> e = request.getParameterNames();
		T obj = null;
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			obj = bean.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}
		while (e.hasMoreElements()) {// 遍历所有参数，把数据封装到bean里
			String name = e.nextElement();
			String value = request.getParameter(name);
			try {
				BeanUtils.setProperty(obj, name, value);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			}
		}
		try {
			//单独使用UUID随机产出一个id码
			BeanUtils.setProperty(obj, "uuid", UUID.randomUUID().toString());
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}

		return obj;
	}
	
	/**封装一个有引用变量的bean
	 * @param request
	 * @param bean
	 * @param embeddedName
	 * @return
	 */
	public static <T> T getEmbeddedBean(ServletRequest request, Class<T> bean,String embeddedName) {
		Enumeration<String> e = request.getParameterNames();
		T obj = null;
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			obj = bean.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}
		while (e.hasMoreElements()) {// 遍历所有参数，把数据封装到bean里
			String name = e.nextElement();
			String value = request.getParameter(name);
			try {
				if(!name.equals(embeddedName))
				BeanUtils.setProperty(obj, name, value);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			}
		}
		try {
			//单独使用UUID随机产出一个id码
			BeanUtils.setProperty(obj, "uuid", UUID.randomUUID().toString());
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}

		return obj;
	}
	
	
	public static <T> T getUpdateBean(ServletRequest request, Class<T> bean) {
		Enumeration<String> e = request.getParameterNames();
		T obj = null;
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			obj = bean.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}
		while (e.hasMoreElements()) {// 遍历所有参数，把数据封装到bean里
			String name = e.nextElement();
			String value = request.getParameter(name);
			try {
				BeanUtils.setProperty(obj, name, value);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			}
		}
		

		return obj;
	}
	
	/**
	 * 改方法返回password通过MD5加密之后的User
	 * @param request
	 * @param bean
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static <T> T getUserBean(ServletRequest request, Class<T> bean) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Enumeration<String> e = request.getParameterNames();
		T obj = null;
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		try {
			obj = bean.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}
		while (e.hasMoreElements()) {// 遍历所有参数，把数据封装到bean里
			String name = e.nextElement();
			String value = request.getParameter(name);
			try {
				if(name.equals("password"))//属性是密码的话，进行加密
					BeanUtils.setProperty(obj, name, getMd5(value));
				else
				BeanUtils.setProperty(obj, name, value);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e1);
			}
		}
		try {
			//单独使用UUID随机产出一个id码
			BeanUtils.setProperty(obj, "uuid", UUID.randomUUID().toString());
			
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e1);
		}

		return obj;
	}
	
	public static String getMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 // 确定计算方法
	       MessageDigest md5 = MessageDigest.getInstance("MD5");
	       BASE64Encoder base64en = new BASE64Encoder();
	       // 加密后的字符串
	       String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
	       return newstr;
	}



}
