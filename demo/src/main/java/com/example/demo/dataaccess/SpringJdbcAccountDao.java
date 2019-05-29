package com.example.demo.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public class SpringJdbcAccountDao implements AccountDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getZandaka(String accountNumber) {

		String zandaka = jdbcTemplate.queryForObject("select count(*) from student",String.class);
		//queryForInt・queryForLongは削除されました(Spring5)

		return Integer.parseInt(zandaka);
	}
	public void updateZandaka(Account account) {

		jdbcTemplate.update(
				"update student set name=?,class=? where student_id=?","test","A",1);}

}
