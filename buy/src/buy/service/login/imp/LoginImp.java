package buy.service.login.imp;

import org.hibernate.Session;

import buy.dao.util.DaoUtil;
import buy.domain.User;
import buy.service.login.Login;

public class LoginImp implements Login{

	@Override
	public  User findUser(String name) {
		// TODO Auto-generated method stub
		Session session=DaoUtil.getSessionFactory().getCurrentSession();
		session.
		
		
		return user;
	}

}
