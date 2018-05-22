//package ssm.JedisTest;
//
//import java.awt.List;
//
//import javax.json.Json;
//import javax.json.JsonArray;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//@RunWith(SpringJUnit4ClassRunner.class)   
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
//public class JedisTest {
//	
//	 //redis¡¨Ω”≥ÿ  
//    @Autowired  
//    public JedisPool jedisPool;
//    
//    
//    @Test
//   public void jedis() {
//    	Jedis jedis = jedisPool.getResource();
//    	jedis.select(0);
//    	List list = new List();
//    	list.add("ces");
//    	list.add("123");
//    	jedis.set("hbg123", list.toString());
//    	String ceString  = jedis.get("hbg123");
//    	System.out.println(ceString);
//    }
//
//}
