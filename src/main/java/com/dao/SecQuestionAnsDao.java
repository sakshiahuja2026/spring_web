package com.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.SecQuestionAnsBean;

@Repository
public class SecQuestionAnsDao {
	@Autowired
	JdbcTemplate stmt;

	public void addQuestion(SecQuestionAnsBean ansBean) {
		stmt.update("insert into question (question,ans,userid) values (?,?,?)", ansBean.getQuestion(),
				ansBean.getAns(), ansBean.getUserId());
	}
	public List<SecQuestionAnsBean> getQuestionByUser(int userId){
		return stmt.query(
				"select * from  users inner join question on users.userid = question.userid where users.userid = ?",
				new BeanPropertyRowMapper<SecQuestionAnsBean>(SecQuestionAnsBean.class), new Object[] { userId });
	
	}
}
