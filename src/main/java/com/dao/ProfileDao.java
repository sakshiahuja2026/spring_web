package com.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.ProfileBean;

@Repository
public class ProfileDao {
	@Autowired
	JdbcTemplate stmt;

	public void addImg(ProfileBean profile) {
		stmt.update("insert into profile (userid,imgurl,active) values (?,?,?)", profile.getUserId(),
				profile.getImgUrl(), profile.getActive());
	}
	
	public List<ProfileBean> getAllProfileImagesByUser(int userId)
	{
		return stmt.query("select * from profile where userid = ? ",new BeanPropertyRowMapper<ProfileBean>(ProfileBean.class),new Object[] {userId});
	}
public void deleteProfile(int profileId) {
		
		stmt.update("delete from profile where profileid = ? ",profileId);
	}
}
