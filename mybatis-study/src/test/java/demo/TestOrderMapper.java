package demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.dao.OrderMapper;
import demo.entity.OrderUser;

public class TestOrderMapper {
	private OrderMapper order;
	private Logger log = LoggerFactory.getLogger(TestOrderMapper.class);
	
	@Before
	public void setUpBefore() throws IOException{
		InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		order = sqlSession.getMapper(OrderMapper.class);
				
	}
	
	@Test
	public void testSelectOrderUserByOrderNumber(){
		OrderUser orerUser = order.selectOrderUserByOrderNumber("201807010001");
		log.info(orerUser.toString());
		System.out.println(orerUser);
	}
}
