package mybatis.test;

import java.io.IOException;
import java.io.Reader;

import mybatis.bean.UserInfo;
import mybatis.dao.userInfoDAO;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;

public class Test {
	public static void main(String[] args){

		try {
			Reader reader=Resources.getResourceAsReader("SqlMapConfig.xml");
			SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
			SqlSession session=factory.openSession();
			userInfoDAO dao=session.getMapper(userInfoDAO.class);
			UserInfo user=dao.getInfoById(2);
			System.out.println(user.getUser_id());
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
