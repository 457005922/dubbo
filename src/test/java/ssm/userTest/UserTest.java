//package ssm.userTest;
//
//
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//
//import wh.user.domain.User;
//import wh.user.service.UserService;
//import wh.util.MD5Util;
//
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
//
//@RunWith(SpringJUnit4ClassRunner.class)   
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
//public class UserTest {
//
//    @Resource  
//    private UserService  userService ;  
//    @Test  
//    public void test1() {  
//    		User   user= userService.name();
//    		System.out.println(user.getName());
//    }  
//    
//    @Test
//    public void md5() {
//    	MD5Util md5Util = new MD5Util();
//    	String string = "ceshi";
//		String md5 = md5Util.getMD5(string);
//		System.out.println(md5);
//    }
//	
//}
