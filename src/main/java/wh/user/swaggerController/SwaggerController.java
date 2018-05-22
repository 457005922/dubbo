package wh.user.swaggerController;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import wh.user.domain.User;
import wh.user.service.UserService;

@Controller
@RequestMapping("/swaggerController")
@Api(value = "/swaggerController", tags = "swagger���Խӿ�")  
public class SwaggerController {
	
	    @Resource(name ="userService")
		private UserService userService;
		
	   
	    @ApiOperation(value = "����id��ȡ�û���Ϣ", notes = "����id��ȡ�û���Ϣ") 
	    @ResponseBody
	    @RequestMapping(value = "/getUser",method=RequestMethod.GET)
	    public User getUser(@ApiParam(required=true,value="�û�ID",name="userId")@RequestParam(value="userId")Integer userId) {  
			System.out.println(userId);
	        return userService.name();  
	    }  
	   
//	    @ApiOperation(value = "����", notes = "����") 
	    @ResponseBody
	    @RequestMapping(value = "/sava",method=RequestMethod.GET)
	    public User sava() {  
	        return userService.name();  
	    }  
}
