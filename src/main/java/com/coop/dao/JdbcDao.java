package com.coop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
		String sql="insert into gr2_payee_details(ga_accno, ga_payee_name,ga_payee_acc_ifsc, ga_payee_accno) values('"+ap.getGa_accno()+"','"+ap.getGa_payee_name()+"','"+ap.getGa_payee_acc_ifsc()+"','"+ap.getGa_payee_accno()+"')";
		System.out.println("DoTEst2");
		return jdbctemplate.update(sql);
		
	}
	public int update(AddPayee p, String ano){ 
		System.out.println("JDBCHello");
	    String sql="update gr2_payee_details set ga_payee_name='"+p.getGa_payee_name() +"', ga_payee_acc_ifsc='"+p.getGa_payee_acc_ifsc()+"', ga_payee_accno='"+p.getGa_payee_accno()+"' where ga_payee_accno="+ano+"";  
	    return jdbctemplate.update(sql);  
	} 
	public List<AddPayee> getallpayees(){  
	    return jdbctemplate.query("select * from gr2_payee_details",new RowMapper<AddPayee>(){  
	        public AddPayee mapRow(ResultSet rs, int row) throws SQLException {  
	        	AddPayee e=new AddPayee();  
	            e.setGa_accno(rs.getString(1));   
	            e.setGa_payee_name(rs.getString(2));   
	            e.setGa_payee_acc_ifsc(rs.getString(3));   
	            e.setGa_payee_accno(rs.getString(4));  
	            return e;  
	        }  
	    });  
	}
	public int deletePayee(int id){  
	    String sql="delete from gr2_payee_details where ga_payee_accno="+id+"";
	    System.out.println(id);
	    System.out.println("query executed"+id+" "+sql);
	    
	    return jdbctemplate.update(sql);  
	}  
	public AddPayee getPayeeById(String id){  
	    String sql="select * from gr2_payee_details where ga_payee_accno=?";  
	    return jdbctemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<AddPayee>(AddPayee.class));  
	}
	

}
