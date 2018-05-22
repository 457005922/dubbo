package wh.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import wh.user.dao.UserMapper;
import wh.user.domain.User;
import wh.user.service.UserService;


/**
 * 描述:
 *
 * @author hubugui
 * @version 0.1
 * @email hubugui@izjjf.cn
 * @since  2018/5/14
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired(required=false)
	private  UserMapper userMapper;
	

	public User  name() {
	User user =new User();
	user.setAge(1);
	user.setName("ceshi");
	user.setTel("15021168624");
	userMapper.insert(user);
	return user;
	
	}
	public User  getName() {
		User user = userMapper.selectByPrimaryKey(20);
		return user;
	}
}
