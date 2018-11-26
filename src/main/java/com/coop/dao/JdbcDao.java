package com.coop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.coop.model.AddPayee;

public class JdbcDao {
	@Autowired
	JdbcTemplate jdbctemplate;
	

	public JdbcTemplate getJdbctemplate() {
		System.out.println("DoTEst0");
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	public int addpayee(AddPayee ap) {
		System.out.println("DoTEst1");
		String sql="insert into gr2_payee_details(ga_accno, ga_payee_name,ga_payee_acc_ifsc, ga_payee_accno) values("+ap.getGa_accno()+",'"+ap.getGa_payee_name()+"','"+ap.getGa_payee_acc_ifsc()+"','"+ap.getGa_payee_accno()+"')";
		System.out.println("DoTEst2");
		return jdbctemplate.update(sql);
		
	}

}
