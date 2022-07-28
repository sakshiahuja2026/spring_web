package com.dao;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository // spring.xml map -> spring bean
public class UserDao {
	@Autowired // spring.xml or stereotype annotation
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users (firstname,lastname,email,gender,password,usertype) values (?,?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getGender(), user.getPassword(),
				user.getUserType());
	}
	public List<UserBean> getAllUsers(){
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;
	}
	public void deleteUser(int userId) {
		
		stmt.update("delete from users where userid = ? ",userId);
	}
	public UserBean getUserByUserId(int userId) {
		UserBean user = stmt.queryForObject("select * from users where userId = ?",new BeanPropertyRowMapper<UserBean>(UserBean.class),new Object[] {userId});
		return user;
	}
	public void updateUser(UserBean user) {
		stmt.update("update users set firstname = ? , lastname = ? ,email = ? where userid = ? ", user.getFirstName(),
				user.getLastName(), user.getUserId());
	}

	public UserBean authenticate(LoginBean loginBean) {
		UserBean user = null;

		try {
		user = stmt.queryForObject("select * from users where email = ? and password = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { loginBean.getEmail(), loginBean.getPassword() });
		}catch(Exception e) {
			System.out.println("invalid email password");
		}
		return user;
	}
	
}
