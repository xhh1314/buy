package buy.service.register.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;
import javax.servlet.ServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class UserUtil {
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

}
