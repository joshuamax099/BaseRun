package com.coop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.coop.model.AddPayee;
import com.coop.model.FlagStatus;
import com.coop.model.TransferDetails;

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
		String sql = "insert into gr2_payee_details(ga_accno, ga_payee_name,ga_payee_acc_ifsc, ga_payee_accno) values('"
				+ ap.getGa_accno() + "','" + ap.getGa_payee_name() + "','" + ap.getGa_payee_acc_ifsc() + "','"
				+ ap.getGa_payee_accno() + "')";
		System.out.println("DoTEst2");
		return jdbctemplate.update(sql);

	}

	public int addtransactionlog(TransferDetails ap) {
		String sql = "insert into gr2_transaction_log(ga_transaction_no, ga_sender_accno, ga_receiver_accno, ga_transfer_amount, ga_payee_remarks) values('"
				+ ap.getGa_transaction_no() + "','" + ap.getGa_sender_accno() + "','" + ap.getGa_receiver_accno()
				+ "','" + ap.getGa_transfer_amount() + "','" + ap.getGa_payee_remarks() + "')";
		System.out.println("DoTEst3");
		return jdbctemplate.update(sql);

	}

	public int addflagstatus(FlagStatus ap1) {
		String sql = "insert into gr2_flag(ga_transaction_no, ga_sender_accno, ga_receiver_accno, ga_transfer_amount, ga_flag_status) values('"+ ap1.getGa_transaction_no() + "','" + ap1.getGa_sender_accno()+"','" + ap1.getGa_receiver_accno() + "','" + ap1.getGa_transfer_amount() + "','" + ap1.getGa_flag_status() + "')";
		System.out.println("DoTEst4");
		return jdbctemplate.update(sql);

	}

	public int update(AddPayee p, String ano) {
		System.out.println("JDBCHello");
		String sql = "update gr2_payee_details set ga_payee_name='" + p.getGa_payee_name() + "', ga_payee_acc_ifsc='"
				+ p.getGa_payee_acc_ifsc() + "', ga_payee_accno='" + p.getGa_payee_accno() + "' where ga_payee_accno="
				+ ano + "";
		return jdbctemplate.update(sql);
	}

	public String check(String ano) {
		System.out.println("JDBCHello");
		String sql = "select ga_flag_status from gr2_flag where gd_sender_accno=" + ano + "";
		String name = (String) getJdbctemplate().queryForObject(sql, new Object[] { ano }, String.class);
		return name;
	}
	public String checkMax() {
		//System.out.println("JDBCHello");
		String sql = "select max(ga_transaction_no) from gr2_transaction_log";
		String name = (String) getJdbctemplate().queryForObject(sql, String.class);
		System.out.println(name);
		return name;
	}
	public int updatenewbalance(String accno, int newbal) {
		System.out.println("JDBCHello");
		String newbali = String.valueOf(newbal);
		String sql = "update gr2_details set gd_amount='" + newbali + "' where gd_acc_no=" + accno + "";
		return jdbctemplate.update(sql);
	}
	
	/*
	public int updatebalance(String nbal, String ano) {
		System.out.println("JDBCHello");
		String sql = "update gr2_details set gd_amount='" + nbal + "' where gd_acc_no=" + ano + "";
		return jdbctemplate.update(sql);
	}
	*/

	public int updatebal(String p, String ano) {
		System.out.println("JDBCHello28");
		String sql = "update gr2_details set gd_amount='" +p+ "' where gd_acc_no=" + ano + "";
		return jdbctemplate.update(sql);
	}
	

	public FlagStatus validateBalance(String accno) {
		int ak = 1;
		String sql = "select * from gr2_flag where ga_receiver_accno='" + accno + "' and ga_flag_status='"+ak+"'";
		List<FlagStatus> users = jdbctemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	class UserMapper implements RowMapper<FlagStatus> {
		public FlagStatus mapRow(ResultSet rs, int arg1) throws SQLException {
			FlagStatus user = new FlagStatus();
			user.setGa_transaction_no(rs.getString("ga_transaction_no"));
			user.setGa_sender_accno(rs.getString("ga_sender_accno"));
			user.setGa_receiver_accno(rs.getString("ga_receiver_accno"));
			user.setGa_transfer_amount(rs.getString("ga_transfer_amount"));
			user.setGa_flag_status(rs.getString("ga_flag_status"));

			return user;
		}
	}

	public List<AddPayee> getallpayees(String accno) {
		return jdbctemplate.query("select * from gr2_payee_details where ga_accno='"+accno+"'", new RowMapper<AddPayee>() {
			public AddPayee mapRow(ResultSet rs, int row) throws SQLException {
				AddPayee e = new AddPayee();
				e.setGa_accno(rs.getString(1));
				e.setGa_payee_name(rs.getString(2));
				e.setGa_payee_acc_ifsc(rs.getString(3));
				e.setGa_payee_accno(rs.getString(4));
				return e;
			}
		});
	}

	public int deletePayee(int id) {
		String sql = "delete from gr2_payee_details where ga_payee_accno=" + id + "";
		System.out.println(id);
		System.out.println("query executed" + id + " " + sql);

		return jdbctemplate.update(sql);
	}

	public AddPayee getPayeeById(String id) {
		String sql = "select * from gr2_payee_details where ga_payee_accno=?";
		return jdbctemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<AddPayee>(AddPayee.class));
	}

	public String getbalancenow(String id) {
		String sql = "select gd_amount from gr2_details where gd_acc_no=?";
		String name = (String) getJdbctemplate().queryForObject(sql, new Object[] { id }, String.class);

		return name;
	}
	public int deleteflag(int id) {
		String sql = "delete from gr2_flag where ga_transaction_no=" + id + "";
		System.out.println(id);
		System.out.println("query executed" + id + " " + sql);

		return jdbctemplate.update(sql);
	}

}
